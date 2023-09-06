package br.com.rayanagoncalves.spring.kotlin.rest.api.service

import br.com.rayanagoncalves.spring.kotlin.rest.api.dto.NewTopicRequest
import br.com.rayanagoncalves.spring.kotlin.rest.api.dto.TopicResponse
import br.com.rayanagoncalves.spring.kotlin.rest.api.dto.UpdateTopicRequest
import br.com.rayanagoncalves.spring.kotlin.rest.api.mapper.TopicResponseMapper
import br.com.rayanagoncalves.spring.kotlin.rest.api.model.Topic
import org.springframework.stereotype.Service

@Service
class TopicService(
    private var topics: List<Topic> = ArrayList(),
    private val courseService: CourseService,
    private val userService: UserService,
    private val topicResponseMapper: TopicResponseMapper
) {

    fun list(): List<TopicResponse> {
        return topics.stream().map { topic -> topic.mapper() }.toList()
    }

    fun findTopicResponseById(id: Long): TopicResponse {
        val topic = topics.stream().filter{ topic -> topic.id == id }
            .findFirst().get()

        return topic.mapper()
    }

    fun findTopicById(id: Long): Topic {
        return topics.stream().filter{ topic -> topic.id == id }.findFirst().get()
    }

    fun register(dto: NewTopicRequest): TopicResponse {
        val topic = dto.mapper()
        topic.id = topics.size.toLong() + 1
        topics = topics.plus(topic)

        return topicResponseMapper.map(topic)
    }

    fun update(id: Long, updateTopicRequest: UpdateTopicRequest): TopicResponse {
        val topic = topics.stream().filter{ topic -> topic.id == id }.findFirst().get()
        val updatedTopic = Topic(
            id = id,
            title = updateTopicRequest.title,
            message = updateTopicRequest.message,
            author = topic.author,
            course = topic.course,
            answers = topic.answers,
            topicStatus = topic.topicStatus,
            createdAt = topic.createdAt
        )
        topics = topics.minus(topic).plus(updatedTopic)

        return topicResponseMapper.map(updatedTopic)
    }

    fun delete(id: Long) {
        val topic = topics.stream().filter{ topic -> topic.id == id}.findFirst().get()
        topics = topics.minus(topic)
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
