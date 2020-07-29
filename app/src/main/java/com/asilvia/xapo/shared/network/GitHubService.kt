package com.asilvia.xapo.shared.network

import retrofit2.http.GET

interface GitHubService {
    @GET("/search/repositories?q=android%20language:java&sort=stars&order=desc&per_page=10")
    fun listRepos():
}