package com.example.doaagamahindu.doa

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.doaagamahindu.DetailDoa
import com.example.doaagamahindu.R
import kotlinx.android.synthetic.main.list_daftar_doa.view.*

class AdapterDoa(val items: List<ModelDoa>
                 , val clickListener: (ModelDoa) -> Unit)
    :RecyclerView.Adapter<AdapterDoa.HomePemesanHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterDoa.HomePemesanHolder {
        val view: View= LayoutInflater.from(parent.context).inflate(
                R.layout.list_daftar_doa, parent, false
        )
        return HomePemesanHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterDoa.HomePemesanHolder, position: Int) {
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