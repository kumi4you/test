package com.kumar.test.domain.usecase

import com.kumar.test.data.model.UserResponse
import com.kumar.test.data.rest.RestService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import retrofit2.Response

class GetUsersUseCase(private val restService: RestService) :
    NoInputUseCase<Flow<List<UserResponse>>> {

    override fun execute(): Flow<List<UserResponse>> {
        return flow {
            val response = restService.listUsers()
            val list = emitProcessResponse(response)
            emit(list)
        }.map {
            return@map it
        }
    }

    private fun emitProcessResponse(response: Response<List<UserResponse>>): List<UserResponse> =
        when {
            response.isSuccessful -> {
                response.body() ?: getEmptyResponseList()
            }
            else -> {
                getEmptyResponseList()
            }
        }

    private fun getEmptyResponseList() = listOf<UserResponse>()

}