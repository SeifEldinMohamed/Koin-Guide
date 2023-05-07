package com.seif.koinguide.data.remote.api

import retrofit2.http.GET

interface MyApi {

    @GET("my/endpoint")
    fun callApi()
}