package com.example.shiftproject.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.shiftproject.ShiftApplication
import com.example.shiftproject.ui.screens.UsersViewModel

object AppViewModelProvider{
    val Factory = viewModelFactory {
        initializer {
            UsersViewModel(
                (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as ShiftApplication).container.shiftRepository
            )
        }
    }
}
