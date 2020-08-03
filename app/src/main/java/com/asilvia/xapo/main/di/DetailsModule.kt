package com.asilvia.xapo.main.di


import com.asilvia.xapo.main.viewmodel.DetailsViewModel
import com.asilvia.xapo.main.viewmodel.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

object DetailsModule {
    val module = module{
        viewModel { DetailsViewModel() }}
    }

