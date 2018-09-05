package io.pixeloutlaw.faceland.stats.repositories

import io.pixeloutlaw.faceland.stats.domain.Champion
import org.springframework.data.repository.CrudRepository

interface ChampionRepository: CrudRepository<Champion, String>
