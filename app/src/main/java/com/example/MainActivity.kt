package com.example

import android.os.Bundle
import android.view.View.OnLongClickListener
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mykotlinapp.adapter.PokemonAdapter
import com.example.mykotlinapp.databinding.ActivityMainBinding
import com.example.mykotlinapp.viewModel.PokemonViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var pokemonViewModel: PokemonViewModel? = null
    private val pokemonAdapter = PokemonAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pokemonViewModel = ViewModelProvider(this)[PokemonViewModel::class.java]
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = pokemonAdapter

        pokemonViewModel?.pokemonLiveData?.observe(this){
            pokemonAdapter.array = it
            pokemonAdapter.notifyDataSetChanged()
        }

        binding.updateBtn.setOnClickListener {
                pokemonViewModel!!.updatePokemons()
                pokemonAdapter.notifyDataSetChanged()
        }
        binding.restartBtn.setOnClickListener {
            pokemonViewModel!!.getPokemons()
            pokemonAdapter.notifyDataSetChanged()
        }

    }
}