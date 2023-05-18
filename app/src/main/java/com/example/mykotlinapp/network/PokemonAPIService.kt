package com.example.mykotlinapp.network


import android.os.Bundle
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.json.JSONObject
import java.io.IOException


class PokemonAPIService {

    val arr = ArrayList<String>()
    fun requestPokApi() {
        val client = OkHttpClient()
        val request: Request = Request.Builder()
            // .url("https://pokeapi.co/api/v2/pokemon")
            .url("https://raw.githubusercontent.com/Biuni/PokemonGO-Pokedex/master/pokedex.json")
            .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    val myResponse = response.body!!.string()
                    val jsonObject = JSONObject(myResponse)
                    val jsonArray = jsonObject.getJSONArray("pokemon")
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        arr.add(jsonObject.getString("name"))
                        arr.add(jsonObject.getString("image"))
                    }
                }
            }
        }
        )
    }
}