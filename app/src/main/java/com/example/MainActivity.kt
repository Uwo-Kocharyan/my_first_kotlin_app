package com.example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mykotlinapp.adapter.PokemonAdapter
import com.example.mykotlinapp.databinding.ActivityMainBinding
import com.example.mykotlinapp.databinding.ItemPokemonBinding
import com.example.mykotlinapp.viewModel.PokemonViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var bindingActivity: ActivityMainBinding
    private lateinit var bindingItemPokemon: ItemPokemonBinding
    private var pokemonViewModel: PokemonViewModel? = null
    private val pokemonAdapter = PokemonAdapter(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pokemonViewModel = ViewModelProvider(this)[PokemonViewModel::class.java]
        bindingActivity = ActivityMainBinding.inflate(layoutInflater)
        bindingItemPokemon = ItemPokemonBinding.inflate(layoutInflater)
        setContentView(bindingActivity.root)
        bindingActivity.recyclerView.layoutManager = LinearLayoutManager(this)
        bindingActivity.recyclerView.adapter = pokemonAdapter


        pokemonViewModel?.pokemonLiveData?.observe(this){
            pokemonAdapter.array = it
            pokemonAdapter.notifyDataSetChanged()
        }
        bindingActivity.updateBtn.setOnClickListener {
                pokemonViewModel!!.updatePokemons()
                pokemonAdapter.notifyDataSetChanged()
        }
        bindingActivity.restartBtn.setOnClickListener {
            pokemonViewModel!!.getPokemons()
            pokemonAdapter.notifyDataSetChanged()
        }
        bindingItemPokemon.removeBtn.setOnClickListener {
            pokemonViewModel!!.removeFromList(pokemonAdapter.array.first())
        }

        }

    }
