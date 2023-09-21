package br.com.rayanagoncalves.spring.kotlin.rest.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class SpringKotlinRestApiApplication

fun main(args: Array<String>) {
	runApplication<SpringKotlinRestApiApplication>(*args)
}
