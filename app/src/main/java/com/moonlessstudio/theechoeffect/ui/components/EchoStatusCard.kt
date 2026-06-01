package com.moonlessstudio.theechoeffect.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun EchoStatusCard(
    playerName: String,
    character: String,
    affinity: String,
    tension: Int,
    statusMessage: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Nombre: $playerName", color = MaterialTheme.colorScheme.onSurfaceVariant)
            Text("Personaje: $character", color = MaterialTheme.colorScheme.onSurfaceVariant)
            Text("Afinidad principal: $affinity", color = MaterialTheme.colorScheme.onSurfaceVariant)
            Text("Tensión del Echo: $tension", color = MaterialTheme.colorScheme.onSurfaceVariant)
            Spacer(modifier = Modifier.height(8.dp))
            Text("Estado: $statusMessage", color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
    }
}
