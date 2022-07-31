package com.example.healthcareapplication.di

import com.example.healthcareapplication.data.dao.UserDAO
import com.example.healthcareapplication.domain.repository.UserRepository
import com.example.healthcareapplication.domain.repository.UserRepositoryImpl
import com.example.healthcareapplication.domain.usecase.CreateUser
import com.example.healthcareapplication.domain.usecase.GetUser
import com.example.healthcareapplication.domain.usecase.UserAcessUseCases
import com.example.healthcareapplication.domain.usecase.UpdateUser
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideUserDAO(): UserDAO {
        return UserDAO()
    }

    @Provides
    @Singleton
    fun provideUserRepository(db: UserDAO): UserRepository {
        return UserRepositoryImpl(db)
    }

    @Provides
    @Singleton
    fun provideRegisterUseCase(repository: UserRepository) : UserAcessUseCases{
        return UserAcessUseCases(
            createUser = CreateUser(repository),
            getUser = GetUser(repository),
            updateUser = UpdateUser(repository)
        );
    }


}