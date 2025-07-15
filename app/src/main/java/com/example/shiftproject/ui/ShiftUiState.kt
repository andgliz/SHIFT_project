package com.example.shiftproject.ui

import com.example.shiftproject.data.model.User

sealed interface ShiftUiState {
    data class Success(val userList: List<User> = listOf()) : ShiftUiState
    data class SelectUser(val user: User = User()) : ShiftUiState
    object Error : ShiftUiState
    object Loading : ShiftUiState
}