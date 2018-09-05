package io.pixeloutlaw.faceland.stats.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND, reason = "Champion Not Found")
class ChampionNotFoundException(message: String?) : Exception(message)
