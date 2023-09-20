package br.com.rayanagoncalves.spring.kotlin.rest.api.repository

import br.com.rayanagoncalves.spring.kotlin.rest.api.model.Topic
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface TopicRepository: JpaRepository<Topic, Long> {

    fun findByCourseName(courseName: String, pageable: Pageable): Page<Topic>
}