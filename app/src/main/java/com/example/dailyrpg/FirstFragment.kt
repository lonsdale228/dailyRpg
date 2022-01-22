package com.example.dailyrpg

import android.app.ActionBar
import android.app.Activity
import android.app.Application
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import android.widget.*
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_dialog.*
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.single_item.*



class FirstFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    private lateinit var itemArrayList:ArrayList<Item>


    object addItem{

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View? = null
        view = inflater.inflate(R.layout.fragment_first, container, false)



        val imgId= intArrayOf(R.drawable.easy,R.drawable.medium,R.drawable.hard)
        val itemTitle= arrayOf("Сделать ДЗ","Убрать в комнате","Помыть посуду")
        val itemDesc= arrayOf("Чтоб сделать дз не требуется много усилий",
            "Убраться в своей комнате не доставит много трудностей",
            "Насколько же много нужно усилий, чтоб вымыть посуду")

        val listV = view.findViewById<ListView>(R.id.listTimetable)
       // addItemToList("Привет","Это тест",0,listV)

        itemArrayList= ArrayList()
//        for(i in itemTitle.indices){
//            val item = Item(itemTitle[i],itemDesc[i], imgId[i])
//           itemArrayList.add(item)
//        }

//        val listV = view.findViewById<ListView>(R.id.listTimetable)


        listV.adapter = MyAdapter(view.context as Activity,itemArrayList)



        fun addItemToList(title:String,desc:String,imgId:Int,list:ListView,AList:ArrayList<Item>)
        {


            //itemArrayList= ArrayList()

            //AList=ArrayList()

            val img= intArrayOf(R.drawable.easy, R.drawable.medium, R.drawable.hard)


            val item = Item(title, desc, img[imgId])

            AList.add(item)

            (list.adapter as MyAdapter).notifyDataSetChanged()
        }

        addItemToList("Hello","How are u?",0,listV,itemArrayList)

      //  val item = Item("Hello","How are u?", 0)
      //  itemArrayList.add(item)

    //    (listV.adapter as MyAdapter).notifyDataSetChanged()

//        listV.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
//            val itemTitle = itemTitle[position]
//            val itemDesc = itemDesc[position]
//            val imgId = imgId[position]
//
////            val i = Intent(view.context,UserActivity::class.java)
////            i.putExtra("itemTitle",itemTitle)
////            i.putExtra("itemDesc",itemDesc)
////            i.putExtra("itemPic",imgId)
////            startActivity(i)
//        }


       // var listofTimetable= mutableListOf<String>("1","2")
       // var arrAdapter = ArrayAdapter(view.context,R.layout.single_item,R.id.itemTitle,listofTimetable)


        class CustomDialogClass(context: Context) : Dialog(context) {

            init {
                setCancelable(true)
            }

            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                //val win = CustomDialogClass(context).getWindow()
                var img:Int=0
                //win!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT)
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
                        Toast.makeText(context,"Введите название!",Toast.LENGTH_SHORT).show()
                    }
                    else{
                        addItemToList(titleed.toString(),"How are u?",img,listV,itemArrayList)
                        Toast.makeText(context,"Сохранено успешно!",Toast.LENGTH_SHORT).show()
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
        //return inflater.inflate(R.layout.fragment_first, container, false)
    }


}