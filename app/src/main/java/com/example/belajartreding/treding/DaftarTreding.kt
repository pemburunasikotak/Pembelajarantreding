package com.example.belajartreding.treding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.belajartreding.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class DaftarTreding : AppCompatActivity() {
    private var list : MutableList<ModelTreding> = ArrayList()
    private lateinit var rvData: RecyclerView
    var myRef = FirebaseDatabase.getInstance().getReference("Materi")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar)
        rvData = findViewById(R.id.rv_nyanyian)
        rvData.setHasFixedSize(true)
        fungsiRecyleView()
    }

    private fun fungsiRecyleView() {
        val listadapter = AdapterTreding(this,list)
        rvData.adapter = listadapter
        rvData.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        //deklarasi untuk Database
        //isi data di RV
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (snap in snapshot.children) {
                    val x = snap.getValue(ModelTreding::class.java)
                    //Log.e("testsoal", Gson().toJson(x))
                    list.add(x!!)
                    listadapter.notifyDataSetChanged()
                }
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

    }
}