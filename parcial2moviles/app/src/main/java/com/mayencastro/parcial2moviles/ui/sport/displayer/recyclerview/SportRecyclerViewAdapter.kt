package com.mayencastro.parcial2moviles.ui.sport.displayer.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mayencastro.parcial2moviles.data.model.Sport
import com.mayencastro.parcial2moviles.databinding.SportItemBinding


class SportRecyclerViewAdapter (
    private val clickListener: (Sport) -> Unit,
    private val deleteListener: (Sport) -> Unit

    ) : RecyclerView.Adapter<SportRecyclerViewHolder>() {
    private val model = ArrayList<Sport>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportRecyclerViewHolder {
        val binding = SportItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SportRecyclerViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return model.size
    }

    override fun onBindViewHolder(holder: SportRecyclerViewHolder, position: Int) {
        val model = model[position]
        holder.bind(model,clickListener,deleteListener)



    }
    fun deleteModel(position: Int) {
        if (position < model.size) {
            val deletedModel = model.removeAt(position)
            notifyItemRemoved(position)
            deleteListener(deletedModel)
        }
    }

    fun setData(modelList: List<Sport>){
        model.clear()
        model.addAll(modelList)
    }

}