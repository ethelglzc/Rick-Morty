@file:OptIn(ExperimentalMaterial3Api::class)

package edu.ulsa.disney.ui.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@SuppressLint("ViewModelConstructorInComposable")
@Composable
fun HomeScreen(onItemClick: (Int) -> Unit) {

    val viewModel = HomeViewModel()
    val characters by viewModel.characters.collectAsState()

    Scaffold(
        topBar = { TopAppBar(title = { Text("Personajes") }) }
    ) { padding ->

        LazyColumn(contentPadding = padding) {
            items(characters) { character ->
                CharacterItemCard(
                    character = character,
                    onClick = { onItemClick(character.id) }
                )
            }
        }
    }
}
