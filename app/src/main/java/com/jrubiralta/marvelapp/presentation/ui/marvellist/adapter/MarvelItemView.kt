package com.jrubiralta.marvelapp.presentation.ui.marvellist.adapter

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.jrubiralta.marvelapp.databinding.MarvelItemViewBinding
import com.jrubiralta.marvelapp.domain.model.CharacterModel

class MarvelItemView  @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val binding: MarvelItemViewBinding =
        MarvelItemViewBinding.inflate(
            LayoutInflater.from(context),
            this,
            true
        )

    init {
        layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }

    fun bind(
        model: CharacterModel,
        onClick: (CharacterModel) -> Unit
    ) {
        binding.characterTitle.text = model.name
        binding.rootCard.setOnClickListener { onClick.invoke(model) }
    }
}