package br.com.rayanagoncalves.spring.kotlin.rest.api.controller

import br.com.rayanagoncalves.spring.kotlin.rest.api.dto.NewTopicRequest
import br.com.rayanagoncalves.spring.kotlin.rest.api.dto.TopicResponse
import br.com.rayanagoncalves.spring.kotlin.rest.api.service.TopicService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/topics")
class TopicController(private val topicService: TopicService) {

    @GetMapping
    fun list(): List<TopicResponse> {
        return topicService.list()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): TopicResponse {
        return topicService.findTopicResponseById(id)
    }

    @PostMapping
    fun cadastrar(@RequestBody @Valid topic: NewTopicRequest) {
        topicService.register(topic)
    }

}