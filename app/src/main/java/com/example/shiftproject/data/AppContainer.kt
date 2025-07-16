package com.example.shiftproject.data

import android.content.Context
import com.example.shiftproject.domain.ShiftRepository
import com.example.shiftproject.data.local.ShiftDatabase
import com.example.shiftproject.data.repository.ShiftRepositoryImpl
import com.example.shiftproject.data.remote.UsersApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val shiftRepository: ShiftRepository
}

class AppDataContainer(private val context: Context) : AppContainer {

    private val baseUrl =
        "https://randomuser.me/"

    private val json: Json = Json {
        ignoreUnknownKeys = true
        isLenient = true
        coerceInputValues = true
        prettyPrint = false
    }

    override val shiftRepository: ShiftRepository by lazy {
        ShiftRepositoryImpl(ShiftDatabase.getDatabase(context).shiftDao(), retrofitService)
    }

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val retrofitService: UsersApiService by lazy {
        retrofit.create(UsersApiService::class.java)
    }
}
