package com.kumar.test.data.rest

import com.kumar.test.data.model.UserResponse
import retrofit2.http.GET

interface RestService {

    @GET("users")
    suspend fun listUsers(): List<UserResponse>
}