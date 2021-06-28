package com.example.doaagamahindu

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebView
import android.widget.Button
import android.widget.Toast
import com.example.doaagamahindu.nyanyian.DaftarNyanyian
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView
import kotlinx.android.synthetic.main.activity_detail_nyanyian.*

class DetailNyanyian :  YouTubeBaseActivity(){
    private lateinit var webView: WebView
    private lateinit var btn:Button
    private lateinit var yutube:YouTubePlayerView

    companion object{
        //val VIDEO_ID:String = "eSM_YkWeS7k"
        val YUTUBE_API_KEY:String ="AIzaSyBqXcZLDG8u_hN-xCfWktJu5aqbifCj844"

    }
    lateinit var youtubeplayerinit: YouTubePlayer.OnInitializedListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_nyanyian)
        val bundle = intent.extras

        tv_nyanyiandetail.setText((bundle?.getString("nama")))
        tv_nyanyianiddetail.setText((bundle?.getString("id")))
        tv_nyanyianlinkdetail.setText((bundle?.getString("link")))

        val link =  tv_nyanyianlinkdetail.text.toString()

        Log.d("test",link)

        kembali.setOnClickListener {
            val intent = Intent(this, DaftarNyanyian::class.java)
            startActivity(intent)
        }
        initUi()


//        webView = findViewById(R.id.webViewNyanyian)
//        webView.settings.setJavaScriptEnabled(true)
//        webView.webViewClient = object : WebViewClient() {
//            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
//                if (url != null) {
//                    view?.loadUrl(url)
//                }
//                return true
//            }
//        }
//        webView.loadUrl("https://www.youtube.com/$link")
    }

    private fun initUi() {
        val link =  tv_nyanyianlinkdetail.text.toString()
        youtubeplayerinit = object :YouTubePlayer.OnInitializedListener{
            override fun onInitializationSuccess(
                p0: YouTubePlayer.Provider?,
                youtubePlayer: YouTubePlayer?,
                p2: Boolean
            ) {
                youtubePlayer?.loadVideo(link)
            }

            override fun onInitializationFailure(
                p0: YouTubePlayer.Provider?,
                p1: YouTubeInitializationResult?
            ) {
                Toast.makeText(applicationContext,"Ada yang salah",Toast.LENGTH_SHORT).show()
            }

        }
        play.setOnClickListener(View.OnClickListener {v->
            ytplayernyanyian.initialize(YUTUBE_API_KEY, youtubeplayerinit)
        })
    }


}