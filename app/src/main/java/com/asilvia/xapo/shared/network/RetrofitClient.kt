package com.asilvia.xapo.shared.network

import com.asilvia.xapo.BuildConfig
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.MAINBASEURL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(GitHubService::class.java)
    }

    fun getRetrofitClient()  = retrofit
}