package edu.ulsa.disney.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import edu.ulsa.disney.data.model.Character

@Composable
fun CharacterItemCard(character: Character, onClick: () -> Unit) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() }
    ) {
        Row(Modifier.padding(8.dp)) {

            AsyncImage(
                model = character.image,
                contentDescription = character.name,
                modifier = Modifier.size(80.dp)
            )

            Spacer(Modifier.width(12.dp))

            Column {
                Text(character.name, style = MaterialTheme.typography.titleLarge)
                Text(character.status, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}
