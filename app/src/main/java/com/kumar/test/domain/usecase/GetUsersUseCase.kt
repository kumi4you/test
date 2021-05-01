package com.kumar.test.domain.usecase

import com.kumar.test.data.model.UserResponse
import com.kumar.test.data.rest.RestService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import okhttp3.ResponseBody
import retrofit2.Response

class GetUsersUseCase(private val restService: RestService) :
    NoInputUseCase<Flow<ResponseBody>> {

    override fun execute(): Flow<ResponseBody> {
        return flow {
            val response = restService.listShows("girls")
            val list = emitProcessResponse(response)
            emit(list)
        }.map {
            return@map it
        }
    }

    private fun emitProcessResponse(response: Response<ResponseBody>): ResponseBody =
        if (response.isSuccessful) response.body()!! else response.errorBody()!!

    private fun getEmptyResponseList () = listOf<UserResponse>()

}