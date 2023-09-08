package br.com.rayanagoncalves.spring.kotlin.rest.api.service

import br.com.rayanagoncalves.spring.kotlin.rest.api.model.Course
import br.com.rayanagoncalves.spring.kotlin.rest.api.repository.CourseRepository
import org.springframework.stereotype.Service

@Service
class CourseService(private val repository: CourseRepository) {

    fun findById(id: Long): Course {
        return repository.findById(id).get()
    }

}