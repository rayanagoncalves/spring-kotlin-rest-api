package br.com.rayanagoncalves.spring.kotlin.rest.api.service

import br.com.rayanagoncalves.spring.kotlin.rest.api.dto.NewTopicDto
import br.com.rayanagoncalves.spring.kotlin.rest.api.model.Topic
import org.springframework.stereotype.Service

@Service
class TopicService(
    private var topics: List<Topic> = ArrayList(),
    private val courseService: CourseService,
    private val userService: UserService
) {

    fun list(): List<Topic> {
        return this.topics
    }

    fun findById(id: Long): Topic {
        return this.topics.stream().filter{ topic -> topic.id == id }
            .findFirst().get()
    }

    fun register(dto: NewTopicDto) {
        topics = topics.plus(Topic(
            id = topics.size.toLong() + 1,
            title = dto.title,
            message = dto.message,
            course = courseService.findById(dto.courseId),
            author = userService.findById(dto.authorId)
        ))
    }
}