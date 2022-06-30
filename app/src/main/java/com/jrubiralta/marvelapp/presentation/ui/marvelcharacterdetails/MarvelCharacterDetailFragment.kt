package com.jrubiralta.marvelapp.presentation.ui.marvelcharacterdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.jrubiralta.marvelapp.R
import com.jrubiralta.marvelapp.databinding.FragmentCharacterDetailBinding
import com.jrubiralta.marvelapp.domain.model.CharacterModel
import com.jrubiralta.marvelapp.presentation.commons.collectState
import com.jrubiralta.marvelapp.presentation.commons.gone
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MarvelCharacterDetailFragment : Fragment() {

    private val viewModel by viewModels<MarvelCharacterDetailViewModel>()

    private lateinit var binding: FragmentCharacterDetailBinding

    private val args: MarvelCharacterDetailFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCharacterDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(args.characterModel.name ?: requireActivity().getString(R.string.detail_title))
        initObservers()
        args.characterModel.id?.let {
            viewModel.getCharacterDetails(it)
        }
    }

    private fun initObservers() {
        collectState(viewModel.state) { renderState(it) }
    }

    private fun renderState(state: MarvelCharacterDetailViewModel.CharacterDetailState) {
        renderLoading(state.isLoading)
        state.errorMessage?.let { e ->
            showErrorMessage(e)
        }
        state.characterDetails?.let {
            renderDetails(it)
        }
    }

    private fun renderDetails(model: CharacterModel) = with(binding) {
        model.name?.let {
            characterName.text = it
        } ?: characterName.gone()
        model.description?.let {
            characterDescription.text = it
        } ?: characterDescription.gone()
        model.image?.let {

            if (!it.path.isNullOrBlank() && it.isValidExtension()) {
                Glide
                    .with(requireContext())
                    .load("${it.path}.${it.extension}")
                    .centerCrop()
                    .placeholder(R.drawable.placeholder_image)
                    .into(binding.image)
            }
        } ?: binding.image.gone()
    }

    private fun renderLoading(isLoading: Boolean) {
        binding.progressBar.isVisible = isLoading
    }

    private fun initToolbar(toolbarTitle: String) {
        binding.centeredToolbar.apply {
            setNavigationIcon(R.drawable.back_arrow_white)
            setNavigationOnClickListener {
                findNavController().navigateUp()
            }
            title = toolbarTitle
        }
    }

    private fun showErrorMessage(error: String) {
        Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
    }

}