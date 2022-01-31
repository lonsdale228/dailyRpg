package com.example.dailyrpg

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class disabled_item : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private lateinit var newArrayList: ArrayList<Item>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View? = null
        view = inflater.inflate(R.layout.fragment_disabled_item, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)



        var imageId:Array<Int>
        var title:Array<String>

        imageId= arrayOf(
            com.example.dailyrpg.R.drawable.easy,
            com.example.dailyrpg.R.drawable.medium,
            com.example.dailyrpg.R.drawable.hard)

        val newRecyclerview= view.findViewById<RecyclerView>(R.id.recyclerView)

        title = arrayOf("Hello","How are u?","Goodbye")

        newRecyclerview.layoutManager = LinearLayoutManager(view.context)

        newRecyclerview.setHasFixedSize(true)
        newArrayList = arrayListOf<Item>()

        fun getUserData() {

            for(i in imageId.indices){
                val item = Item("title[i]","Hello world!", imageId[i])
                newArrayList.add(item)
            }


            var adapter=RecyclerViewAdapter(newArrayList)

            val swipegesture = object :SwipeGesture(view.context){
                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                    when(direction){
                        ItemTouchHelper.LEFT->{
                            adapter.moveItem(viewHolder.adapterPosition,true)
                        }
                        ItemTouchHelper.RIGHT->{
                            val archiveItem=newArrayList[viewHolder.adapterPosition]
                            adapter.moveItem(viewHolder.adapterPosition,true)
                            adapter.addItem(newArrayList.size,archiveItem)
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





        return view
    }




}