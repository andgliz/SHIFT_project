package com.example.shiftproject.data

import com.example.shiftproject.data.model.Results
import retrofit2.http.GET
import retrofit2.http.Query

interface UsersApiService {
    @GET("api/")
    suspend fun getUsers(@Query("results") count: Int): Results
}