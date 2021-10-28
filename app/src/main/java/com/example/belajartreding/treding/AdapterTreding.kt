package com.example.belajartreding.treding

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.belajartreding.Detail
import com.example.belajartreding.R

class AdapterTreding(private val context: Context, private val list:List<ModelTreding>)
    :RecyclerView.Adapter<AdapterTreding.HomePemesanHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomePemesanHolder {
        val view: View= LayoutInflater.from(parent.context).inflate(
                R.layout.list_daftar_nyanyian, parent, false
        )
        return HomePemesanHolder(view)
    }

    override fun onBindViewHolder(holder: HomePemesanHolder, position: Int) {
        val list= list[position]
        holder.tv_name.text = list.name

        holder.itemView.setOnClickListener {
            val bundel = Bundle()
            bundel.putString("id", list.id)
            bundel.putString("nama", list.name)
            bundel.putString("link", list.link)
            bundel.putString("materi", list.materi)
            val intent = Intent(context, Detail::class.java)
            intent.putExtras(bundel)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int =list.size

    inner class HomePemesanHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tv_name: TextView = view.findViewById(R.id.tv_nyanyian)

    }
}