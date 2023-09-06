package br.com.rayanagoncalves.spring.kotlin.rest.api.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

data class UpdateAnswerRequest(
    @field:NotEmpty
    val message: String,
    @field:NotNull
    val authorId: Long
)
