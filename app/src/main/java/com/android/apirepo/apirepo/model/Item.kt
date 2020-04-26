package com.android.apirepo.apirepo.model

import androidx.annotation.LayoutRes
import com.android.apirepo.R

sealed class DetailItem(@LayoutRes val viewType: Int) {
 data class Item(
  val name: String, val description: String, val owner: String,
  val ownerImage: String
 ) : DetailItem(R.layout.list_layout)
}