package com.mayencastro.parcial2moviles

import android.app.Application
import com.mayencastro.parcial2moviles.data.model
import com.mayencastro.parcial2moviles.repositories.SportRepository

class SportApplication: Application() {
    val modelRepository: SportRepository by lazy{
        SportRepository(model)
    }
}