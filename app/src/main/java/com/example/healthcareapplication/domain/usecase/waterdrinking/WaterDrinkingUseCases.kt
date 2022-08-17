package com.example.healthcareapplication.domain.usecase.waterdrinking

data class WaterDrinkingUseCases(
    val addWaterDrinking: AddWaterDrinking,
    val getWaterDrinkingById: GetWaterDrinkingById,
    val updateWaterDrinking: UpdateWaterDrinking,
    val getWaterDrinkings: GetWaterDrinkings,

    val addWaterDrinkingDetail: AddWaterDrinkingDetail,
    val getWaterDrinkingDetails: GetWaterDrinkingDetails,
    val getWaterDrinkingDetailById: GetWaterDrinkingDetailById
)
