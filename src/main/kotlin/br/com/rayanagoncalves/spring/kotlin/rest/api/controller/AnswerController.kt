package br.com.rayanagoncalves.spring.kotlin.rest.api.controller

import br.com.rayanagoncalves.spring.kotlin.rest.api.dto.NewAnswerRequest
import br.com.rayanagoncalves.spring.kotlin.rest.api.model.Answer
import br.com.rayanagoncalves.spring.kotlin.rest.api.service.AnswerService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/topics/{id}/answers")
class AnswerController(private val answerService: AnswerService) {

    @GetMapping
    fun list(@PathVariable id: Long): List<Answer> {
        return answerService.list(id)
    }

    @PostMapping
    fun register(@PathVariable id: Long, @RequestBody @Valid newAnswerRequest: NewAnswerRequest) {
        answerService.register(id, newAnswerRequest)
    }
}