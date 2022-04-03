package com.example.foodrecipeapp.di

import com.example.foodrecipeapp.data.remote.TastyApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import okhttp3.MediaType
import android.util.Log



@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
/*
    val client = OkHttpClient().Buil


        .Builder()
        .readTimeout(15, TimeUnit.SECONDS)
        .connectTimeout(15, TimeUnit.SECONDS)
        .build()

    val request = Request.Builder()
        .url("https://tasty.p.rapidapi.com/recipes/list?from=0&size=20&tags=under_30_minutes")
        .get()
        .addHeader("X-RapidAPI-Host", "tasty.p.rapidapi.com")
        .addHeader("X-RapidAPI-Key", "361ccf6fb8mshe8ae5c0ca993eb7p13dda7jsnd576d4fe4f03")
        .build()

    val response = client.newCall(request).execute() */

    @Provides
    @Singleton
    fun getHttpClient(): OkHttpClient {

        return OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()
    }

    @OptIn(ExperimentalSerializationApi::class)
    @Provides
    @Singleton
    fun getRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val json = Json {
            encodeDefaults = true
            isLenient = true
            prettyPrint = true
            explicitNulls = false
            ignoreUnknownKeys = true
        }
        val responseContent:String = "application/json".toMediaType
        return Retrofit.Builder()
            .baseUrl("https://tasty.p.rapidapi.com/")
            .client(okHttpClient)
            .addConverterFactory()
            .build()
    }

    @Provides
    @Singleton
    fun  getFlickrApi(retrofit: Retrofit): TastyApi {
        return  retrofit.create(TastyApi::class.java)
    }


}