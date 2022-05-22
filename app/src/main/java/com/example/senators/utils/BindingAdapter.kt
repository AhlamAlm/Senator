package com.example.senators.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.senators.R
import com.example.senators.models.Senator
import com.example.senators.senatorslist.SenatorsListAdapter

@BindingAdapter("senatorsRv")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Senator>?) {
    val adapter = recyclerView.adapter as SenatorsListAdapter
    adapter.submitList(data)
}

@BindingAdapter("senatorAvatar")
fun fetchImage(view: ImageView, uri: String?) {
    uri?.let {

        Glide.with(view).load(uri.substringBefore('?'))
            .circleCrop()
            .placeholder(R.drawable.avatar)
            .error(R.drawable.avatar)
            .into(view)
    }
}
