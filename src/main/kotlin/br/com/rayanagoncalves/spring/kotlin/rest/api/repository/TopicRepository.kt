package br.com.rayanagoncalves.spring.kotlin.rest.api.repository

import br.com.rayanagoncalves.spring.kotlin.rest.api.dto.TopicByCategoryResponse
import br.com.rayanagoncalves.spring.kotlin.rest.api.model.Topic
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TopicRepository: JpaRepository<Topic, Long> {

    fun findByCourseName(courseName: String, pageable: Pageable): Page<Topic>

    @Query("SELECT new br.com.rayanagoncalves.spring.kotlin.rest.api.dto.TopicByCategoryResponse(course.category, count(t)) from Topic t join t.course course group by course.category")
    fun topicByCategoryReport(): List<TopicByCategoryResponse>

    @Query("SELECT t from Topic t where t.answers is empty")
    fun topicsNotAnsweredReport(): List<Topic>
}