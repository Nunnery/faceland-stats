package io.pixeloutlaw.faceland.stats.services

import io.pixeloutlaw.faceland.stats.domain.Champion
import io.pixeloutlaw.faceland.stats.repositories.ChampionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class ChampionService @Autowired constructor(
        private val championRepository: ChampionRepository
) {

    fun createChampion(champion: Champion): Champion {
        return championRepository.save(champion)
    }

    fun getAllChampions(): MutableIterable<Champion> {
        return championRepository.findAll()
    }

    fun getChampionByUuid(uuid: String): Optional<Champion> {
        return championRepository.findById(uuid)
    }

    fun updateChampion(uuid: String, champion: Champion): Champion {
        val newChampion = Champion(
                uuid, champion.unusedStatPoints, champion.highestReachedLevel,
                champion.bonusLevels, champion.skills, champion.stats
        )
        return championRepository.save(newChampion)
    }

    fun deleteChampion(uuid: String) {
        championRepository.deleteById(uuid)
    }

}