package edu.ulsa.disney.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import edu.ulsa.disney.data.model.Character
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.background

@Composable
fun CharacterItemCard(character: Character, onClick: () -> Unit) {
    val statusColor = when (character.status.lowercase()) {
        "alive" -> Color(0xFF218526)   // Verde
        "dead" -> Color(0xFF7E0F07)    // Rojo
        else -> Color(0xFF1E2449)      // Gris oscuro
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(Modifier.padding(10.dp)) {

            AsyncImage(
                model = character.image,
                contentDescription = character.name,
                modifier = Modifier.size(100.dp)
            )

            Spacer(Modifier.width(20.dp))

            Column {
                Text(character.name, style = MaterialTheme.typography.titleLarge)
                Text("Status: "+ character.status, style = MaterialTheme.typography.labelLarge, color = statusColor)
            }

        }
    }
}
