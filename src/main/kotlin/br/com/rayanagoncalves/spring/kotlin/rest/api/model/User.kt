package br.com.rayanagoncalves.spring.kotlin.rest.api.model

data class User(
    val id: Long? = null,
    val name: String,
    val email: String
)
