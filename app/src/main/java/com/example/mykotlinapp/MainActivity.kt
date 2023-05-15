package com.example.mykotlinapp


import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException


class MainActivity : AppCompatActivity() {
    private var mTextViewResult: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mTextViewResult = findViewById<TextView>(R.id.text_view_result)
        val client = OkHttpClient()
        val request: Request = Request.Builder()
            .url("https://pokeapi.co/api/v2/pokemon")
            .build()
        client.newCall(request).enqueue(object : Callback {
            override  fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            @Throws(java.io.IOException::class)
            override  fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    val myResponse = response.body!!.string()
                    runOnUiThread { mTextViewResult?.setText(myResponse) }
                }
            }

        })
    }



//        val client = OkHttpClient()
//        fun get() {
//            val request = Request.Builder().url("https://pokeapi.co/api/v2/pokemon")
//                .build()
//            try {
//                client.newCall(request).execute().use { response ->
//                    if (!response.isSuccessful) {
//                        throw IOException("Запрос к серверу не был успешен:" + "${response.code} ${response.message}")
//                    }
//                    response.header("limber")
//                    response.body!!.string()
//                }
//            } catch (e: IOException) {
//                println("Ошибка подключения: $e")
//            }
//        }
//
//        val mListView = findViewById<ListView>(R.id.list_view_1)
//        val arrayAdapter: ArrayAdapter<*>
//        val mItems = arrayOf(
//            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
//            "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"
//        )
//
//        // Creating an adapter for ListView
//        val mAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, mItems)
//
//        // Inflating the Footer file
//        val mFooter = layoutInflater.inflate(R.layout.footer, mListView, false) as ViewGroup
//
//        // Adding the footer to the ListView
//        mListView.addFooterView(mFooter)
//
//        // Setting the adapter
//        mListView.adapter = mAdapter
//        mListView.setOnClickListener()
//    }
//}




    // Создание объекта Moshi,
// для Kotlin необходимо добавлять KotlinJsonAdapterFactory
//    val moshi = Moshi.Builder()
//        .add(KotlinJsonAdapterFactory()).build()
//    // Создание адаптера
//    val jsonAdapterRequest = moshi.adapter(SomeClass::class.java)
//    // Сериализация, SomeClassInstance - экземляр класса SomeClass
//    val jsonRequest = jsonAdapterRequest.toJson(SomeClassInstance)
//        val jsonRequest ="some request"
//        val JSON ="application/json; charset=utf-8".toMediaType()
//
//        val client = OkHttpClient()
//        fun post() {
//            val body: RequestBody = jsonRequest.toRequestBody(JSON)
//            val request =
//                Request.Builder().url(" https://pokeapi.co/api/v2/pokemon/ditto").post(body).build()
//
//
//            try {
//                client.newCall(request).execute().use { response ->
//                    if (!response.isSuccessful) {
//                        throw IOException(
//                            "Запрос к серверу не был успешен:" +
//                                    " ${response.code} ${response.message}"
//                        )
//                    }
//                    response.body!!.string()
//                }
//            } catch (e: IOException) {
//                println("Ошибка подключения: $e")
//            }
//        }




        // get reference to button
    //    val btn = findViewById<Button>(R.id.btn)
//        btn.setOnClickListener {
//            println("Ошибка подключения:")
//            Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()
//            get()
////            post()
//        }
    }










