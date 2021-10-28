package com.example.belajartreding

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.webkit.WebView
import android.widget.Button
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.belajartreding.R
import com.example.belajartreding.doa.DaftarDoa
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView
import kotlinx.android.synthetic.main.activity_detail_doa.*
import java.lang.Exception


class DetailDoa : AppCompatActivity() {

    private  var mp:MediaPlayer?= null

    //private  var suara:MutableList<Int> = mutableListOf(R.raw.bangun_pagi)
    @SuppressLint("ResourceType", "UseValueOf")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_doa)

        val bundle = intent.extras
        tv_doadetail.setText((bundle?.getString("name")))
        tv_textdoa.setText((bundle?.getString("doatext")))
        tv_doaarti.setText((bundle?.getString("doaarti")))
        tv_link.setText((bundle?.getInt("lagu")!!))
        val suara = bundle?.getInt("lagu")

        controlsuara(id = suara)

    }

    private fun controlsuara(id : Int) {
        btn_pausedoa.setOnClickListener {

            if (mp !==null)mp?.pause()
            Log.d("DetailDoa","Pause at : ${mp!!.currentPosition/100} seconds")
        }
        playdoa.setOnClickListener {
            if (mp==null){
                mp = MediaPlayer.create(this, id)
                initialiseSeekBar()
            }
            mp?.start()
        }
        kembalidoa.setOnClickListener {
            if (mp !== null){
                mp?.stop()
                mp?.reset()
                mp?.release()
                mp = null
            }
        }

        seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser)mp?.seekTo(progress)

            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })

    }
    private fun initialiseSeekBar(){
        seekbar.max = mp!!.duration
        val handler = Handler()
        handler.postDelayed(object : Runnable{
            override fun run(){
                try {
                    seekbar.progress = mp!!.currentPosition
                    handler.postDelayed(this, 1000)
                }catch (e: Exception){
                    seekbar.progress = 0
                }

            }
        },0)
    }


//
//
//    public fun initUi() {
//        val link =  tv_link.text.toString()
//        youtubeplayerinit = object : YouTubePlayer.OnInitializedListener{
//            override fun onInitializationSuccess(p0: YouTubePlayer.Provider?, youtubePlayer: YouTubePlayer?, p2: Boolean) {
//                youtubePlayer?.loadVideo(link)
//            }
//
//            override fun onInitializationFailure(
//                    p0: YouTubePlayer.Provider?,
//                    p1: YouTubeInitializationResult?
//            ) {
//                Toast.makeText(applicationContext,"Ada yang salah", Toast.LENGTH_SHORT).show()
//            }
//
//        }
//        playdoa.setOnClickListener({ v->
//            ytplayerdoa.initialize(DetailNyanyian.YUTUBE_API_KEY, youtubeplayerinit)
//        })
//    }
}