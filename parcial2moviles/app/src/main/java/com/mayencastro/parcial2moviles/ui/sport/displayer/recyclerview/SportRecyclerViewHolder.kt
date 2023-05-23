package com.mayencastro.parcial2moviles.ui.sport.displayer.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.mayencastro.parcial2moviles.data.model.Sport
import com.mayencastro.parcial2moviles.databinding.SportItemBinding

class SportRecyclerViewHolder (private val binding: SportItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(model: Sport, clickListener: (Sport) -> Unit, deleteListener: (Sport) -> Unit) {
        binding.titleTextView.text = model.name
        binding.descipcionId.text = model.rules


        binding.modelCard.setOnClickListener {
            clickListener(model)
        }
        binding.deleteButton.setOnClickListener {
            deleteListener(model)
        }
    }
}