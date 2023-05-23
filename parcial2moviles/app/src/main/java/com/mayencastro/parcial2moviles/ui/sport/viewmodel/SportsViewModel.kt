package com.mayencastro.parcial2moviles.ui.sport.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.mayencastro.parcial2moviles.SportApplication
import com.mayencastro.parcial2moviles.data.model.Sport
import com.mayencastro.parcial2moviles.repositories.SportRepository

class SportsViewModel (private val repository: SportRepository) : ViewModel() {

    var name = MutableLiveData("")
    var rules = MutableLiveData("")


    var status = MutableLiveData("")


    fun getModel() = repository.getSports()

    fun addModel(model: Sport) = repository.addSports(model)

    fun deleteModel (model: Sport) = repository.deleteSports(model)

    fun create(){
        if (!validateData()) {
            status.value = WRONG_INFORMATION
            return
        }

        val model = Sport(
            name.value!!,
            rules.value!!

        )
        addModel(model)
        clearData()

        status.value = M_CREATED
    }

    private fun validateData(): Boolean{
        when{
            name.value.isNullOrEmpty() -> return false
            rules.value.isNullOrEmpty() -> return false

        }
        return true
    }

    fun clearData() {
        name.value = ""
        rules.value=""

    }

    fun clearStatus() {
        status.value = INACTIVE
    }

    fun setSelectedModel(model:Sport){
        name.value= model.name
        rules.value = model.rules

    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as SportApplication
                SportsViewModel(app.modelRepository)
            }
        }
        const val M_CREATED = " created"
        const val WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = ""
    }



}