@file:OptIn(ExperimentalMaterial3Api::class)

package edu.ulsa.disney.ui.detail

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import androidx.compose.material.icons.filled.ArrowBack

@SuppressLint("ViewModelConstructorInComposable")
@Composable
fun DetailScreen(id: Int, onBack: () -> Unit) {

    val viewModel = DetailViewModel()
    val data by viewModel.detail.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadCharacterDetail(id)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detalle") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->

        data?.let { character ->

            Column(Modifier.padding(padding).padding(16.dp)) {

                AsyncImage(
                    model = character.image,
                    contentDescription = character.name,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(Modifier.height(16.dp))

                Text(character.name, style = MaterialTheme.typography.headlineMedium)

                Spacer(Modifier.height(8.dp))

                Text("Status: ${character.status}")
                Text("Species: ${character.species}")
                Text("Gender: ${character.gender}")
                Text("Origin: ${character.origin.name}")
            }
        }
    }
}
