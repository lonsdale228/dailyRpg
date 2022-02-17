package com.example.dailyrpg

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dailyrpg.db.ItemsModel
import com.example.dailyrpg.db.MyDbManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_dialog.*
import kotlinx.android.synthetic.main.fragment_disabled_item.*

class active_item : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    private lateinit var itemArrayList:ArrayList<Item>

    private lateinit var activeItemArrayList: ArrayList<Item>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view: View? = null
        view = inflater.inflate(R.layout.fragment_active_item, container, false)

        val listTimetable = view.findViewById<RecyclerView>(R.id.listTimetable)

        val myDbManager = MyDbManager(view.context)


        var imageId:Array<Int>
        var title:Array<String>

        imageId= arrayOf(
            com.example.dailyrpg.R.drawable.easy,
            com.example.dailyrpg.R.drawable.medium,
            com.example.dailyrpg.R.drawable.hard)

        val newRecyclerview= view.findViewById<RecyclerView>(R.id.listTimetable)

        title = arrayOf("Hello","How are u?","Goodbye")

        newRecyclerview.layoutManager = LinearLayoutManager(view.context)

        newRecyclerview.setHasFixedSize(true)
        activeItemArrayList = arrayListOf<Item>()

        fun getUserData() {
            var adapter=RecyclerViewAdapter(activeItemArrayList)
            val swipegesture = object :SwipeGesture(view.context){
                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    when(direction){
                        ItemTouchHelper.LEFT->{
                            adapter.moveItem(viewHolder.adapterPosition,true)
                        }
                        ItemTouchHelper.RIGHT->{
                            val archiveItem=activeItemArrayList[viewHolder.adapterPosition]
                            adapter.moveItem(viewHolder.adapterPosition,true)
                            adapter.addItem(activeItemArrayList.size,archiveItem)
                        }
                    }
                }
            }
            val touchHelper = ItemTouchHelper(swipegesture)
            touchHelper.attachToRecyclerView(newRecyclerview)
            newRecyclerview.adapter=adapter
            adapter.setOnItemClickListener(object:RecyclerViewAdapter.onItemClickListener{
                override fun onItemClick(position: Int) {
                    Toast.makeText(view.context,"Hello World!!!$position",Toast.LENGTH_SHORT).show()
                }
            })
        }

        getUserData()

        //add item to recyclerView ActiveItem
//        fun addItemToList(title:String, desc:String, imgId:Int, recyclView:RecyclerView, AList:ArrayList<Item>)
//        {
//            val img= intArrayOf(R.drawable.easy, R.drawable.medium, R.drawable.hard)
//            val item = Item(title, desc, img[imgId])
//            AList.add(item)
//            recyclView.adapter?.notifyDataSetChanged()
//        }


        val dataList:ArrayList<ItemsModel> = myDbManager.getEverything()

        for (item in dataList){
            manageList.addItemToList(item.name,item.desc,item.difficulty,listTimetable,activeItemArrayList)

        }

       // addItemToList("biba","boba",2,listTimetable,activeItemArrayList)

        class CustomDialogClass(context: Context) : Dialog(context) {

            init {
                setCancelable(true)
            }

            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                var img:Int=0
                requestWindowFeature(Window.FEATURE_NO_TITLE)
                setContentView(R.layout.activity_dialog)

                val edTitle=findViewById<EditText>(R.id.edName)
                var titleed=edTitle.text

                val rg = findViewById<RadioGroup>(R.id.rgDifficulty)
                val checked=rg.checkedRadioButtonId
                rg.setOnCheckedChangeListener{ group, checkedId ->
                    when(checkedId){
                        R.id.rgBtnEasy -> img = 0
                        R.id.rgBtnMedium -> img = 1
                        R.id.rgBtnHard -> img = 2
                    }

                }



                btnSave.setOnClickListener(){
                    if (titleed.isEmpty()){
                        Toast.makeText(context,"Введите название!", Toast.LENGTH_SHORT).show()
                    }
                    else{
                        manageList.addItemToList(titleed.toString(),"Здесь могла быть Ваша реклама",img,listTimetable,activeItemArrayList)

                        myDbManager.openDb()
                        myDbManager.insertToDb(ItemsModel(difficulty = img,name=titleed.toString(),desc="Hello World!"))
                        myDbManager.closeDb()

                        Toast.makeText(context,"Сохранено успешно!", Toast.LENGTH_SHORT).show()
                        onBackPressed()
                    }

                }
                val animZoomIn = AnimationUtils.loadAnimation(context, R.anim.zoom_in)
                btnSave.startAnimation(animZoomIn)


            }
        }


        val btn = view.findViewById<FloatingActionButton>(R.id.floatingActionButton2)

        btn.setOnClickListener(){
            val animRotate = AnimationUtils.loadAnimation(context, R.anim.rotate_refresh)
            btn.startAnimation(animRotate)
            CustomDialogClass(view.context).show()
        }


        return view
    }


}