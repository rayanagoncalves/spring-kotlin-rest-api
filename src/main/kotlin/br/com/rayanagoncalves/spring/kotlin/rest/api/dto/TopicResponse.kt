package br.com.rayanagoncalves.spring.kotlin.rest.api.dto

import br.com.rayanagoncalves.spring.kotlin.rest.api.model.TopicStatus
import java.time.LocalDateTime

data class TopicResponse(
    val id: Long? = null,
    val title: String,
    val message: String,
    val status: TopicStatus,
    val createdAt: LocalDateTime
)
