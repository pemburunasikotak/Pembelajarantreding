package com.example.belajartreding

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.belajartreding.doa.DaftarDoa
import com.example.belajartreding.treding.DaftarTreding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btn_masuk_login.setOnClickListener {
           login()
        }
        btn_masuk_tanpa_login.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
    private fun login() {
        if (et_email.text.toString().isEmpty()) {
            et_email.error = "Masukkan Email"
            et_email.requestFocus()
            return
        }
//        if (!Patterns.EMAIL_ADDRESS.matcher(et_email.text.toString()).matches()) {
//            et_email.error = "Masukkan Email Valid"
//            et_email.requestFocus()
//        }
        if (et_passwd.text.toString().isEmpty()) {
            et_passwd.error = "Masukkan Email"
            et_passwd.requestFocus()
            return
        }

        //deklarasi variabel yang digunakan
        val email =et_email.text.toString().trim()
        val pasword= et_passwd.text.toString()

        //query ke database firebase table Admin dengan chilnya adalah email
        var query = FirebaseDatabase.getInstance().getReference("User").orderByChild("email").equalTo(email)
        query.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (snap in snapshot.children) {
                        val x = snap.getValue(User::class.java)
//                        Log.e("test", Gson().toJson(x))
                        //Cek pAssword login
                        if (x!!.password.equals(pasword.trim())) {
                            val intent = Intent(this@Login, HomeAdmin::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this@Login, "User Tidak Ditemukan", Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}