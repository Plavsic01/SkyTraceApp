package com.plavsic.skytrace.features.schedule.dto

import com.plavsic.skytrace.features.futureFlight.dto.AirlineDTO

data class AirlineDetailsDTO(
    val airline: AirlineDTO,
    val name:String
)
