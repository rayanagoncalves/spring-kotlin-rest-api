package br.com.rayanagoncalves.spring.kotlin.rest.api.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size


data class NewTopicRequest(
    @field:NotEmpty(message = "Título não pode ser em branco")
    @field:Size(min = 5, max = 100, message = "Título deve ter entre 5 e 100 caracteres")
    val title: String,
    @field:NotEmpty(message = "Mensagem não pode ser em branco")
    val message: String,
    @field:NotNull val courseId: Long,
    @field:NotNull val authorId: Long
)
