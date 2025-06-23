package com.example.myapplication.presentaition.di.appdi

import com.example.myapplication.CharacterViewModel
import com.example.myapplication.presentaition.viewmodels.userviewmodel.CheckUserViewModel
import com.example.myapplication.presentaition.viewmodels.courseviewmodel.AddCourseViewModel
import com.example.myapplication.presentaition.viewmodels.courseviewmodel.GetCourseViewModel
import com.example.myapplication.presentaition.viewmodels.userviewmodel.AddUserViewModel
import com.example.myapplication.presentaition.viewmodels.userviewmodel.GetUserViewModel
import com.example.myapplication.presentaition.viewmodels.userviewmodel.UserViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import com.example.myapplication.domain.usecases.courseusecase.AddCourseUseCase
import com.example.myapplication.domain.usecases.courseusecase.GetCoursesUseCase
import com.example.myapplication.domain.usecases.userusecase.AddUserUseCase
import com.example.myapplication.domain.usecases.userusecase.CheckUserUseCase
import com.example.myapplication.domain.usecases.userusecase.GetUserUseCase
import com.example.myapplication.domain.usecases.userusecase.GetUsersUseCase


@Module
@InstallIn(ViewModelComponent::class)
object AppModule {

    @Provides
    @ViewModelScoped
    fun provideAddUserViewModel(addUserUseCase: AddUserUseCase): AddUserViewModel {
        return AddUserViewModel(addUserUseCase)
    }

    @Provides
    @ViewModelScoped
    fun provideUserViewModel(getUsersUseCase: GetUsersUseCase): UserViewModel {
        return UserViewModel(getUsersUseCase)
    }

    @Provides
    @ViewModelScoped
    fun provideGetUserViewModel(getUserUseCase: GetUserUseCase): GetUserViewModel {
        return GetUserViewModel(getUserUseCase)
    }

    @Provides
    @ViewModelScoped
    fun provideAddCourseViewModel(addCourseUseCase: AddCourseUseCase): AddCourseViewModel {
        return AddCourseViewModel(addCourseUseCase)
    }

    @Provides
    @ViewModelScoped
    fun provideGetCourseViewModel(getCoursesUseCase: GetCoursesUseCase): GetCourseViewModel {
        return GetCourseViewModel(getCoursesUseCase)
    }

    @Provides
    @ViewModelScoped
    fun provideCheckUserViewModel(checkUserUseCase: CheckUserUseCase): CheckUserViewModel {
        return CheckUserViewModel(checkUserUseCase)
    }

    @Provides
    @ViewModelScoped
    fun provideCharacterViewModel(): CharacterViewModel {
        return CharacterViewModel()
    }
}