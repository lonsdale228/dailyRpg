package com.example.dailyrpg.db

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import java.lang.Exception

class MyDbManager(val context: Context) {
    val myDbHelper = MyDbHelper(context)
    var db:SQLiteDatabase? = null


    //open db
    fun openDb(){
        db = myDbHelper.writableDatabase

    }

    //write to db
//    fun insertToDb(difficulty:Int,name:String,content:String){
//        val values = ContentValues().apply {
//            put(MyDbNameClass.ID,difficulty)
//            put(MyDbNameClass.COLUMN_NAME_DIFFICULTY,difficulty)
//            put(MyDbNameClass.COLUMN_NAME_NAME,name)
//            put(MyDbNameClass.COLUMN_NAME_DESC,content)
//        }
//        db?.insert(MyDbNameClass.TABLE_NAME, null, values)
//    }

    fun insertToDb(itm: ItemsModel):Long{
        val db = myDbHelper.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(MyDbNameClass.ID,itm.id)
        contentValues.put(MyDbNameClass.COLUMN_NAME_DIFFICULTY,itm.difficulty)
        contentValues.put(MyDbNameClass.COLUMN_NAME_NAME,itm.name)
        contentValues.put(MyDbNameClass.COLUMN_NAME_DESC,itm.desc)

        val success=db.insert(MyDbNameClass.TABLE_NAME,null,contentValues)
        db.close()
        return success
    }


    //test
//    @SuppressLint("Range")
//    fun getFromDb():ArrayList<String>{
//        val dataList = ArrayList<String>()
//
//        val cursor = db?.query(
//            MyDbNameClass.TABLE_NAME,
//            null,
//            null,
//            null,
//            null,
//            null,
//            null
//        )
//
//
//        with(cursor){
//            while(cursor?.moveToNext()!!){
//                val dataText = cursor.getString(cursor.getColumnIndex(MyDbNameClass.COLUMN_NAME_NAME))
//                dataList.add(dataText.toString())
//            }
//        }
//
//        cursor?.close()
//        return dataList
//    }

   // @SuppressLint("Range")

    fun removeFromDb(id:Int){
        val db = myDbHelper.writableDatabase
        //db.execSQL()
    }

    fun getEverything(): ArrayList<ItemsModel>{

        val itmList: ArrayList<ItemsModel> = ArrayList()
        val selectQuery="SELECT * FROM ${MyDbNameClass.TABLE_NAME}"
        val db = myDbHelper.readableDatabase

        val cursor: Cursor?
        try {
            cursor=db.rawQuery(selectQuery,null)
        } catch (e:Exception){
            e.printStackTrace()
            db.execSQL(selectQuery)
            return ArrayList()
        }
        var id:Int
        var difficulty:Int
        var name:String
        var desc:String

        if (cursor.moveToFirst()){
            do {
                id=cursor.getInt(cursor.getColumnIndexOrThrow("id"))
                difficulty=cursor.getInt(cursor.getColumnIndexOrThrow("difficulty"))
                name=cursor.getString(cursor.getColumnIndexOrThrow("name"))
                desc=cursor.getString(cursor.getColumnIndexOrThrow("desc"))

                val itm = ItemsModel(id=id,difficulty=difficulty,name=name,desc=desc)

                itmList.add(itm)

            }while (cursor.moveToNext())
        }
        return itmList
    }

    fun closeDb(){
        myDbHelper.close()
    }

}