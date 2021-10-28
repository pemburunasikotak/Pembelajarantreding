package com.example.belajartreding.doa

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.belajartreding.R
import kotlinx.android.synthetic.main.list_daftar_doa.view.*

class AdapterDoa(val items: List<ModelDoa>
                 , val clickListener: (ModelDoa) -> Unit)
    :RecyclerView.Adapter<AdapterDoa.HomePemesanHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomePemesanHolder {
        val view: View= LayoutInflater.from(parent.context).inflate(
                R.layout.list_daftar_doa, parent, false
        )
        return HomePemesanHolder(view)
    }

    override fun onBindViewHolder(holder: HomePemesanHolder, position: Int) {
        holder.bind(items[position],clickListener)
    }

    override fun getItemCount():Int {
        return  items.size
    }


    inner class HomePemesanHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(modeldoa: ModelDoa, clickListener: (ModelDoa) -> Unit){
            itemView.tv_doa.text = modeldoa.name
            itemView.setOnClickListener {
                clickListener(modeldoa)
            }
}

    }
}