package com.tuoku.parliament.logic.services.api_services

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.tuoku.parliament.logic.models.LikesAPIResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val BASE_URL = "https://users.metropolia.fi/~tuomakuh/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface LikesAPIService {
    @GET("eduskunta")
    suspend fun getLikesById(@Query("id") id:String, @Query("action") a:String="get"):LikesAPIResponse

    @GET("eduskunta")
    suspend fun like(@Query("id") id:String, @Query("action") a:String="plus")

    @GET("eduskunta")
    suspend fun dislike(@Query("id") id:String, @Query("action") a:String="minus")
}

object LikesAPI {
    val retrofitService: LikesAPIService by lazy {
        retrofit.create(LikesAPIService::class.java)
    }
}
