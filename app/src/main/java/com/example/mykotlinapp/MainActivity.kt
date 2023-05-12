package com.example.mykotlinapp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okio.IOException


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val client = OkHttpClient()
//        fun get() {
//            val request = Request.Builder().url("https://publicobject.com/helloworld.txt")
//                .build()
//            try {
//                client.newCall(request).execute().use { response ->
//                    if (!response.isSuccessful) {
//                        throw IOException("Запрос к серверу не был успешен:" + "${response.code} ${response.message}")
//                    }
//                  response.header("Server")
//                    response.body!!.string()
//                }
//            } catch (e: IOException) {
//                println("Ошибка подключения: $e")
//            }
//        }

        val jsonRequest ="some request"
        val JSON ="application/json; charset=utf-8".toMediaType()

        val client = OkHttpClient()
        fun post() {
            val body: RequestBody = jsonRequest.toRequestBody(JSON)
            val request =
                Request.Builder().url("https://publicobject.com/helloworld.txt").post(body).build()


            try {
                client.newCall(request).execute().use { response ->
                    if (!response.isSuccessful) {
                        throw IOException(
                            "Запрос к серверу не был успешен:" +
                                    " ${response.code} ${response.message}"
                        )
                    }
                    response.body!!.string()
                }
            } catch (e: IOException) {
                println("Ошибка подключения: $e")
            }
        }




        // get reference to button
        val btn = findViewById<Button>(R.id.btn)
        btn.setOnClickListener {
//            Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()
//            get()
            post()
        }
    }
}








