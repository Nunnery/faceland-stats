package io.pixeloutlaw.faceland.stats.domain

data class SimplifiedChampion(
        val uuid: String,
        val unusedStatPoints: Int = 0,
        val highestReachedLevel: Int = 1,
        val bonusLevels: Int = 0
)