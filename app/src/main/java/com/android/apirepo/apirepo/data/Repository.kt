package com.android.apirepo.apirepo.data

import android.util.Log
import com.android.apirepo.apirepo.model.ApiRepoResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Repository {
    fun getResponse(getData: (data: ApiRepoResponse?) -> Unit) {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val apiService = retrofit.create(ApiService::class.java)

        val call = apiService.getApiRepoList()
        call.enqueue(object : Callback<ApiRepoResponse> {
            override fun onFailure(call: Call<ApiRepoResponse>, t: Throwable) {
                Log.d("failure", "**failed** ")
            }

            override fun onResponse(
                call: Call<ApiRepoResponse>,
                response: Response<ApiRepoResponse>
            ) {
                Log.d("response", "${response.body()}")
                getData(response.body())
            }

        })
    }

}
