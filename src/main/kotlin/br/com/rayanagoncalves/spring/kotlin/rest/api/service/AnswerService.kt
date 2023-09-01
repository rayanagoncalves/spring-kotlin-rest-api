package br.com.rayanagoncalves.spring.kotlin.rest.api.service

import br.com.rayanagoncalves.spring.kotlin.rest.api.model.Answer
import br.com.rayanagoncalves.spring.kotlin.rest.api.model.Course
import br.com.rayanagoncalves.spring.kotlin.rest.api.model.Topic
import br.com.rayanagoncalves.spring.kotlin.rest.api.model.User
import org.springframework.stereotype.Service
import java.util.*

@Service
class AnswerService(private var answers: List<Answer>) {

    init {
        val author = User(
            id = 1,
            name = "Ana da Silva",
            email = "ana@email.com"
        )

        val topic = Topic(
            id = 1,
            title = "Dúvida Kotlin",
            message = "Variáveis no Kotlin",
            course = Course(
                id = 1,
                name = "Kotlin",
                category = "Programacao"
            ),
            author = author
        )

        val answer = Answer(
            id = 1,
            message = "pergunta respondida",
            author = author,
            topic = topic,
            solution = true
        )

        val answer2 = Answer(
            id = 2,
            message = "pergunta respondida 2",
            author = author,
            topic = topic,
            solution = true
        )

        val answer3 = Answer(
            id = 3,
            message = "pergunta respondida 3",
            author = author,
            topic = topic,
            solution = true
        )

        this.answers = Arrays.asList(answer, answer2, answer3)
    }

    fun list(id: Long): List<Answer> {
        return answers.stream()
            .filter{answer -> answer.topic.id == id}
            .toList()
    }
}