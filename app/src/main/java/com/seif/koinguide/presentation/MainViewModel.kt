package com.seif.koinguide.presentation

import androidx.lifecycle.ViewModel
import com.seif.koinguide.domain.repository.MainRepository

class MainViewModel(
    private val repository: MainRepository
): ViewModel() {

    fun doNetworkCall() {
        println("Something")
    }
}