package com.moonlessstudio.theechoeffect.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.moonlessstudio.theechoeffect.data.GamePreferences
import com.moonlessstudio.theechoeffect.navigation.Routes
import com.moonlessstudio.theechoeffect.ui.components.EchoButton
import com.moonlessstudio.theechoeffect.ui.components.EchoStatusCard
import com.moonlessstudio.theechoeffect.ui.components.MoonlessBackground
import com.moonlessstudio.theechoeffect.ui.components.SectionTitle

@Composable
fun EchoStatusScreen(onBackToMenu: () -> Unit) {
    val context = LocalContext.current
    val preferences = remember { GamePreferences(context) }
    val state = remember { preferences.loadEchoState() }

    MoonlessBackground {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SectionTitle("Estado del Echo")
            Spacer(modifier = Modifier.height(14.dp))
            EchoStatusCard(
                playerName = preferences.getPlayerName(),
                character = preferences.getCharacter(),
                affinity = state.primaryAffinity.name,
                tension = state.tension,
                statusMessage = state.tensionNarrative().ifBlank { "Tu Echo permanece estable." }
            )
            Spacer(modifier = Modifier.height(16.dp))
            EchoButton(text = "Volver al menú") {
                preferences.saveLastScreen(Routes.START_MENU)
                onBackToMenu()
            }
        }
    }
}
