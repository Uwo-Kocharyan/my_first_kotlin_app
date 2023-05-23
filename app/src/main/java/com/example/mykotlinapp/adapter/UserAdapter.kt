package com.example.mykotlinapp.adapter


import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.mykotlinapp.R
import com.example.mykotlinapp.databinding.ItemPokemonBinding
import com.example.mykotlinapp.model.Users


class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    var data: List<Users> = listOf()

    class UserViewHolder(val binding: ItemPokemonBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPokemonBinding.inflate(inflater, parent, false)
        return UserViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val pokemon = data[position]
        holder.binding.nameTextView.text = pokemon.name

        val backgroundColor: Int = if (position % 2 == 1) Color.BLUE else Color.YELLOW
        val textColor: Int = if (position % 2 == 1) Color.WHITE else Color.BLACK
        val avatar: Int = if (position % 2 == 1) R.drawable.avatar else R.drawable.avatar_male
        holder.binding.apply {
            nameTextView.apply {
                setBackgroundColor(backgroundColor)
                setTextColor(textColor)
            }
            iconView.setImageDrawable(
                ContextCompat.getDrawable(holder.binding.itemPokemon.context, avatar)
            )
            holder.itemView.setOnClickListener {
                if (position % 2 == 0)
                    Toast.makeText(
                        holder.binding.itemPokemon.context,
                        "Cell clicked odd numbered user",
                        Toast.LENGTH_SHORT
                    ).show()
                else Toast.makeText(
                    holder.binding.itemPokemon.context,
                    "Cell clicked even numbered user",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }


        //        if (position % 2 == 1) {
//            holder.binding.nameTextView.setBackgroundColor(
//                Color.parseColor(BLUE)
//            )
//            holder.binding.iconView.setImageDrawable(
//                ContextCompat.getDrawable( holder.binding.itemPokemon.context, R.drawable.avatar)
//            )
//            holder.binding.nameTextView.setTextColor(
//                ContextCompat.getColor(
//                    holder.binding.itemPokemon.context,
//                    R.color.white
//                )
//            )
//        } else {
//            holder.binding.iconView.setImageDrawable(
//                ContextCompat.getDrawable( holder.binding.itemPokemon.context, R.drawable.avatar_male)
//            )
//            holder.binding.nameTextView.setBackgroundColor(
//                        Color.parseColor(YELLOW)
//            )
//        }

    }
}