package br.com.rayanagoncalves.spring.kotlin.rest.api.repository

import br.com.rayanagoncalves.spring.kotlin.rest.api.model.Course
import org.springframework.data.jpa.repository.JpaRepository

interface CourseRepository: JpaRepository<Course, Long>{
}