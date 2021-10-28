package com.example.belajartreding

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.belajartreding.doa.DaftarDoa
import com.example.belajartreding.treding.DaftarTreding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_tambah_data.*

class TambahData : AppCompatActivity() {
    lateinit var ref : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_data)
        ref = FirebaseDatabase.getInstance().getReference("Materi")
        //Test nanti disini

        btn_batal.setOnClickListener(){
            simpan()
        }

        btn_simpan.setOnClickListener() {
            val intent = Intent(this, HomeAdmin::class.java)
            startActivity(intent)
        }


    }

    private fun simpan() {
        et_kategori
        et_addlink
        et_addpenjelasan

        if(et_kategori.text.toString().isEmpty()){
            et_kategori.error = "Masukkan kategori"
            et_kategori.requestFocus()
            return
        }
        if(et_addlink.text.toString().isEmpty()){
            et_addlink.error = "Masukkan kategori"
            et_addlink.requestFocus()
            return
        }
        if(et_addpenjelasan.text.toString().isEmpty()){
            et_addpenjelasan.error = "Masukkan kategori"
            et_addpenjelasan.requestFocus()
            return
        }

        val kategori = et_kategori.text.toString()
        val link = et_addlink.text.toString()
        val penjelasan = et_addpenjelasan.text.toString()
        val tambahdata = ModelTambah(kategori,link,penjelasan)

        ref.child(kategori).setValue(tambahdata).addOnCompleteListener {
            Toast.makeText(this, "Sukses Tambah data ",Toast.LENGTH_LONG).show()
            val intent = Intent(this, HomeAdmin::class.java)
            startActivity(intent)
        }
    }
}