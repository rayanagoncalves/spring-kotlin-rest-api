package br.com.rayanagoncalves.spring.kotlin.rest.api.service

import br.com.rayanagoncalves.spring.kotlin.rest.api.dto.NewTopicRequest
import br.com.rayanagoncalves.spring.kotlin.rest.api.dto.TopicResponse
import br.com.rayanagoncalves.spring.kotlin.rest.api.model.Topic
import org.springframework.stereotype.Service

@Service
class TopicService(
    private var topics: List<Topic> = ArrayList(),
    private val courseService: CourseService,
    private val userService: UserService,
) {

    fun list(): List<TopicResponse> {
        return topics.stream().map { topic -> topic.mapper() }.toList()
    }

    fun findById(id: Long): TopicResponse {
        val topic = topics.stream().filter{ topic -> topic.id == id }
            .findFirst().get()

        return topic.mapper()
    }

    fun register(dto: NewTopicRequest) {
        val topic = dto.mapper()
        topic.id = topics.size.toLong() + 1
        topics = topics.plus(topic)
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
}
