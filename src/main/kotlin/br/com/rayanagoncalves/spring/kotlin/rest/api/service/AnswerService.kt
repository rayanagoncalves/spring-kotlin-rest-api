package br.com.rayanagoncalves.spring.kotlin.rest.api.service

import br.com.rayanagoncalves.spring.kotlin.rest.api.dto.NewAnswerRequest
import br.com.rayanagoncalves.spring.kotlin.rest.api.model.Answer
import org.springframework.stereotype.Service

@Service
class AnswerService(
    private var answers: List<Answer> = ArrayList(),
    private val userService: UserService,
    private val topicService: TopicService) {

    fun list(id: Long): List<Answer> {
        return answers.stream()
            .filter{answer -> answer.topic.id == id}
            .toList()
    }

    fun register(id: Long, newAnswerRequest: NewAnswerRequest) {
        val answer = Answer(
            id = answers.size.toLong() + 1,
            message = newAnswerRequest.message,
            author =  userService.findById(newAnswerRequest.authorId),
            topic = topicService.findTopicById(id),
            solution = false
        )

        answers = answers.plus(answer)
    }
}