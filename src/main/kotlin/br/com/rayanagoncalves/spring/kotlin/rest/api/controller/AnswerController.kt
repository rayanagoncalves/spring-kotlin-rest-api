package br.com.rayanagoncalves.spring.kotlin.rest.api.controller

import br.com.rayanagoncalves.spring.kotlin.rest.api.dto.AnswerResponse
import br.com.rayanagoncalves.spring.kotlin.rest.api.dto.NewAnswerRequest
import br.com.rayanagoncalves.spring.kotlin.rest.api.dto.UpdateAnswerRequest
import br.com.rayanagoncalves.spring.kotlin.rest.api.model.Answer
import br.com.rayanagoncalves.spring.kotlin.rest.api.service.AnswerService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/topics/{id}/answers")
class AnswerController(private val answerService: AnswerService) {

    @GetMapping
    fun list(@PathVariable id: Long): List<Answer> {
        return answerService.list(id)
    }

    @PostMapping
    fun register(@PathVariable id: Long, @RequestBody @Valid newAnswerRequest: NewAnswerRequest, uriBuilder: UriComponentsBuilder): ResponseEntity<AnswerResponse> {
        val answerResponse = answerService.register(id, newAnswerRequest)
        val uri = uriBuilder.path("/topics/$id/answers").build().toUri()

        return ResponseEntity.created(uri).body(answerResponse)
    }

    @PutMapping
    fun update(@PathVariable id: Long, @RequestBody @Valid updateAnswerRequest: UpdateAnswerRequest): ResponseEntity<AnswerResponse>{
        val answerResponse = answerService.update(id, updateAnswerRequest)

        return ResponseEntity.ok(answerResponse)
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) {
        answerService.delete(id)
    }
}