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
//        val list= list[position]
//        holder.tv_name.text = list.name
//
//        holder.itemView.setOnClickListener {
//            val bundel = Bundle()
//            bundel.putString("id", list.id)
//            bundel.putString("nama", list.name)
//            bundel.putString("link", list.link)
//            val intent = Intent(context, DetailDoa::class.java)
//            intent.putExtras(bundel)
//            context.startActivity(intent)
//        }

    }

    override fun getItemCount():Int {
        return  items.size
    }


    inner class HomePemesanHolder(view: View) : RecyclerView.ViewHolder(view) {
//        var tv_name: TextView = view.findViewById(R.id.tv_doa)
        fun bind(modeldoa: ModelDoa, clickListener: (ModelDoa) -> Unit){
            itemView.tv_doa.text = modeldoa.name
//            itemView.tv_list_name.text =person.email
            itemView.setOnClickListener {
                clickListener(modeldoa)
            }
}

    }
}