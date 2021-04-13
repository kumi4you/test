package com.kumar.test.di

import com.kumar.test.data.rest.RestService
import org.koin.dsl.module
import retrofit2.Retrofit

val restServiceModule = module {
    single(createdAtStart = true) {
        get<Retrofit>().create(RestService::class.java)
    }
}
