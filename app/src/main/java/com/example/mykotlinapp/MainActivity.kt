package com.example.mykotlinapp


import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.GsonBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException

class POK(val result:Array<String>)
class Result(var name:String,var url:String)
class MainActivity : AppCompatActivity() {
    private var mTextViewResult: TextView? = null
    var myResponse: String? =null
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
                    println(myResponse)
                    val gson=GsonBuilder().create()
                    val  pokeFeed =gson.fromJson(myResponse,POK::class.java)
                    //runOnUiThread { mTextViewResult?.setText(myResponse)
                 }

//                    fun getTextResponse(responseJson: JSONObject): Array<String?> {
//                        val resultData = responseJson.getJSONArray(myResponse)
//                            .getJSONObject(0)
//                            .getJSONArray("result")
//
//                        val arrayList = ArrayList<String>()
//                        for (i in 0..resultData.length()) {
//                            arrayList.add(resultData[i].toString())
//                        }
//
//                        return arrayList.toArray(arrayOfNulls<String>(arrayList.size))
////                    mTextViewResult!!.text = resultData.toString()
//                        runOnUiThread { mTextViewResult?.setText(resultData.toString()) }
//                    }
//                }

            }
        })




//        val pokemonsJSONArray = JSONArray(request.body.toString())
//        (0 until pokemonsJSONArray.length()).forEach {
//            val pokemon = pokemonsJSONArray.getJSONObject(it)
//            println("${pokemon.get("name")} by ${pokemon.get("id")}")
//        }


//        val data = StringBuilder()
//        val jsonObject = JSONObject(myResponse)
//        val jsonArray = jsonObject.getJSONArray("results")
//        for (i in 0 until jsonArray.length()) {
//            val jsonObject = jsonArray.getJSONObject(i)
//            val id = jsonObject.get("id")
//            val name = jsonObject.get("name")
//            data.append(id).append(name)
//        }
//        mTextViewResult!!.text = data.toString()


       // mTextViewResult!!.text = resultData.toString()
    }
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











