package com.example.doaagamahindu

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.doaagamahindu.doa.DaftarDoa
import com.example.doaagamahindu.nyanyian.DaftarNyanyian
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_keluar.setOnClickListener {
            alertClick(btn_keluar)
        }
        btn_daftarnyanyian.setOnClickListener {
            val intent = Intent(this, DaftarNyanyian::class.java)
            startActivity(intent)
        }
        btn_daftardoa.setOnClickListener {
            val intent = Intent(this, DaftarDoa::class.java)
            startActivity(intent)
        }

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