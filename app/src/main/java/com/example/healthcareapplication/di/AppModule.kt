package com.example.healthcareapplication.di

import com.example.healthcareapplication.data.dao.UserDAO
import com.example.healthcareapplication.domain.repository.UserRepository
import com.example.healthcareapplication.domain.repository.UserRepositoryImpl
import com.example.healthcareapplication.domain.service.StorageService
import com.example.healthcareapplication.domain.service.StorageServiceImpl
import com.example.healthcareapplication.domain.usecase.sleep.*
import com.example.healthcareapplication.domain.usecase.user.Authenticate
import com.example.healthcareapplication.domain.usecase.user.CreateAccount
import com.example.healthcareapplication.domain.usecase.user.ForgotPassword
import com.example.healthcareapplication.domain.usecase.user.UserAccessUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
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
    fun provideUserAccessUseCases(repository: UserRepositoryImpl) : UserAccessUseCases {
        return UserAccessUseCases(
            authenticate = Authenticate(repository),
            createAccount = CreateAccount(repository),
            forgotPassword = ForgotPassword(repository)
        );
    }

    @Provides
    @Singleton
    fun provideSleepUseCases(repository: StorageServiceImpl) : SleepUseCases {
        return SleepUseCases(
            getSleeps = GetSleeps(repository),
            getSleepDetails = GetSleepDetails(repository),
            getSleepById = GetSleepById(repository),
            addSleep = AddSleep(repository),
            addSleepDetail = AddSleepDetail(repository),
            updateSleep = UpdateSleep(repository)
        )
    }
}