package br.com.rayanagoncalves.spring.kotlin.rest.api.dto

data class NewTopicRequest(
    val title: String,
    val message: String,
    val courseId: Long,
    val authorId: Long
)
