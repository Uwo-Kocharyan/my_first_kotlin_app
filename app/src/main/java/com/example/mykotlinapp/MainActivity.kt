package com.example.mykotlinapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mykotlinapp.adapter.PokemonAdapter
import com.example.mykotlinapp.databinding.ActivityMainBinding
import com.example.mykotlinapp.model.Pokemon


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: PokemonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = PokemonAdapter().apply {
            data = listOf(
                Pokemon("name1"),
                Pokemon("name2"),
                Pokemon("name3"),
                Pokemon("name4"),
                Pokemon("name5"),
            )
            notifyDataSetChanged()
        }
        binding.recyclerView.adapter = adapter
    }
}