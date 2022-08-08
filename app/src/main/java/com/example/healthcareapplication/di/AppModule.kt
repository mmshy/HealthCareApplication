package com.example.healthcareapplication.di

import com.example.healthcareapplication.data.dao.SleepDAO
import com.example.healthcareapplication.data.dao.UserDAO
import com.example.healthcareapplication.domain.repository.SleepRepository
import com.example.healthcareapplication.domain.repository.SleepRepositoryImpl
import com.example.healthcareapplication.domain.repository.UserRepository
import com.example.healthcareapplication.domain.repository.UserRepositoryImpl
import com.example.healthcareapplication.domain.usecase.sleep.AddSleep
import com.example.healthcareapplication.domain.usecase.sleep.GetSleeps
import com.example.healthcareapplication.domain.usecase.sleep.SleepUseCases
import com.example.healthcareapplication.domain.usecase.user.Authenticate
import com.example.healthcareapplication.domain.usecase.user.CreateAccount
import com.example.healthcareapplication.domain.usecase.user.ForgotPassword
import com.example.healthcareapplication.domain.usecase.user.UserAccessUseCases
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
    fun provideSleepDAO(): SleepDAO {
        return SleepDAO()
    }

    @Provides
    @Singleton
    fun provideUserRepository(db: UserDAO): UserRepository {
        return UserRepositoryImpl(db)
    }

    @Provides
    @Singleton
    fun provideSleepRepository(db: SleepDAO): SleepRepository {
        return SleepRepositoryImpl(db)
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
    fun provideSleepUseCases(repository: SleepRepositoryImpl) : SleepUseCases {
        return SleepUseCases(
            getSleeps = GetSleeps(repository),
            addSleep = AddSleep(repository)
        )
    }
}