package io.pixeloutlaw.faceland.stats.controllers

import io.pixeloutlaw.faceland.stats.domain.Champion
import io.pixeloutlaw.faceland.stats.exceptions.ChampionNotFoundException
import io.pixeloutlaw.faceland.stats.models.ChampionResponse
import io.pixeloutlaw.faceland.stats.models.ChampionsResponse
import io.pixeloutlaw.faceland.stats.services.ChampionService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/champions")
class ChampionController @Autowired constructor(private val championService: ChampionService) {

    private val logger = LoggerFactory.getLogger(ChampionController::class.java)

    @PostMapping
    fun createChampion(@RequestBody champion: Champion): ChampionResponse {
        logger.debug("Creating champion: {}", champion)
        return ChampionResponse(championService.createChampion(champion))
    }

    @GetMapping
    fun getAllChampions(): ChampionsResponse {
        logger.debug("Attempting to get all champions with reduced information")
        return ChampionsResponse(championService.getAllChampions().map { champion -> champion.simpify() })
    }

    @GetMapping("/{uuid}")
    fun getChampionByUuid(@PathVariable("uuid") uuid: String): Champion? {
        logger.debug("Attempting to get champion by UUID: {}", uuid)
        val championOptional = championService.getChampionByUuid(uuid)
        if (!championOptional.isPresent) {
            throw ChampionNotFoundException("Champion not found for UUID: $uuid")
        }
        return championOptional.get()
    }

    @PutMapping("/{uuid}")
    fun updateChampion(@PathVariable("uuid") uuid: String, @RequestBody champion: Champion): ChampionResponse {
        logger.debug("Attempting to update champion by UUID: {} {}", uuid, champion)
        return ChampionResponse(championService.updateChampion(uuid, champion))
    }

    @DeleteMapping("/{uuid}")
    fun deleteChampion(@PathVariable("uuid") uuid: String): ResponseEntity<Unit> {
        logger.debug("Attempting to delete champion by UUID: {}", uuid)
        championService.deleteChampion(uuid)
        return ResponseEntity.ok().build()
    }

}