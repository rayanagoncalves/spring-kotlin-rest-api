package br.com.rayanagoncalves.spring.kotlin.rest.api.service

import br.com.rayanagoncalves.spring.kotlin.rest.api.model.Course
import br.com.rayanagoncalves.spring.kotlin.rest.api.model.Topic
import br.com.rayanagoncalves.spring.kotlin.rest.api.model.User
import org.springframework.stereotype.Service
import java.util.*

@Service
class TopicService(private var topics: List<Topic>) {

    init {
        val topic = Topic(
            id = 1,
            title = "Dúvida Kotlin",
            message = "Variáveis no Kotlin",
            course = Course(
                id = 1,
                name = "Kotlin",
                category = "Programacao"
            ),
            author = User(
                id = 1,
                name = "Ana da Silva",
                email = "ana@email.com"
            )
        )

        val topic2 = Topic(
            id = 2,
            title = "Dúvida Kotlin 2",
            message = "Variáveis no Kotlin 2",
            course = Course(
                id = 1,
                name = "Kotlin",
                category = "Programacao"
            ),
            author = User(
                id = 1,
                name = "Ana da Silva",
                email = "ana@email.com"
            )
        )

        val topic3 = Topic(
            id = 3,
            title = "Dúvida Kotlin 3",
            message = "Variáveis no Kotlin 3",
            course = Course(
                id = 1,
                name = "Kotlin",
                category = "Programacao"
            ),
            author = User(
                id = 1,
                name = "Ana da Silva",
                email = "ana@email.com"
            )
        )

        topics = Arrays.asList(topic, topic2, topic3)
    }

    fun list(): List<Topic> {
        return this.topics
    }

    fun findById(id: Long): Topic {
        return this.topics.stream().filter{ topic -> topic.id == id }
            .findFirst().get()
    }
}