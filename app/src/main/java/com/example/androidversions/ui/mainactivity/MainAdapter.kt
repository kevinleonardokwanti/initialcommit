package com.example.androidversions.ui.mainactivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidversions.R

class MainAdapter(
    private val items:Array<String>,
    private val clickUtils: (String) -> Unit): RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    var setOnClick: MainActivity.SetOnClick? = null

    inner class MainViewHolder(private val view:View): RecyclerView.ViewHolder(view){
        fun bind(data: String){
            val listTv = view.findViewById<TextView>(R.id.item_tv)
            listTv.text = data

            itemView.setOnClickListener{ setOnClick?.itemClick(data)}
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_list, parent, false)
        return MainViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setOnClick(setOnClick: MainActivity.SetOnClick){
        this.setOnClick = setOnClick
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        return holder.bind(items[position])
    }


}