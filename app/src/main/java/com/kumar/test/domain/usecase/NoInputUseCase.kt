package com.kumar.test.domain.usecase

interface NoInputUseCase<out O> {
    fun execute(): O
}