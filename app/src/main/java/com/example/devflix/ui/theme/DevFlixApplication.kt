package com.example.devflix.ui.theme

import MovieRepository
import MovieViewModel
import android.app.Application
import com.example.devflix.ui.theme.data.api.ApiService
import com.example.devflix.ui.theme.domain.usecase.GetMoviesUseCase
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

internal class DevFlixApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@DevFlixApplication)
            modules(appModule)
        }
    }

    private val appModule = module {
        single { ApiService.create() }
        single { MovieRepository(get()) }
        single { GetMoviesUseCase(get()) }
        viewModel { MovieViewModel(get()) }
    }
}