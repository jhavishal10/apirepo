package com.android.apirepo.apirepo.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.apirepo.apirepo.data.Repository
import com.android.apirepo.apirepo.model.ApiRepoResponse
import com.android.apirepo.apirepo.model.DetailItem


class ViewModel : ViewModel() {


    val users = MutableLiveData<List<DetailItem.Item>>()
    val u = mutableListOf<DetailItem.Item>()


    init {
        Repository.getResponse(::onDataLoaded)
    }

    private fun onDataLoaded(data: ApiRepoResponse?) {
        if (data == null) return

        data.forEach() {
                u.add(
                    DetailItem.Item(
                        it.name ?: "",
                        it.description ?: "",
                        it.owner?.login ?: "",
                        it.owner?.avatarUrl ?: ""
                    )
                )
        }
        users.value = u
    }
}

