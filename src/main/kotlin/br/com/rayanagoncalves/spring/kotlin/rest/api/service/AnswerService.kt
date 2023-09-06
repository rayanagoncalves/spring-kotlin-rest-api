package br.com.rayanagoncalves.spring.kotlin.rest.api.service

import br.com.rayanagoncalves.spring.kotlin.rest.api.dto.AnswerResponse
import br.com.rayanagoncalves.spring.kotlin.rest.api.dto.NewAnswerRequest
import br.com.rayanagoncalves.spring.kotlin.rest.api.dto.UpdateAnswerRequest
import br.com.rayanagoncalves.spring.kotlin.rest.api.mapper.AnswerResponseMapper
import br.com.rayanagoncalves.spring.kotlin.rest.api.model.Answer
import org.springframework.stereotype.Service

@Service
class AnswerService(
    private var answers: List<Answer> = ArrayList(),
    private val userService: UserService,
    private val topicService: TopicService,
    private val answerResponseMapper: AnswerResponseMapper) {

    fun list(id: Long): List<Answer> {
        return answers.stream()
            .filter{answer -> answer.topic.id == id}
            .toList()
    }

    fun register(id: Long, newAnswerRequest: NewAnswerRequest): AnswerResponse {
        val answer = Answer(
            id = answers.size.toLong() + 1,
            message = newAnswerRequest.message,
            author =  userService.findById(newAnswerRequest.authorId),
            topic = topicService.findTopicById(id),
            solution = false
        )

        answers = answers.plus(answer)

        return answerResponseMapper.map(answer)
    }

    fun update(id: Long, updateAnswerRequest: UpdateAnswerRequest): AnswerResponse {
        val answer = answers.stream().filter{answer -> answer.id == id}.findFirst().get()
        val updatedAnswer = Answer(
            id = id,
            message = updateAnswerRequest.message,
            createdAt =  answer.createdAt,
            author = userService.findById(updateAnswerRequest.authorId),
            topic = answer.topic,
            solution = answer.solution
        )

        return answerResponseMapper.map(updatedAnswer)
    }

    fun delete(id: Long) {
        val answer = answers.stream().filter{answer -> answer.id == id}.findFirst().get()
        answers = answers.minus(answer)
    }
}