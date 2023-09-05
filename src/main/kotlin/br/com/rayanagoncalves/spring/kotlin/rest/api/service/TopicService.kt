package br.com.rayanagoncalves.spring.kotlin.rest.api.service

import br.com.rayanagoncalves.spring.kotlin.rest.api.model.Topic
import org.springframework.stereotype.Service

@Service
class TopicService(private var topics: List<Topic> = ArrayList()) {

    fun list(): List<Topic> {
        return this.topics
    }

    fun findById(id: Long): Topic {
        return this.topics.stream().filter{ topic -> topic.id == id }
            .findFirst().get()
    }

    fun cadastrar(topic: Topic) {
        this.topics.plus(topic)
    }
}