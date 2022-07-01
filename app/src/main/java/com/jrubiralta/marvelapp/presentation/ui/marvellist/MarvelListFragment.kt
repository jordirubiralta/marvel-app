package com.jrubiralta.marvelapp.presentation.ui.marvellist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.jrubiralta.marvelapp.R
import com.jrubiralta.marvelapp.databinding.FragmentMarvelListBinding
import com.jrubiralta.marvelapp.domain.model.CharacterModel
import com.jrubiralta.marvelapp.presentation.commons.collectAction
import com.jrubiralta.marvelapp.presentation.commons.collectEvent
import com.jrubiralta.marvelapp.presentation.commons.collectState
import com.jrubiralta.marvelapp.presentation.ui.marvellist.adapter.MarvelListAdapter
import com.jrubiralta.marvelapp.presentation.ui.marvellist.adapter.MarvelLoadStateAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MarvelListFragment : Fragment() {

    private val viewModel by viewModels<MarvelListViewModel>()

    private lateinit var binding: FragmentMarvelListBinding

    private lateinit var marvelListAdapter: MarvelListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMarvelListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(requireActivity().getString(R.string.list_title))
        setupRecyclerView()
        initObservers()
    }

    private fun initObservers() {
        collectState(viewModel.state) { renderState(it) }
        collectEvent(viewModel.event) { launchEvent(it) }
        collectAction(viewModel.characterList) { marvelListAdapter.submitData(it) }
    }

    private fun setupRecyclerView() = with(binding.rvMarvelList) {
        marvelListAdapter = MarvelListAdapter(::onItemClick)
        binding.rvMarvelList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = marvelListAdapter.withLoadStateHeaderAndFooter(
                header = MarvelLoadStateAdapter { marvelListAdapter.retry() },
                footer = MarvelLoadStateAdapter { marvelListAdapter.retry() }
            )
            setHasFixedSize(true)
        }
    }

    private fun renderState(state: MarvelListViewModel.MarvelListState) {
        state.errorMessage?.let { e ->
            showErrorMessage(e)
        }
    }

    private fun launchEvent(event: MarvelListViewModel.Event) {
        when (event) {
            is MarvelListViewModel.Event.ProceedToCharacterDetails -> {
                findNavController().navigate(
                    MarvelListFragmentDirections.actionGoToCharacterDetail(event.model)
                )
            }
        }
    }

    private fun onItemClick(model: CharacterModel) {
        viewModel.navigateToCharacterDetails(model)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                activity?.onBackPressed()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun initToolbar(toolbarTitle: String) {
        binding.centeredToolbar.title = toolbarTitle
    }

    private fun showErrorMessage(error: String) {
        Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
    }

}