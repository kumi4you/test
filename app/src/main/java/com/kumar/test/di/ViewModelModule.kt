package com.kumar.test.di

import com.kumar.test.presentation.viewmodel.ShowViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ShowViewModel(get(),get(),get(),get()) }
}