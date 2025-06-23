package com.example.myapplication.presentaition.viewmodels.courseviewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.models.Course
import com.example.myapplication.domain.models.User
import com.example.myapplication.domain.usecases.courseusecase.AddCourseUseCase
import kotlinx.coroutines.launch
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class AddCourseViewModel @Inject constructor(
    private val addCourseUseCase: AddCourseUseCase
) : ViewModel() {
    fun addCourse(course: com.example.myapplication.domain.models.Course) = viewModelScope.launch {
        addCourseUseCase(course = course)

    }
}