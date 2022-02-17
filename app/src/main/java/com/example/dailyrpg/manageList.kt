package com.example.dailyrpg

import androidx.recyclerview.widget.RecyclerView

object manageList {
    fun addItemToList(title:String, desc:String, imgId:Int, recyclView: RecyclerView, AList:ArrayList<Item>)
    {
        val img= intArrayOf(R.drawable.easy, R.drawable.medium, R.drawable.hard)

        val item = Item(title, desc, img[imgId])
        AList.add(item)
        recyclView.adapter?.notifyDataSetChanged()
    }
    fun moveToArchive(arrActive:ArrayList<Item>,arrDisable:ArrayList<Item>){
       // MyAdapter.mo
    }

}