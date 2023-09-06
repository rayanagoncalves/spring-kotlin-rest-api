package br.com.rayanagoncalves.spring.kotlin.rest.api.mapper

import br.com.rayanagoncalves.spring.kotlin.rest.api.dto.AnswerResponse
import br.com.rayanagoncalves.spring.kotlin.rest.api.model.Answer

class AnswerResponseMapper: Mapper<Answer, AnswerResponse> {

    override fun map(answer: Answer): AnswerResponse {
        return AnswerResponse(
            id = answer.id,
            message = answer.message,
            createdAt = answer.createdAt,
            author = answer.author,
            topic = answer.topic,
            solution = answer.solution
        )
    }
}