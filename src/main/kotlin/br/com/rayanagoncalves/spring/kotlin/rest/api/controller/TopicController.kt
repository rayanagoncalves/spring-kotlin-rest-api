package br.com.rayanagoncalves.spring.kotlin.rest.api.controller

import br.com.rayanagoncalves.spring.kotlin.rest.api.model.Course
import br.com.rayanagoncalves.spring.kotlin.rest.api.model.Topic
import br.com.rayanagoncalves.spring.kotlin.rest.api.model.User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/topics")
class TopicController {

    @GetMapping
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