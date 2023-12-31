package br.com.rayanagoncalves.spring.kotlin.rest.api.controller

import br.com.rayanagoncalves.spring.kotlin.rest.api.dto.NewTopicRequest
import br.com.rayanagoncalves.spring.kotlin.rest.api.dto.TopicByCategoryResponse
import br.com.rayanagoncalves.spring.kotlin.rest.api.dto.TopicResponse
import br.com.rayanagoncalves.spring.kotlin.rest.api.dto.UpdateTopicRequest
import br.com.rayanagoncalves.spring.kotlin.rest.api.model.Topic
import br.com.rayanagoncalves.spring.kotlin.rest.api.service.TopicService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/topics")
class TopicController(private val topicService: TopicService) {

    @GetMapping
    @Cacheable("topics")
    fun list(
        @RequestParam(required = false) courseName: String?,
        @PageableDefault(size = 5, sort = ["createdAt"], direction = Sort.Direction.DESC ) pageable: Pageable): Page<TopicResponse> {
        return topicService.list(courseName, pageable)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): TopicResponse {
        return topicService.findTopicResponseById(id)
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = ["topics"], allEntries = true)
    fun register(
        @RequestBody @Valid topic: NewTopicRequest,
        uriBuilder: UriComponentsBuilder): ResponseEntity<TopicResponse> {
        val topicResponse = topicService.register(topic)
        val uri = uriBuilder.path("/topic/$topicResponse.id").build().toUri()

        return ResponseEntity.created(uri).body(topicResponse)
    }

    @PutMapping("/{id}")
    @Transactional
    @CacheEvict(value = ["topics"], allEntries = true)
    fun update(@PathVariable id: Long, @RequestBody @Valid topic: UpdateTopicRequest): ResponseEntity<TopicResponse> {
        val topicResponse = topicService.update(id, topic)

        return ResponseEntity.ok(topicResponse)
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @CacheEvict(value = ["topics"], allEntries = true)
    fun delete(@PathVariable id: Long) {
        topicService.delete(id)
    }

    @GetMapping("/topicByCategoryReport")
    fun topicByCategoryReport(): List<TopicByCategoryResponse> {
        return topicService.topicByCategoryReport()
    }

    @GetMapping("/topicsNotAnsweredReport")
    fun report(): List<Topic> {
        return topicService.topicsNotAnsweredReport()
    }
}