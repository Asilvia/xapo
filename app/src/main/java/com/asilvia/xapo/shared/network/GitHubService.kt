package com.asilvia.xapo.shared.network

import com.asilvia.xapo.shared.model.Repositories
import retrofit2.http.GET

interface GitHubService {
    @GET("/search/repositories?q=kotlin&sort=stars&order=desc&per_page=100")
    suspend fun listRepos(): Repositories
}