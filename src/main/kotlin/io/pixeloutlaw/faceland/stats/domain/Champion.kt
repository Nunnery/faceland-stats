package io.pixeloutlaw.faceland.stats.domain

import org.springframework.data.annotation.Id

data class Champion(
        @Id val uuid: String,
        val unusedStatPoints: Int = 0,
        val highestReachedLevel: Int = 1,
        val bonusLevels: Int = 0,
        val skills: List<Skill> = listOf(),
        val stats: List<Stat> = listOf()
) {
    fun simpify(): SimplifiedChampion {
        return SimplifiedChampion(uuid, unusedStatPoints, highestReachedLevel, bonusLevels)
    }
}
