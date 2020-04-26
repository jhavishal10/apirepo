package com.android.apirepo.apirepo.data

import com.android.apirepo.apirepo.model.ApiRepoResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

@JvmSuppressWildcards
interface ApiService {

    @GET("repositories?since=5")
    fun getApiRepoList(): Call<ApiRepoResponse>
}