package com.asilvia.xapo.main.di


import com.asilvia.xapo.main.viewmodel.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

object MainModule {
    val module = module{
        viewModel { MainViewModel(get()) }}
    }

