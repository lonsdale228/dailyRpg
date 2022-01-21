package com.example.dailyrpg

import android.app.Application
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_first.*



class FirstFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }
    fun append(arr: Array<Int>, element: Int): Array<Int> {
        val list: MutableList<Int> = arr.toMutableList()
        list.add(element)
        return list.toTypedArray()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View? = null
        view = inflater.inflate(R.layout.fragment_first, container, false)
        // Inflate the layout for this fragment

       // val context: Context = MainApplication.applicationContext()

        //val context = requireContext()




        var l= mutableListOf<String>("1","2")


        //var colorArrays = resources.getStringArray(R.array.region1)

        var arrAdapter = ArrayAdapter(view.context,android.R.layout.simple_list_item_1,l)
        val listV = view.findViewById<ListView>(R.id.listTimetable)
        listV.adapter = arrAdapter



        val btn = view.findViewById<FloatingActionButton>(R.id.floatingActionButton2)


        btn.setOnClickListener(){

            l.add((l.size+1).toString())
            listV.adapter=null
            arrAdapter=ArrayAdapter(view.context,android.R.layout.simple_list_item_1,l)
            listV.adapter=arrAdapter
            arrAdapter.notifyDataSetChanged()
        }

        listV.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val selectedItemText = parent.getItemAtPosition(position)
            Toast.makeText(view.context,l[position],Toast.LENGTH_SHORT).show()
        }


        return view
        //return inflater.inflate(R.layout.fragment_first, container, false)
    }


}