package com.celfocus.data.api

import com.celfocus.model.User
import retrofit2.http.GET
import retrofit2.http.Query

interface UserAPIs {
    @GET("users")
    suspend fun users(@Query("page") page: Int = 2): Response<User>
}