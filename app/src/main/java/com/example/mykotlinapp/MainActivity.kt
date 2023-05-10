package com.example.mykotlinapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import okhttp3.Call
import okhttp3.Callback
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response
import java.io.IOException

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val client: OkHttpClient = OkHttpClient()
        val getUrl = "https://demo.codeseasy.com/apis/okhttp/get.php?key_name=value"
        val postUrl = "https://demo.codeseasy.com/apis/okhttp/post.php"
        val textView: TextView = findViewById(R.id.textData)
        var buttonGet: Button = findViewById(R.id.btnGet)
        var buttonPost: Button = findViewById(R.id.btnPost)




        fun get(){
            val request: Request = Request.Builder().url(getUrl).build()
            client.newCall(request).enqueue(object : Callback
            {
                override fun onFailure(call: Call, e: IOException) {
                    e.printStackTrace()
                }

                override fun onResponse(call: Call, response: Response) {
                    runOnUiThread(
                        fun(){
                            try {
                                textView.setText(response.body?.string())
                            }catch ( e:IOException){
                                e.printStackTrace()
                            }
                        }
                    )
                }
            }
            )
        }
        fun post(){
            val requestBody: FormBody = FormBody.Builder()
                .add(name = "key_name", value = "Demo Value")
                .build()
            val request:Request =Request.Builder().url(postUrl).post(requestBody).build()
            client.newCall(request).enqueue(object : Callback
            {
                override fun onFailure(call: Call, e: IOException) {
                    e.printStackTrace()
                }

                override fun onResponse(call: Call, response: Response) {
                    runOnUiThread(
                        fun(){
                            try {
                                textView.text = response.body?.string()
                            }catch ( e:IOException){
                                e.printStackTrace()
                            }
                        }
                    )
                }
            }
            )
        }

        buttonGet.setOnClickListener {
            fun onClick(view: View) {
get()
            }
        }

        buttonPost.setOnClickListener {
            fun onClick(view: View) {
                post()
            }
        }
    }

        }

