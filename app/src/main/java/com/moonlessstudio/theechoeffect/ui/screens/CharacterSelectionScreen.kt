package com.moonlessstudio.theechoeffect.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import com.moonlessstudio.theechoeffect.model.CharacterBase
import com.moonlessstudio.theechoeffect.model.FemaleEchoCharacter
import com.moonlessstudio.theechoeffect.model.MaleEchoCharacter
import com.moonlessstudio.theechoeffect.ui.components.EchoButton
import com.moonlessstudio.theechoeffect.ui.components.MoonlessBackground
import com.moonlessstudio.theechoeffect.ui.components.SectionTitle

@Composable
fun CharacterSelectionScreen(onConfirm: () -> Unit, onBack: () -> Unit) {
    val context = LocalContext.current
    val preferences = remember { GamePreferences(context) }

    var playerName by remember { mutableStateOf(preferences.getPlayerName()) }
    var selectedCharacter by remember { mutableStateOf(preferences.getCharacter()) }
    var selectedDescription by remember { mutableStateOf("") }

    fun selectCharacter(character: CharacterBase) {
        selectedCharacter = character.displayName
        selectedDescription = character.describeCharacter()
    }

    MoonlessBackground {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SectionTitle("Selección de Echo")
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = playerName,
                onValueChange = { playerName = it },
                label = { Text("Nombre del jugador") }
            )
            Spacer(modifier = Modifier.height(12.dp))
            EchoButton(text = "Elegir Echo masculino") { selectCharacter(MaleEchoCharacter()) }
            Spacer(modifier = Modifier.height(8.dp))
            EchoButton(text = "Elegir Echo femenino") { selectCharacter(FemaleEchoCharacter()) }
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Seleccionado: $selectedCharacter",
                color = MaterialTheme.colorScheme.onBackground
            )
            if (selectedDescription.isNotBlank()) {
                Spacer(modifier = Modifier.height(6.dp))
                Text(selectedDescription, color = MaterialTheme.colorScheme.onBackground)
            }
            Spacer(modifier = Modifier.height(18.dp))
            EchoButton(text = "Confirmar selección") {
                preferences.savePlayerName(playerName.ifBlank { "Viajero" })
                preferences.saveCharacter(selectedCharacter.ifBlank { "Echo masculino" })
                preferences.saveLastScreen(Routes.GAME)
                onConfirm()
            }
            Spacer(modifier = Modifier.height(8.dp))
            EchoButton(text = "Volver") {
                preferences.saveLastScreen(Routes.START_MENU)
                onBack()
            }
        }
    }
}
