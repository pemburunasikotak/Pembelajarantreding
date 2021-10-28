package com.example.belajartreding

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.belajartreding.doa.DaftarDoa
import com.example.belajartreding.treding.DaftarTreding
import kotlinx.android.synthetic.main.activity_admin_login.*
import kotlinx.android.synthetic.main.activity_main.*

class HomeAdmin:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_login)
        btn_tambah.setOnClickListener {
            val intent = Intent(this, TambahData::class.java)
            startActivity(intent)
        }

    }
}