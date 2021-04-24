package com.example.androidversions.ui.mainactivity2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidversions.R
import com.example.androidversions.model.Versions

class MainAdapter2(
    private val items:Array<String>,
    private val dummy: Array<Versions>,
    private val clickUtils: (Versions) -> Unit): RecyclerView.Adapter<MainAdapter2.MainViewHolder>() {
    inner class MainViewHolder(private val view:View): RecyclerView.ViewHolder(view){
        fun bind(data: Versions, dummy:String){
            val listTv = view.findViewById<TextView>(R.id.item_tv)
            listTv.text = dummy

            val apiTv = view.findViewById<TextView>(R.id.api_tv)
            apiTv.text = data.apiLevel.toString()
            itemView.setOnClickListener{ clickUtils(data)}
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

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        return holder.bind(dummy[position], items[position])
    }


}