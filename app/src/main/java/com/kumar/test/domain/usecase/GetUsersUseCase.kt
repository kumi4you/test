package com.kumar.test.domain.usecase

import com.kumar.test.data.rest.RestService

class GetUsersUseCase(private val restService: RestService) {
    suspend fun repoGetUsers() = restService.listUsers()
}