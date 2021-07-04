package com.example.mybrowser

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.URLUtil
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    lateinit var myWebView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myWebView = findViewById(R.id.myWebView)


        val etURL: EditText = findViewById(R.id.eturl)
        val btnsearch: Button = findViewById(R.id.btn)
        val btnfb: ImageButton = findViewById(R.id.btnfb)
        val btngit: ImageButton = findViewById(R.id.btngit)
        val btnhome: ImageButton = findViewById(R.id.btnhome)
        val btninsta: ImageButton = findViewById(R.id.btninsta)
        val btntweet: ImageButton = findViewById(R.id.btntweet)


        myWebView.webViewClient= WebViewClient()

        myWebView.loadUrl("file:///android_asset/vt.html")

        btnsearch.setOnClickListener {
            val siteUrl: String = etURL.text.toString()
            if(URLUtil.isValidUrl(siteUrl))
            {
                myWebView.loadUrl(siteUrl)
            }
            else
            {
                myWebView.loadUrl("https://www.google.com/search?q=$siteUrl")
            }

        }
        btnfb.setOnClickListener {
            myWebView.loadUrl("https://www.facebook.com")
            etURL.setText("https://www.facebook.com")
        }


        btngit.setOnClickListener {
            myWebView.loadUrl("https://www.github.com")
            etURL.setText("https://www.github.com")
        }

        btnhome.setOnClickListener {
            myWebView.loadUrl("https://www.google.com")
            etURL.setText("https://www.google.com")
        }

        btninsta.setOnClickListener {
            myWebView.loadUrl("https://www.instagram.com")
            etURL.setText("https://www.instagram.com")
        }

        btntweet.setOnClickListener {
            myWebView.loadUrl("https://www.twitter.com")
            etURL.setText("https://www.twitter.com")
        }

        myWebView.settings.javaScriptEnabled = true

    }


    override fun onBackPressed() {
        if(myWebView.canGoBack())
        {
            myWebView.goBack()
        }
        else
        {
            super.onBackPressed()
        }
    }
}