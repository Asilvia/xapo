package com.asilvia.xapo.shared.repository

import com.asilvia.xapo.shared.network.RetrofitClient

class GithubRepositories {
    val retrofitClient = RetrofitClient.retrofit

    suspend fun getRepositories() = retrofitClient.listRepos()
}