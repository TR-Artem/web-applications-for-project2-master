package com.example.myapplication.presentaition.viewmodels.userviewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.usecases.userusecase.AddUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddUserViewModel @Inject constructor(
    private val addUserUseCase: AddUserUseCase
) : ViewModel() {
    fun addUser(user: com.example.myapplication.domain.models.User) = viewModelScope.launch {
        addUserUseCase(user = user)
    }
}