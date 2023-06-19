package com.example.mvvm_api_request.model

import android.util.Log
import com.example.mykotlinapp.model.Pokemon
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.json.JSONObject
import java.io.IOException

object PokemonMVVM_data {
  var pokApi:  PokemonAPIServiceMVVM? =PokemonAPIServiceMVVM()
    fun getName() {
        listOf(
            pokApi?.pokArray
        )
    }
//        PokemonMVVM().name = PokemonAPIServiceMVVM().pokArray

//    fun getImg() = listOf(
//        PokemonMVVM().img
//    )
}


class PokemonAPIServiceMVVM {
    val client = OkHttpClient()
    var pokArray = ArrayList<PokemonMVVM>()
    fun requestPokApi(
        onResponse: (List<PokemonMVVM>) -> Unit
    ): List<PokemonMVVM> {
        val request: Request = Request.Builder()
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
//                    val jsonArrayImg = jsonObject.getJSONArray("img")

                    for (i in 0 until jsonArray.length()) {
                        val jsonObjects = jsonArray.getJSONObject(i)
                        val name: String = jsonObjects.get("name") as String
                        pokArray.add(PokemonMVVM(name = name))
                    }
                    onResponse(pokArray)
                }
            }
        }
        )
        return pokArray
    }
}
