package br.com.rayanagoncalves.spring.kotlin.rest.api.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size

data class UpdateTopicRequest(
    @field:NotEmpty
    @Size(min = 5, max = 100)
    val title: String,
    @field:NotEmpty
    val message: String
)
