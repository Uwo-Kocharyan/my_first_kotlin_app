package com.example.mvvm_api_request.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm.model.User
import com.example.mvvm.model.UserData
import com.example.mvvm_api_request.model.PokemonAPIServiceMVVM
import com.example.mvvm_api_request.model.PokemonMVVM
import com.example.mvvm_api_request.model.PokemonMVVM_data

class PokemonMVVM_View_Model: ViewModel() {
     val pokemon_mvvm_List: MutableLiveData<List<PokemonMVVM>> = MutableLiveData(listOf())

    init {
        pokemon_mvvm_List.apply {
            PokemonMVVM_data.getName()
            println("fun get name in init bock")
        }

    //        {
//            PokemonMVVM().name
//        }
    }

//    fun updateListPokemons() {
//     pokemon_mvvm_List.apply {
//         PokemonMVVM_data.getName()
//     }
//    }
}