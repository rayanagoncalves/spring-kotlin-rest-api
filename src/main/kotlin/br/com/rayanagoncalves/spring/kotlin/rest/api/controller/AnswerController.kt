package br.com.rayanagoncalves.spring.kotlin.rest.api.controller

import br.com.rayanagoncalves.spring.kotlin.rest.api.model.Answer
import br.com.rayanagoncalves.spring.kotlin.rest.api.service.AnswerService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topics/{id}/answers")
class AnswerController(private val answerService: AnswerService) {

    @GetMapping
    fun list(@PathVariable id: Long): List<Answer> {
        return answerService.list(id)
    }
}