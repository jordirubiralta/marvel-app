package com.jrubiralta.marvelapp.presentation.ui.marvellist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jrubiralta.marvelapp.databinding.ItemLoadingStateBinding
import com.jrubiralta.marvelapp.presentation.commons.visible

class MarvelLoadStateAdapter(
    private val retry: () -> Unit
) : LoadStateAdapter<MarvelLoadStateAdapter.MarvelLoadStateViewHolder>() {

    inner class MarvelLoadStateViewHolder(
        private val binding: ItemLoadingStateBinding,
        private val retry: () -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(loadState: LoadState) {
            if (loadState is LoadState.Error) {
                binding.textViewError.text = loadState.error.localizedMessage
            }

            binding.progressbar.isVisible = loadState is LoadState.Loading
            binding.buttonRetry.isVisible = loadState is LoadState.Error
            binding.textViewError.isVisible = loadState is LoadState.Error
            binding.buttonRetry.setOnClickListener {
                retry()
            }

            binding.progressbar.visible()
        }
    }

    override fun onBindViewHolder(holder: MarvelLoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ) = MarvelLoadStateViewHolder(
        ItemLoadingStateBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        retry
    )
}