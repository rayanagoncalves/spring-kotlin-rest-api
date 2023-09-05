package br.com.rayanagoncalves.spring.kotlin.rest.api.mapper

interface Mapper<T, U> {

    fun map(t: T, u: U): U
}