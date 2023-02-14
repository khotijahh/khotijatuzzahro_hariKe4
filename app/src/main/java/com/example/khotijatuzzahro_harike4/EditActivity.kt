package com.example.khotijatuzzahro_harike4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EditActivity(private val dataSet: MutableList<DataKalku>):
        RecyclerView.Adapter<EditActivity.DataKalkuHolder>(){
    class DataKalkuHolder(view: View):RecyclerView.ViewHolder(view) {
        val txtHasil = view.findViewById<TextView>(R.id.hasil)
        val bil1 = view.findViewById<TextView>(R.id.Bil1)
        val bil2 = view.findViewById<TextView>(R.id.bil2)
        val hapus = view.findViewById<ImageView>(R.id.icDelete)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataKalkuHolder {
       val view = LayoutInflater.from(parent.context).inflate(
           R.layout.activity_edit,parent,false
       )
        return DataKalkuHolder(view)
    }
    override fun onBindViewHolder(holder: DataKalkuHolder, position: Int) {
       val data = dataSet[position]
        holder.txtHasil.text = dataSet[position].hasil
        holder.bil1.text = dataSet[position].Bil1
        holder.bil2.text = dataSet[position].Bil2
        holder.hapus.setOnClickListener{
            dataSet.removeAt(position)
            notifyItemRangeRemoved(position,dataSet.size)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}