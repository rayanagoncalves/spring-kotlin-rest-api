package br.com.rayanagoncalves.spring.kotlin.rest.api.service

import br.com.rayanagoncalves.spring.kotlin.rest.api.model.Course
import org.springframework.stereotype.Service
import java.util.*

@Service
class CourseService(var courses: List<Course> = ArrayList()) {

    init {
        val course = Course(
            id = 1,
            name = "Kotlin",
            category = "Programação"
        )

        courses = Arrays.asList(course)
    }

    fun findById(id: Long): Course {
        return courses.stream().filter{ course -> course.id == id }.findFirst().get()
    }

}