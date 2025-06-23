package com.example.myapplication.presentaition.viewmodels.userviewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.usecases.courseusecase.GetCoursesUseCase
import com.example.myapplication.domain.usecases.userusecase.CheckUserUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject



@HiltViewModel
class CheckUserViewModel @Inject constructor(
    private val checkUserUseCase: CheckUserUseCase
) : ViewModel() {
    fun checkUser(user: com.example.myapplication.domain.models.User) = viewModelScope.launch {
        checkUserUseCase(user = user)

    }
}