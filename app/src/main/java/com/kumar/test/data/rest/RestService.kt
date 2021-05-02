package com.kumar.test.data.rest

import com.kumar.test.data.model.ShowResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RestService {

    @GET("search/shows")
    suspend fun listShows(
        @Query("q") query: String
    ): Response<List<ShowResponse>>
}