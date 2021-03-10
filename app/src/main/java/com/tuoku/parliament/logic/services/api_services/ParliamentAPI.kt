package com.tuoku.parliament.logic.services.api_services

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.tuoku.parliament.logic.models.ParliamentMember
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


private const val BASE_URL = " https://avoindata.eduskunta.fi/"
//val cacheSize = (5 * 1024 * 1024).toLong()
//val mCache = Cache(MainActivity.getCon().cacheDir, cacheSize)

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
/*
val okHttpClient = OkHttpClient.Builder()
    .cache(mCache)
    .addInterceptor { chain ->
        var request = chain.request()
        request = if (hasNetwork(MainActivity.getCon())!!)
            request.newBuilder().header("Cache-Control", "public, max-age=" + 5).build()
        else
            request.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7).build()
        chain.proceed(request)
    }
    .build()
*/
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    // .client(okHttpClient)
    .build()

interface ParliamentAPIService {
    @GET("api/v1/seating/")
    suspend fun getEverybody():List<ParliamentMember>
}

object ParliamentAPI {
    val retrofitService: ParliamentAPIService by lazy {
        retrofit.create(ParliamentAPIService::class.java)
    }
}


