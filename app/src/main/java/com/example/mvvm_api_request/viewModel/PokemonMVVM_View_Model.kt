package com.example.mvvm_api_request.viewModel

import androidx.lifecycle.MutableLiveData
import com.example.mvvm.model.UserData
import com.example.mvvm_api_request.model.PokemonMVVM
import com.example.mvvm_api_request.model.PokemonMVVM_data

class PokemonMVVM_View_Model {
    public val pokemon_mvvm_List: MutableLiveData<List<PokemonMVVM>> = MutableLiveData(listOf())

    init {
        pokemon_mvvm_List.value = PokemonMVVM_data.getName()
    }

    fun updateListPokemons() {
        pokemon_mvvm_List.value = PokemonMVVM_data.getImg() as List<PokemonMVVM>
    }
}