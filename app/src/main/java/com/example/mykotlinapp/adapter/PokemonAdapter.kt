package com.example.mykotlinapp.adapter


import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.mykotlinapp.R
import com.example.mykotlinapp.constant.BLUE
import com.example.mykotlinapp.constant.YELLOW


import com.example.mykotlinapp.databinding.ItemPokemonBinding
import com.example.mykotlinapp.model.Pokemon


class PokemonAdapter : RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    var data: List<Pokemon> = listOf()

    class PokemonViewHolder(val binding: ItemPokemonBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPokemonBinding.inflate(inflater, parent, false)
        return PokemonViewHolder(binding)
    }



    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon = data[position]
        holder.binding.nameTextView.text = pokemon.name


        if (position % 2 == 1) {
            holder.binding.nameTextView.setBackgroundColor(
                Color.parseColor(BLUE)
            )
            holder.binding.iconView.setImageDrawable(
                ContextCompat.getDrawable( holder.binding.itemPokemon.context, R.drawable.avatar)
            )
            holder.binding.nameTextView.setTextColor(
                ContextCompat.getColor(
                    holder.binding.itemPokemon.context,
                    R.color.white
                )
            )
        }else{
            holder.binding.iconView.setImageDrawable(
                ContextCompat.getDrawable( holder.binding.itemPokemon.context, R.drawable.avatar_male)
            )
            holder.binding.nameTextView.setBackgroundColor(
                        Color.parseColor(YELLOW)
            )
        }


    }
}