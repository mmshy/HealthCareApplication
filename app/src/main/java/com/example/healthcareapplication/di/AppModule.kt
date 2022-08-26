package com.example.healthcareapplication.di


import android.app.Application
import android.content.Context
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.healthcareapplication.common.PreferenceManage
import com.example.healthcareapplication.data.dao.UserDAO
import com.example.healthcareapplication.domain.repository.UserRepository
import com.example.healthcareapplication.domain.repository.UserRepositoryImpl
import com.example.healthcareapplication.domain.service.StorageServiceImpl
import com.example.healthcareapplication.domain.usecase.goal.AddGoal
import com.example.healthcareapplication.domain.usecase.goal.GetGoals
import com.example.healthcareapplication.domain.usecase.goal.GoalUseCases
import com.example.healthcareapplication.domain.usecase.goal.UpdateGoal
import com.example.healthcareapplication.domain.usecase.meal.*
import com.example.healthcareapplication.domain.usecase.sleep.*
import com.example.healthcareapplication.domain.usecase.meal.AddMeal
import com.example.healthcareapplication.domain.usecase.meal.GetMeal
import com.example.healthcareapplication.domain.usecase.meal.GetMeals
import com.example.healthcareapplication.domain.usecase.meal.MealUseCases
import com.example.healthcareapplication.domain.usecase.sleep.*
import com.example.healthcareapplication.domain.usecase.user.Authenticate
import com.example.healthcareapplication.domain.usecase.user.CreateAccount
import com.example.healthcareapplication.domain.usecase.user.ForgotPassword
import com.example.healthcareapplication.domain.usecase.user.UserAccessUseCases
import com.example.healthcareapplication.domain.usecase.waterdrinking.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {




    @Provides
    @Singleton
    fun provideUserRepository(db: UserDAO): UserRepository {
        return UserRepositoryImpl(db)
    }

    @Provides
    @Singleton
    fun provideUserAccessUseCases(repository: UserRepositoryImpl): UserAccessUseCases {
        return UserAccessUseCases(
            authenticate = Authenticate(repository),
            createAccount = CreateAccount(repository),
            forgotPassword = ForgotPassword(repository)
        );
    }

    @Provides
    @Singleton
    fun provideSleepUseCases(repository: StorageServiceImpl): SleepUseCases {
        return SleepUseCases(
            getSleeps = GetSleeps(repository),
            getSleepDetails = GetSleepDetails(repository),
            getSleepById = GetSleepById(repository),
            addSleep = AddSleep(repository),
            addSleepDetail = AddSleepDetail(repository),
            updateSleep = UpdateSleep(repository),
            updateSleepDetail = UpdateSleepDetail(repository)
        )
    }

    @Provides
    @Singleton
    fun provideMealUseCases(repository: StorageServiceImpl): MealUseCases {
        return MealUseCases(
            getMeals = GetMeals(repository),
            addMeal = AddMeal(repository),
            getMeal = GetMeal(repository),
            addMealDetail = AddMealDetail(repository),
            getMealDetails = GetMealDetails(repository)
        )
    }

    @Provides
    @Singleton
    fun provideWaterDrinkingUseCases(repository: StorageServiceImpl): WaterDrinkingUseCases {
        return WaterDrinkingUseCases(
            getWaterDrinkingById = GetWaterDrinkingById(repository),
            addWaterDrinking = AddWaterDrinking(repository),
            updateWaterDrinking = UpdateWaterDrinking(repository),
            getWaterDrinkings = GetWaterDrinkings(repository),
            updateWaterDrinkingWithNewDetail = UpdateWaterDrinkingWithNewDetail(repository),

            addWaterDrinkingDetail = AddWaterDrinkingDetail(repository),
            getWaterDrinkingDetailById = GetWaterDrinkingDetailById(repository),
            getWaterDrinkingDetails = GetWaterDrinkingDetails(repository)


        )
    }

    @Provides
    @Singleton
    fun provideGoalUseCases(repository: StorageServiceImpl): GoalUseCases {
        return GoalUseCases(
            addGoal = AddGoal(repository),
            getGoals = GetGoals(repository),
            updateGoal = UpdateGoal(repository)
        )
    }
}