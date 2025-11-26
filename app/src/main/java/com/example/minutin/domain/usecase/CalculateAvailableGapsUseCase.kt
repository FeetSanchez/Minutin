package com.example.minutin.domain.usecase

import javax.inject.Inject

class CalculateAvailableGapsUseCase @Inject constructor() {
    suspend operator fun invoke(busySchedule: String): List<String> {
        if (busySchedule.isBlank()) return listOf("09:00-10:00", "12:00-13:00")
        return listOf("GAP 1 placeholder", "GAP 2 placeholder")
    }
}

