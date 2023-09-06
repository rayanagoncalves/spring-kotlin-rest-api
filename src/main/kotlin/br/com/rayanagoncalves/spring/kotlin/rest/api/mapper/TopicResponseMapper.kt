package br.com.rayanagoncalves.spring.kotlin.rest.api.mapper

import br.com.rayanagoncalves.spring.kotlin.rest.api.dto.TopicResponse
import br.com.rayanagoncalves.spring.kotlin.rest.api.model.Topic
import org.springframework.stereotype.Component

@Component
class TopicResponseMapper: Mapper<Topic, TopicResponse> {

    override fun map(topic: Topic): TopicResponse {
        return TopicResponse(
            id = topic.id,
            title = topic.title,
            message = topic.message,
            createdAt = topic.createdAt,
            status =  topic.topicStatus
        )
    }
}