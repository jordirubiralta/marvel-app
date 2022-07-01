package com.jrubiralta.marvelapp.presentation.ui.marvellist.adapter

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.jrubiralta.marvelapp.domain.model.CharacterModel
import com.jrubiralta.marvelapp.presentation.commons.ViewWrapper

class MarvelListAdapter(
    private val onCharacterClicked: (CharacterModel) -> Unit
) : PagingDataAdapter<CharacterModel, ViewWrapper<MarvelItemView>>(Callback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewWrapper<MarvelItemView> {
        return ViewWrapper(MarvelItemView(parent.context))
    }

    override fun onBindViewHolder(holder: ViewWrapper<MarvelItemView>, position: Int) {
        getItem(position)?.let {
            holder.view.bind(it, onCharacterClicked::invoke)
        }
    }

    class Callback : DiffUtil.ItemCallback<CharacterModel>() {
        override fun areItemsTheSame(oldItem: CharacterModel, newItem: CharacterModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: CharacterModel, newItem: CharacterModel): Boolean {
            return oldItem.id == newItem.id
        }
    }

}
