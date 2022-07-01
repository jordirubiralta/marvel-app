package com.jrubiralta.marvelapp.presentation.ui.marvelcharacterdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.material.MaterialTheme
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.jrubiralta.marvelapp.databinding.FragmentCharacterDetailBinding
import com.jrubiralta.marvelapp.domain.model.CharacterModel
import com.jrubiralta.marvelapp.presentation.commons.collectState
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
        initObservers()
        viewModel.getCharacterDetails(args.id)
    }

    private fun initObservers() {
        collectState(viewModel.state) { renderState(it) }
    }

    private fun renderState(state: MarvelCharacterDetailViewModel.CharacterDetailState) {
        state.errorMessage?.let { e ->
            showErrorMessage(e)
        }
        renderDetails(state.characterDetails, state.isLoading)
    }

    private fun renderDetails(model: CharacterModel?, isLoading: Boolean) = with(binding) {
        composeView.setContent {
            // You're in Compose world!
            MaterialTheme {
                MarvelCharacterDetails(model, isLoading, ::onBackClicked)
            }
        }
    }

    private fun showErrorMessage(error: String) {
        Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
    }

    private fun onBackClicked() {
        findNavController().navigateUp()
    }


}