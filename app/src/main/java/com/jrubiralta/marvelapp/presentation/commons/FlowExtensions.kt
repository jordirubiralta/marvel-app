package com.jrubiralta.marvelapp.presentation.commons

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest

fun <T> AppCompatActivity.collectState(flow: Flow<T>, collect: suspend (T) -> Unit) {
    lifecycleScope.launchWhenStarted {
        flow.collectLatest(collect)
    }
}

fun <T> AppCompatActivity.collectEvent(flow: Flow<T>, collect: (T) -> Unit) {
    lifecycleScope.launchWhenStarted {
        flow.collect(collect)
    }
}

fun <T> Fragment.collectState(flow: Flow<T>, collect: suspend (T) -> Unit) {
    viewLifecycleOwner.lifecycleScope.launchWhenStarted {
        flow.collectLatest(collect)
    }
}

fun <T> Fragment.collectEvent(flow: Flow<T>, collect: (T) -> Unit) {
    viewLifecycleOwner.lifecycleScope.launchWhenStarted {
        flow.collect(collect)
    }
}
