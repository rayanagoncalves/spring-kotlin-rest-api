package br.com.rayanagoncalves.spring.kotlin.rest.api.repository

import br.com.rayanagoncalves.spring.kotlin.rest.api.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {

    fun findByEmail(username: String?): User?
}