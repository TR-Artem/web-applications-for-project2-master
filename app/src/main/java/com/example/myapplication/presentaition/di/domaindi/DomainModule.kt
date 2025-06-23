package com.example.myapplication.presentaition.di.domaindi

import com.example.myapplication.domain.repositories.authenticationrepository.IInterUserAccountRepository
import com.example.myapplication.domain.repositories.courserepository.IAddCourseRepository
import com.example.myapplication.domain.repositories.courserepository.IGetCourseRepository
import com.example.myapplication.domain.repositories.studentrepository.IAddStudentRepository
import com.example.myapplication.domain.repositories.studentrepository.IGetStudentsRepository
import com.example.myapplication.domain.repositories.teacherrepository.IAddTeacherRepository
import com.example.myapplication.domain.repositories.teacherrepository.IGetTeachersRepository
import com.example.myapplication.domain.repositories.userrepository.IAddUserRepository
import com.example.myapplication.domain.repositories.userrepository.ICheckUserRepository
import com.example.myapplication.domain.repositories.userrepository.IGetLastUserRepository
import com.example.myapplication.domain.repositories.userrepository.IGetUsersRepository
import com.example.myapplication.domain.usecases.authenticationusecase.InterUserAccountUseCase
import com.example.myapplication.domain.usecases.courseusecase.AddCourseUseCase
import com.example.myapplication.domain.usecases.courseusecase.GetCoursesUseCase
import com.example.myapplication.domain.usecases.studentusecase.AddStudentUseCase
import com.example.myapplication.domain.usecases.studentusecase.GetStudentsUseCase
import com.example.myapplication.domain.usecases.teacherusecase.AddTeacherUseCase
import com.example.myapplication.domain.usecases.teacherusecase.GetTeachersUseCase
import com.example.myapplication.domain.usecases.userusecase.AddUserUseCase
import com.example.myapplication.domain.usecases.userusecase.CheckUserUseCase
import com.example.myapplication.domain.usecases.userusecase.GetUserUseCase
import com.example.myapplication.domain.usecases.userusecase.GetUsersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun provideAddUserUseCase(repository: IAddUserRepository): AddUserUseCase {
        return AddUserUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetUsersUseCase(repository: IGetUsersRepository): GetUsersUseCase {
        return GetUsersUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetUserUseCase(repository: IGetLastUserRepository): GetUserUseCase {
        return GetUserUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideCheckUserUseCase(repository: ICheckUserRepository): CheckUserUseCase {
        return CheckUserUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideInterUserAccountUseCase(repository: IInterUserAccountRepository): InterUserAccountUseCase {
        return InterUserAccountUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetTeachersUseCase(repository: IGetTeachersRepository): GetTeachersUseCase {
        return GetTeachersUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideAddTeacherUseCase(repository: IAddTeacherRepository): AddTeacherUseCase {
        return AddTeacherUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetStudentsUseCase(repository: IGetStudentsRepository): GetStudentsUseCase {
        return GetStudentsUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideAddStudentUseCase(repository: IAddStudentRepository): AddStudentUseCase {
        return AddStudentUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetCoursesUseCase(repository: IGetCourseRepository): GetCoursesUseCase {
        return GetCoursesUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideAddCourseUseCase(repository: IAddCourseRepository): AddCourseUseCase {
        return AddCourseUseCase(repository)
    }
}