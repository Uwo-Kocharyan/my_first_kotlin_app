package com.example.mvvm_api_request.view

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.model.User
import com.example.mvvm_api_request.model.PokemonMVVM
import com.example.mykotlinapp.R
import com.example.mykotlinapp.databinding.ItemPokemonBinding

class PokemonMVVM_adapter: RecyclerView.Adapter<PokemonMVVM_adapter.PokemonMVVMHolder>() {
    var pokemonMVVMs:List<PokemonMVVM> = listOf()

    class PokemonMVVMHolder(val binding: ItemPokemonBinding) : RecyclerView.ViewHolder(binding.root)


    override fun getItemCount()= pokemonMVVMs.size

    fun refreshPoks(poks: List<PokemonMVVM>) {
        this.pokemonMVVMs = poks
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonMVVMHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPokemonBinding.inflate(inflater, parent, false)
        return PokemonMVVMHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonMVVMHolder, position: Int) {
        val user = pokemonMVVMs[position]
        holder.binding.nameTextView.text = user.name
        holder.binding.iconView.setImageURI( user.img as Uri)
//        val avatar: Uri = if (position % 2 == 1)  else R.drawable.avatar_male
//        holder.binding.apply {
//            iconView.setImageDrawable(
//                ContextCompat.getDrawable(holder.binding.itemPokemon.context, avatar)
//            )
//        }
    }




}