package br.com.rayanagoncalves.spring.kotlin.rest.api.model

import java.time.LocalDateTime

data class Topic(
    var id: Long? = null,
    val title: String,
    val message: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val course: Course,
    val author: User,
    val topicStatus: TopicStatus = TopicStatus.NOT_ANSWERED,
    val answers: List<Answer> = ArrayList()
)
