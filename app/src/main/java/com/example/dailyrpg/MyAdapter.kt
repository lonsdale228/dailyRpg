package com.example.dailyrpg

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text
import java.lang.reflect.Array


class RecyclerViewAdapter(private val itemsList:ArrayList<Item>): RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>(){

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener=listener
    }

    fun moveItem(i:Int,isDone:Boolean){

        itemsList.removeAt(i)
        notifyDataSetChanged()
    }

    fun addItem(i:Int,item:Item){
        itemsList.add(i,item)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.single_item,parent,false)
        return MyViewHolder(itemView,mListener)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = itemsList[position]
        holder.imageView.setImageResource(currentItem.imgId)
        holder.title.text = currentItem.name
        holder.desc.text = currentItem.desc

    }

    override fun getItemCount(): Int {
        return itemsList.size
    }

    class MyViewHolder(itemView:View,listener: onItemClickListener):RecyclerView.ViewHolder(itemView){
        val imageView:ImageView=itemView.findViewById(R.id.itemPic)
        val title:TextView=itemView.findViewById(R.id.itemTitle)
        val desc:TextView=itemView.findViewById(R.id.itemDesc)

        init {
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }
    }

}


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