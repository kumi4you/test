package com.kumar.test.di

import com.kumar.test.domain.usecase.GetUsersUseCase
import org.koin.dsl.module


val restRepositoryModule = module {
    single { GetUsersUseCase(get()) }
}