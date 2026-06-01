package com.moonlessstudio.theechoeffect.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.moonlessstudio.theechoeffect.data.GamePreferences
import com.moonlessstudio.theechoeffect.navigation.Routes
import com.moonlessstudio.theechoeffect.model.BalanceChoice
import com.moonlessstudio.theechoeffect.model.EchoState
import com.moonlessstudio.theechoeffect.model.MercyChoice
import com.moonlessstudio.theechoeffect.model.ResolveChoice
import com.moonlessstudio.theechoeffect.model.RuinChoice
import com.moonlessstudio.theechoeffect.ui.components.EchoButton
import com.moonlessstudio.theechoeffect.ui.components.MoonlessBackground
import com.moonlessstudio.theechoeffect.ui.components.SectionTitle

@Composable
fun GameScreen(onStatus: () -> Unit, onBackToMenu: () -> Unit) {
    val context = LocalContext.current
    val preferences = remember { GamePreferences(context) }
    var state by remember { mutableStateOf(preferences.loadEchoState()) }
    var narrativeMessage by remember { mutableStateOf("Tu Echo despierta en la Estación del Umbral.") }

    fun applyChoice(updatedState: EchoState.() -> String) {
        val current = state
        narrativeMessage = current.updatedState()
        preferences.saveEchoState(current)
        preferences.saveLastScreen(Routes.GAME)
        state = current
    }

    MoonlessBackground {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SectionTitle("Estación del Umbral")
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = narrativeMessage,
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.height(16.dp))
            EchoButton(text = "Actuar con Piedad") { applyChoice { updateEcho(MercyChoice()) } }
            Spacer(modifier = Modifier.height(8.dp))
            EchoButton(text = "Actuar con Resolución") { applyChoice { updateEcho(ResolveChoice()) } }
            Spacer(modifier = Modifier.height(8.dp))
            EchoButton(text = "Mantener Equilibrio") { applyChoice { updateEcho(BalanceChoice()) } }
            Spacer(modifier = Modifier.height(8.dp))
            EchoButton(text = "Ceder a Ruina") { applyChoice { updateEcho(RuinChoice()) } }
            Spacer(modifier = Modifier.height(16.dp))
            EchoButton(text = "Ver estado del Echo") {
                preferences.saveLastScreen(Routes.ECHO_STATUS)
                onStatus()
            }
            Spacer(modifier = Modifier.height(8.dp))
            EchoButton(text = "Volver al menú") {
                preferences.saveLastScreen(Routes.START_MENU)
                onBackToMenu()
            }
        }
    }
}
