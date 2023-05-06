package com.seif.koinguide.di

import com.seif.koinguide.data.remote.api.MyApi
import com.seif.koinguide.data.repository.MainRepositoryImpl
import com.seif.koinguide.domain.repository.MainRepository
import com.seif.koinguide.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val appModule = module {
    single { // singleton
        Retrofit.Builder()
            .baseUrl("https://google.com")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(MyApi::class.java)
    }
    single<MainRepository> {
        MainRepositoryImpl(get())
    }
    /*
    factory<MainRepository> { // will create instance of this repository every time it requested
        MainRepositoryImpl(get())
    }
     */
    viewModel {
        MainViewModel(get())
    }
}