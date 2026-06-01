package com.moonlessstudio.theechoeffect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.moonlessstudio.theechoeffect.navigation.AppNavigation
import com.moonlessstudio.theechoeffect.ui.theme.TheEchoEffectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TheEchoEffectTheme {
                AppNavigation()
            }
        }
    }
}
