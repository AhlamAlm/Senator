package com.example.senators.senatorslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.senators.R
import com.example.senators.databinding.ItemSenatorsBinding
import com.example.senators.models.Senator

class SenatorsListAdapter(private val clickListener: SenatorListener) :
    ListAdapter<Senator, SenatorsListAdapter.SenatorViewHolder>(SenatorDiffCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SenatorViewHolder {
        val mBinding: ItemSenatorsBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_senators,
            parent,
            false
        )
        return SenatorViewHolder(mBinding)
    }

    override fun onBindViewHolder(holder: SenatorViewHolder, position: Int) {
        val senator = getItem(position)

        holder.itemView.setOnClickListener {
            clickListener.onClick(senator)
        }

        holder.bind(senator)
    }

    class SenatorViewHolder(private var binding: ItemSenatorsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(senator: Senator) {
            binding.senator = senator
            binding.executePendingBindings()
        }
    }


    object SenatorDiffCallback : DiffUtil.ItemCallback<Senator>() {
        override fun areItemsTheSame(oldItem: Senator, newItem: Senator): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Senator, newItem: Senator): Boolean {
            return oldItem.id == newItem.id
        }
    }

    class SenatorListener(val clickListener: (senator: Senator) -> Unit) {
        fun onClick(senator: Senator) = clickListener(senator)
    }
}

