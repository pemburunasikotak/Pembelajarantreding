package com.example.belajartreding

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.example.belajartreding.doa.DaftarDoa
import com.example.belajartreding.treding.DaftarTreding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_keluar.setOnClickListener {
            alertClick(btn_keluar)
        }
        btn_daftarnyanyian.setOnClickListener {
            val intent = Intent(this, DaftarTreding::class.java)
            startActivity(intent)
        }
//        btn_daftardoa.setOnClickListener {
//            val intent = Intent(this, DaftarDoa::class.java)
//            startActivity(intent)
//        }

    }

     fun alertClick(view: View){
        AlertDialog.Builder(this)
                .setTitle("Anda Yakin!!")
                .setMessage("Keluar applikasi")
                .setPositiveButton("Ya", DialogInterface.OnClickListener { dialogInterface, i ->
                    finish()
                    System.exit(0)
                })
                .setNegativeButton("No", DialogInterface.OnClickListener { dialogInterface, i ->

                })
                .show()
    }
}