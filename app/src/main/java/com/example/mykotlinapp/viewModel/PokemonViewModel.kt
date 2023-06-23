package com.example.mykotlinapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mykotlinapp.model.Pokemon
import com.example.mykotlinapp.network.PokemonAPIService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokemonViewModel() : ViewModel() {

    val pokemonLiveData: MutableLiveData<List<Pokemon>> = MutableLiveData()
    var apiService: PokemonAPIService? = null

    init {
        apiService = PokemonAPIService()
        getPokemons()
    }

    fun getPokemons() {
        viewModelScope.launch(Dispatchers.IO) {
            val poks = apiService?.getFifePoks()
            pokemonLiveData.postValue(poks)
        }
    }

    fun updatePokemons(){
        viewModelScope.launch(Dispatchers.IO) {
            val poks = apiService?.getAllPoks()
            pokemonLiveData.postValue(poks)
        }
    }

}