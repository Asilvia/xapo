package com.asilvia.xapo.shared.di

import com.asilvia.xapo.shared.network.RetrofitClient
import com.asilvia.xapo.shared.repository.GithubRepositories
import org.koin.dsl.module

object ApiModule {
    val retrofitModule =  module {
        single { RetrofitClient() }
    }
    val apiModule = module{
        single { GithubRepositories() }
    }
}