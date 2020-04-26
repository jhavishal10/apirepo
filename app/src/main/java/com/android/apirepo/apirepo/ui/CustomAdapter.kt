package com.android.apirepo.apirepo.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.apirepo.R
import com.android.apirepo.apirepo.model.DetailItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_layout.view.*

class CustomAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val list = mutableListOf<DetailItem.Item>()

    fun addUsers(list: List<DetailItem.Item>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_layout, parent, false)
        return IpoCompanyBusinessViewHolder(view)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        return (holder as IpoCompanyBusinessViewHolder).bind(list[position] as DetailItem.Item)
    }

    inner class IpoCompanyBusinessViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: DetailItem.Item) {
            with(itemView) {
                stockName.text = item.name
                stockCategory.text = item.description
                stockPrice.text = item.owner
                Picasso.get().load(item.ownerImage).into(avatar)
            }
        }
    }

}