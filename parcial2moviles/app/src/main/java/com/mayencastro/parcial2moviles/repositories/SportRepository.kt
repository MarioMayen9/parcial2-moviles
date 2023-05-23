package com.mayencastro.parcial2moviles.repositories

import com.mayencastro.parcial2moviles.data.model.Sport

class SportRepository (private val models: MutableList<Sport>) {
    fun getSports() = models
    fun addSports(model : Sport) = models.add(model)
    fun deleteSports(model: Sport) = models.remove(model)
}