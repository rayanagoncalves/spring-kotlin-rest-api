package br.com.rayanagoncalves.spring.kotlin.rest.api.service

import br.com.rayanagoncalves.spring.kotlin.rest.api.dto.NewTopicRequest
import br.com.rayanagoncalves.spring.kotlin.rest.api.dto.TopicByCategoryResponse
import br.com.rayanagoncalves.spring.kotlin.rest.api.dto.TopicResponse
import br.com.rayanagoncalves.spring.kotlin.rest.api.dto.UpdateTopicRequest
import br.com.rayanagoncalves.spring.kotlin.rest.api.exception.NotFoundException
import br.com.rayanagoncalves.spring.kotlin.rest.api.mapper.TopicResponseMapper
import br.com.rayanagoncalves.spring.kotlin.rest.api.model.Topic
import br.com.rayanagoncalves.spring.kotlin.rest.api.repository.TopicRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class TopicService(
    private val repository: TopicRepository,
    private val courseService: CourseService,
    private val userService: UserService,
    private val topicResponseMapper: TopicResponseMapper,
    private val notFoundMessage: String = "Tópico não encontrado."
) {

    fun list(courseName: String?, pageable: Pageable): Page<TopicResponse> {
        val topics = if (courseName == null) {
            repository.findAll(pageable)
        } else
            repository.findByCourseName(courseName, pageable)
        return topics.map { topic ->
            topic.mapper()
        }
    }

    fun findTopicById(id: Long): Topic {
        return repository.findById(id).orElseThrow { NotFoundException(notFoundMessage) }
    }

    fun findTopicResponseById(id: Long): TopicResponse {
        val topic = findTopicById(id)

        return topic.mapper()
    }

    fun register(dto: NewTopicRequest): TopicResponse {
        val topic = dto.mapper()
        repository.save(topic)

        return topicResponseMapper.map(topic)
    }

    fun update(id: Long, updateTopicRequest: UpdateTopicRequest): TopicResponse {
        val topic = findTopicById(id)
        topic.title = updateTopicRequest.title
        topic.message = updateTopicRequest.message

        return topicResponseMapper.map(topic)
    }

    fun delete(id: Long) {
        repository.deleteById(id)
    }

    fun NewTopicRequest.mapper(): Topic {
        return Topic(
            title = this.title,
            message = this.message,
            course = courseService.findById(this.courseId),
            author = userService.findById(this.authorId)
        )
    }

    fun Topic.mapper(): TopicResponse {
        return TopicResponse(
            id = this.id,
            title = this.title,
            message = this.message,
            status = this.topicStatus,
            createdAt = this.createdAt
        )
    }

    fun report(): List<TopicByCategoryResponse> {
        return repository.report()
    }
}
