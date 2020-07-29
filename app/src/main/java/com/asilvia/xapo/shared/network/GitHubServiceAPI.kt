package com.asilvia.xapo.shared.network

import com.asilvia.xapo.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class GitHubServiceAPI {

    fun getGitHubService() : GitHubService {

        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.MAINBASEURL)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()

        return retrofit.create(GitHubService::class.java)
    }
}