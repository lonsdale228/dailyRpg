package com.example.dailyrpg.db

import android.provider.BaseColumns

object MyDbNameClass:BaseColumns {
    const val TABLE_NAME = "my_table"


    const val ID = "id"
    const val COLUMN_NAME_NAME = "name"
    const val COLUMN_NAME_DIFFICULTY="difficulty"

    const val COLUMN_NAME_DESC = "desc"

    const val DATABASE_VERSION = 1
    const val DATABASE_NAME = "tasks.db"


    const val CREATE_TABLE = "CREATE TABLE IF NOT EXISTS $TABLE_NAME (" +
            "$ID INTEGER PRIMARY KEY,$COLUMN_NAME_DIFFICULTY INT,$COLUMN_NAME_NAME TEXT,$COLUMN_NAME_DESC TEXT)"

    const val SQL_DELETE_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
}