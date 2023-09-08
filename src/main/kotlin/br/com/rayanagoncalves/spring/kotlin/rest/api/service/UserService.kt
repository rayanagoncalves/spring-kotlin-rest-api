package br.com.rayanagoncalves.spring.kotlin.rest.api.service


import br.com.rayanagoncalves.spring.kotlin.rest.api.model.User
import br.com.rayanagoncalves.spring.kotlin.rest.api.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val repository: UserRepository) {

    fun findById(id: Long): User {
        return repository.findById(id).get()
    }
}