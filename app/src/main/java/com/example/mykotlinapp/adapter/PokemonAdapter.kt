package com.example.mykotlinapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mykotlinapp.R
import com.example.mykotlinapp.databinding.ItemPokemonBinding
import com.example.mykotlinapp.model.Pokemon

class PokemonAdapter : RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    var data: List<Pokemon> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    class PokemonViewHolder(val binding: ItemPokemonBinding) : RecyclerView.ViewHolder(binding.root)


    override  fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemPokemonBinding.inflate(inflater, parent, false)

            return PokemonViewHolder(binding)
        }

    override    fun getItemCount(): Int = data.size // Количество элементов в списке данных


    override   fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
            val pokemon = data[position] // Получение человека из списка данных по позиции
            val context = holder.itemView.context

//            with(holder.binding) {
//                val color = if (pokemon.isLiked) R.color.red else R.color.grey // Цвет "сердца", если пользователь был лайкнут
//
//                nameTextView.text = person.name // Отрисовка имени пользователя
//                companyTextView.text = person.companyName // Отрисовка компании пользователя
//                likedImageView.setColorFilter( // Отрисовка цвета "сердца"
//                    ContextCompat.getColor(context, color),
//                    android.graphics.PorterDuff.Mode.SRC_IN
//                )
//                Glide.with(context).load(person.photo).circleCrop() // Отрисовка фотографии пользователя с помощью библиотеки Glide
//                    .error(R.drawable.ic_person)
//                    .placeholder(R.drawable.ic_person).into(imageView)
        }

    }

