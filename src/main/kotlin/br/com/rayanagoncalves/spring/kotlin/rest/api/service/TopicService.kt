package br.com.rayanagoncalves.spring.kotlin.rest.api.service

import br.com.rayanagoncalves.spring.kotlin.rest.api.model.Course
import br.com.rayanagoncalves.spring.kotlin.rest.api.model.Topic
import br.com.rayanagoncalves.spring.kotlin.rest.api.model.User
import org.springframework.stereotype.Service
import java.util.*

@Service
class TopicService {

    fun listar(): List<Topic> {
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

        return Arrays.asList(topic, topic, topic)
    }
}