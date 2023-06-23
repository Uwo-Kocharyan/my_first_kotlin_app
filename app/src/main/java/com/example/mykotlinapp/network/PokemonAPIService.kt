package com.example.mykotlinapp.network


import com.example.mykotlinapp.model.Pokemon
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.json.JSONObject
import java.io.IOException


class PokemonAPIService {
    val client = OkHttpClient()

   suspend fun getFifePoks(): List<Pokemon> {
        var pokArray = ArrayList<Pokemon>()

        val request: Request = Request.Builder()
            .url("https://raw.githubusercontent.com/Biuni/PokemonGO-Pokedex/master/pokedex.json")
            .build()
       val response = client.newCall(request).execute()
       if (response.isSuccessful){
           val myResponse = response.body!!.string()
           val jsonObject = JSONObject(myResponse)
           val jsonArray = jsonObject.getJSONArray("pokemon")
           for (i in 0 until jsonArray.length() - 146 ) {
               val jsonObjects = jsonArray.getJSONObject(i)
               val name: String = jsonObjects.getString("name")
               val img: String = jsonObjects.getString("img")
               pokArray.add(Pokemon(name = name,img=img))
           }
       }
        return pokArray
    }

    fun getAllPoks(): List<Pokemon> {
        var pokArray = ArrayList<Pokemon>()

        val request: Request = Request.Builder()
            .url("https://raw.githubusercontent.com/Biuni/PokemonGO-Pokedex/master/pokedex.json")
            .build()
        val response = client.newCall(request).execute()
        if (response.isSuccessful){
            val myResponse = response.body!!.string()
            val jsonObject = JSONObject(myResponse)
            val jsonArray = jsonObject.getJSONArray("pokemon")
            for (i in 0 until jsonArray.length()) {
                val jsonObjects = jsonArray.getJSONObject(i)
                val name: String = jsonObjects.getString("name")
                val img: String = jsonObjects.getString("img")
                pokArray.add(Pokemon(name = name,img=img))
            }
        }
        return pokArray
    }
}