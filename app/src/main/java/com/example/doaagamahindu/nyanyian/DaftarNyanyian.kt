package com.example.doaagamahindu.nyanyian

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.doaagamahindu.R
import com.example.doaagamahindu.doa.AdapterDoa
import com.example.doaagamahindu.doa.ModelDoa
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class DaftarNyanyian : AppCompatActivity() {
    private var list : MutableList<ModelNyanyian> = ArrayList()
    private lateinit var rvData: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar_nyanyian)

        rvData = findViewById(R.id.rv_nyanyian)
        rvData.setHasFixedSize(true)
        fungsiRecyleView()
    }

    private fun fungsiRecyleView() {
        val listadapter = AdapterNyanyian(this,list)
        rvData.adapter = listadapter
        rvData.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        //deklarasi untuk Database
        var myRef = FirebaseDatabase.getInstance().getReference("Nyanyian")
        //isi data di RV
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (snap in snapshot.children) {
                    val x = snap.getValue(ModelNyanyian::class.java)
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