package br.com.rayanagoncalves.spring.kotlin.rest.api.service


import br.com.rayanagoncalves.spring.kotlin.rest.api.model.User
import br.com.rayanagoncalves.spring.kotlin.rest.api.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserService(private val repository: UserRepository): UserDetailsService {

    fun findById(id: Long): User {
        return repository.findById(id).get()
    }

    override fun loadUserByUsername(username: String?): UserDetails {
        val user = repository.findByEmail(username) ?: throw RuntimeException()
        return UserDetail(user)
    }
}