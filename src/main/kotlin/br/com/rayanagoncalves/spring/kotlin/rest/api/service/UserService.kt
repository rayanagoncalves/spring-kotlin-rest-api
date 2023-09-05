package br.com.rayanagoncalves.spring.kotlin.rest.api.service


import br.com.rayanagoncalves.spring.kotlin.rest.api.model.User
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(var users: List<User> = ArrayList()) {

    init {
        val user = User(
            id = 1,
            name = "Maria",
            email = "maria@email.com"
        )

        users = Arrays.asList(user)
    }

    fun findById(id: Long): User {
        return users.stream().filter{ user -> user.id == id }.findFirst().get()
    }

}