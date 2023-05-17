package com.example.mykotlinapp.recycleView

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mykotlinapp.R

class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
    val textView: TextView = itemView.findViewById(R.id.pokemons_fields)
}