package com.example.mykotlinapp

import android.app.Application
import com.example.mykotlinapp.network.PokemonAPIService

class App : Application() {
    val pokemonService = PokemonAPIService()
}