package com.example.shiftproject.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.shiftproject.ui.AppViewModelProvider
import com.example.shiftproject.ui.ShiftUiState


@Composable
fun MainScreen(
    viewModel: UsersViewModel = viewModel(factory = AppViewModelProvider.Factory),
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier.fillMaxSize()
    ) {
        val shiftUiState by viewModel.uiState.collectAsState()

        when (shiftUiState) {
            is ShiftUiState.Loading -> {
                LoadingScreen(
                    modifier = modifier
                )
            }

            is ShiftUiState.Success -> {
                UsersScreen(
                    userList = (shiftUiState as ShiftUiState.Success).userList,
                    onUserCardClick = viewModel::selectUser,
                    onIconButtonClick = viewModel::getNewUsersList,
                    modifier = modifier,
                )
            }

            is ShiftUiState.SelectUser -> {
                UserCard(
                    user = (shiftUiState as ShiftUiState.SelectUser).user,
                    onIconButtonClick = viewModel::backToList,
                )
            }

            else -> {
                ErrorScreen(
                    retryAction = viewModel::getUsers,
                    modifier = modifier.fillMaxSize()
                )
            }
        }
    }

}
