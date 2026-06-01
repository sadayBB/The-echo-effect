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
import com.moonlessstudio.theechoeffect.ui.components.SectionTitle

@Composable
fun CreditsScreen(onBack: () -> Unit) {
    MoonlessBackground {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SectionTitle("Créditos")
            Spacer(modifier = Modifier.height(14.dp))
            Text("Moonless Studio", style = MaterialTheme.typography.titleLarge)
            Text("Proyecto universitario", style = MaterialTheme.typography.bodyLarge)
            Text("The Echo Effect", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(20.dp))
            EchoButton(text = "Volver") { onBack() }
        }
    }
}
