package br.com.rayanagoncalves.spring.kotlin.rest.api.service

import br.com.rayanagoncalves.spring.kotlin.rest.api.dto.NewTopicRequest
import br.com.rayanagoncalves.spring.kotlin.rest.api.dto.TopicResponse
import br.com.rayanagoncalves.spring.kotlin.rest.api.model.Topic
import org.springframework.stereotype.Service

@Service
class TopicService(
    private var topics: List<Topic> = ArrayList(),
    private val courseService: CourseService,
    private val userService: UserService
) {

    fun list(): List<TopicResponse> {
        return topics.stream().map { topic -> TopicResponse(
            id = topic.id,
            title = topic.title,
            message = topic.message,
            createdAt = topic.createdAt,
            status = topic.topicStatus
        ) }.toList()
    }

    fun findById(id: Long): TopicResponse {
        val topic = topics.stream().filter{ topic -> topic.id == id }
            .findFirst().get()

        return TopicResponse(
            id = topic.id,
            title = topic.title,
            message = topic.message,
            status = topic.topicStatus,
            createdAt = topic.createdAt
        )
    }

    fun register(dto: NewTopicRequest) {
        topics = topics.plus(Topic(
            id = topics.size.toLong() + 1,
            title = dto.title,
            message = dto.message,
            course = courseService.findById(dto.courseId),
            author = userService.findById(dto.authorId)
        ))
    }
}