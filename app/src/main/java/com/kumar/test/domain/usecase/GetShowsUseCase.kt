package com.kumar.test.domain.usecase

import com.kumar.test.data.model.ShowResponse
import com.kumar.test.data.rest.RestService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import retrofit2.Response

class GetShowsUseCase(private val restService: RestService) :
    UseCase<String, Flow<List<ShowResponse>>> {

    override fun execute(input: String): Flow<List<ShowResponse>> {
        return flow {
            val response = restService.listShows(input)
            val list = emitProcessResponse(response)
            emit(list)
        }.map {
            return@map it
        }
    }

    private fun emitProcessResponse(response: Response<List<ShowResponse>>) =
        if (response.isSuccessful) response.body()!! else getEmptyResponseList()

    private fun getEmptyResponseList() = listOf<ShowResponse>()
}