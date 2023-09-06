package br.com.rayanagoncalves.spring.kotlin.rest.api.mapper

interface Mapper<U, T> {

    fun map(u: U): T
}