package com.example.healthcareapplication.di

import androidx.navigation.NavHostController
import com.example.healthcareapplication.data.dao.UserDAO
import com.example.healthcareapplication.domain.repository.UserRepository
import com.example.healthcareapplication.domain.repository.UserRepositoryImpl
import com.example.healthcareapplication.domain.usecase.*
import com.example.healthcareapplication.presentation.screen.AuthScreens
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
    fun provideUserAccessUseCases(repository: UserRepositoryImpl) : UserAccessUseCases{
        return UserAccessUseCases(
            authenticate = Authenticate(repository),
            createAccount = CreateAccount(repository),
            forgotPassword = ForgotPassword(repository)
        );
    }


}