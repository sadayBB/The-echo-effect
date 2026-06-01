package com.moonlessstudio.theechoeffect.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.moonlessstudio.theechoeffect.ui.components.EchoButton
import com.moonlessstudio.theechoeffect.ui.components.MoonlessBackground

@Composable
fun StartMenuScreen(
    onNewGame: () -> Unit,
    onContinue: () -> Unit,
    onStatus: () -> Unit,
    onCredits: () -> Unit
) {
    MoonlessBackground {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("The Echo Effect", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(20.dp))
            EchoButton(text = "Nueva partida", onClick = onNewGame)
            Spacer(modifier = Modifier.height(10.dp))
            EchoButton(text = "Continuar", onClick = onContinue)
            Spacer(modifier = Modifier.height(10.dp))
            EchoButton(text = "Estado del Echo", onClick = onStatus)
            Spacer(modifier = Modifier.height(10.dp))
            EchoButton(text = "Créditos", onClick = onCredits)
        }
    }
}
