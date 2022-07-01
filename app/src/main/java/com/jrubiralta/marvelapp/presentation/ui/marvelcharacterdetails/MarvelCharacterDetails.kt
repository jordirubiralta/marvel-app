package com.jrubiralta.marvelapp.presentation.ui.marvelcharacterdetails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.jrubiralta.marvelapp.R
import com.jrubiralta.marvelapp.domain.model.CharacterModel
import com.jrubiralta.marvelapp.domain.model.ImageModel


@Composable
fun MarvelCharacterDetails(model: CharacterModel?, isLoading: Boolean = false, onBackClick: () -> Unit) {

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { onBackClick.invoke() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = null)
                    }
                },
                title = {
                    Text(text = model?.name ?: "Marvel Character Detail")
                },
            )
        }
    ) { innerPadding ->
        if (isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        model?.let {
            Column(
                Modifier
                    .padding(innerPadding)
                    .fillMaxWidth()
            ) {

                AsyncImage(
                    model = "${model.image?.path}.${model.image?.extension}",
                    contentDescription = model.name,
                    placeholder = painterResource(R.drawable.placeholder_image),
                    modifier = Modifier
                        .size(200.dp)
                        .align(Alignment.CenterHorizontally)
                        .padding(8.dp)
                )

                model.name?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.h4,
                        modifier = Modifier.padding(start = 16.dp, top = 8.dp, end = 16.dp)
                    )
                }
                model.description?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier.padding(start = 16.dp, top = 8.dp, end = 16.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun CharacterDetailPreview() {
    MaterialTheme {
        MarvelCharacterDetails(
            CharacterModel(
                "Lorem Ipsum",
                11,
                "Lorem Ipsum",
                ImageModel("jpg", "http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784")
            ),
            false
        ) { /* do nothing */ }
    }
}