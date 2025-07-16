package com.example.shiftproject.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shiftproject.domain.ShiftRepository
import com.example.shiftproject.data.local.UserEntity
import com.example.shiftproject.domain.User
import com.example.shiftproject.ui.ShiftUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class UsersViewModel(
    private val shiftRepository: ShiftRepository,
) : ViewModel() {
    private val _uiState: MutableStateFlow<ShiftUiState> = MutableStateFlow(ShiftUiState.Loading)
    val uiState: StateFlow<ShiftUiState> = _uiState.asStateFlow()

    init {
        getUsers()
    }

    fun backToList() {
        viewModelScope.launch {
            _uiState.value = ShiftUiState.Success(userList = users())
        }
    }

    fun getUsers() {
        viewModelScope.launch {
            _uiState.value = ShiftUiState.Loading
            _uiState.value = try {
                val users = users()
                if (users.isEmpty()) {
                    ShiftUiState.Success(userList = newUsers())
                } else {
                    ShiftUiState.Success(userList = users)
                }
            } catch (e: IOException) {
                ShiftUiState.Error
            } catch (e: HttpException) {
                ShiftUiState.Error
            }
        }
    }

    fun getNewUsersList() {
        viewModelScope.launch {
            _uiState.value = ShiftUiState.Loading
            _uiState.value = try {
                ShiftUiState.Success(userList = newUsers())
            } catch (e: IOException) {
                ShiftUiState.Error
            } catch (e: HttpException) {
                ShiftUiState.Error
            }
        }
    }

    fun selectUser(userName: String, userLastName: String) {
        viewModelScope.launch {
            _uiState.value = try {
                ShiftUiState.SelectUser(user = searchUser(userName, userLastName))
            } catch (e: IOException) {
                ShiftUiState.Error
            } catch (e: HttpException) {
                ShiftUiState.Error
            }
        }
    }

    private suspend fun users(): List<User> {
        return shiftRepository.getUserList()
    }

    private suspend fun newUsers(): List<User> {
        return shiftRepository.getNewUserList()
    }

    private suspend fun searchUser(userName: String, userLastName: String): User {
        return shiftRepository.searchUser(userName, userLastName)
    }
}
