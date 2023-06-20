package com.example.mykotlinapp.adapter


import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mykotlinapp.R
import com.example.mykotlinapp.databinding.ItemPokemonBinding
import com.example.mykotlinapp.model.Pokemon

class PokemonAdapter(private  val context: Context) : RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {


    class PokemonViewHolder(val binding: ItemPokemonBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPokemonBinding.inflate(inflater, parent, false)
        return PokemonViewHolder(binding)
    }

    var array: List<Pokemon> = listOf()


    override fun getItemCount(): Int = array.size

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemons = array[position]
        holder.binding.nameTextView.text = pokemons.name
        Glide.with(context)
            .load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRbAFuTL-Ge7ResY7T_F-Acl6wlBIrqUB9DOg&usqp=CAU")
            .error(R.drawable.avatar)
            .placeholder(R.drawable.avatar_male)
            .into(holder.binding.iconView)


        val backgroundColor: Int = if (position % 2 == 1) Color.BLUE else Color.YELLOW
        val textColor: Int = if (position % 2 == 1) Color.WHITE else Color.BLACK
        //val avatar: Any? = if (position % 2 == 1) pokemons.image else pokemons.image
//        val avatar: Int = if (position % 2 == 1) R.drawable.avatar else R.drawable.avatar_male
        holder.binding.apply {
            nameTextView.apply {
                setBackgroundColor(backgroundColor)
                setTextColor(textColor)
            }
//            iconView.setImageDrawable(
//                ContextCompat.getDrawable(holder.binding.itemPokemon.context, avatar as Int)
//            )
            holder.itemView.setOnClickListener {
                Toast.makeText(
                    holder.binding.itemPokemon.context,
                    "Cell clicked ${position + 1} numbered user",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}