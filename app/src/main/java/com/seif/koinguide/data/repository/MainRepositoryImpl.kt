package com.seif.koinguide.data.repository

import com.seif.koinguide.data.remote.api.MyApi
import com.seif.koinguide.domain.repository.MainRepository

class MainRepositoryImpl(
    private val api: MyApi
): MainRepository {

    override fun doNetworkCall() {
        api.callApi()
    }
}