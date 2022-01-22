package com.example.dailyrpg

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text
import java.lang.reflect.Array

class MyAdapter(private val context :Activity, private val arrayList: ArrayList<Item> ):ArrayAdapter<Item>(context,R.layout.single_item,arrayList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater:LayoutInflater = LayoutInflater.from(context)
        val view:View = inflater.inflate(R.layout.single_item,null)
        val imageView:ImageView = view.findViewById(R.id.itemPic)
        val title:TextView=view.findViewById(R.id.itemTitle)
        val desc:TextView= view.findViewById(R.id.itemDesc)

        imageView.setImageResource(arrayList[position].imgId)
        title.text=arrayList[position].name
        desc.text=arrayList[position].desc

        return view
    }

}