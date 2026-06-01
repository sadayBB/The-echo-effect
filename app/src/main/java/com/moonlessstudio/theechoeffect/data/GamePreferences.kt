package com.moonlessstudio.theechoeffect.data

import android.content.Context
import com.moonlessstudio.theechoeffect.model.EchoAffinity
import com.moonlessstudio.theechoeffect.model.EchoState

class GamePreferences(context: Context) {

    // SharedPreferences centraliza el progreso básico del jugador.
    private val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun savePlayerName(name: String) {
        prefs.edit().putString(KEY_PLAYER_NAME, name).apply()
    }

    fun getPlayerName(): String = prefs.getString(KEY_PLAYER_NAME, "Viajero") ?: "Viajero"

    fun saveCharacter(character: String) {
        prefs.edit().putString(KEY_CHARACTER, character).apply()
    }

    fun getCharacter(): String = prefs.getString(KEY_CHARACTER, "Sin seleccionar") ?: "Sin seleccionar"

    fun saveLastScreen(route: String) {
        prefs.edit().putString(KEY_LAST_SCREEN, route).apply()
    }

    fun getLastScreen(): String = prefs.getString(KEY_LAST_SCREEN, "") ?: ""

    fun setSoundEnabled(enabled: Boolean) {
        prefs.edit().putBoolean(KEY_SOUND_ENABLED, enabled).apply()
    }

    fun isSoundEnabled(): Boolean = prefs.getBoolean(KEY_SOUND_ENABLED, true)

    fun saveEchoState(state: EchoState) {
        prefs.edit()
            .putString(KEY_PRIMARY_AFFINITY, state.primaryAffinity.name)
            .putInt(KEY_TENSION, state.tension)
            .putInt(KEY_POINTS_PIEDAD, state.affinityPoints[EchoAffinity.PIEDAD] ?: 0)
            .putInt(KEY_POINTS_RESOLUCION, state.affinityPoints[EchoAffinity.RESOLUCION] ?: 0)
            .putInt(KEY_POINTS_EQUILIBRIO, state.affinityPoints[EchoAffinity.EQUILIBRIO] ?: 0)
            .putInt(KEY_POINTS_RUINA, state.affinityPoints[EchoAffinity.RUINA] ?: 0)
            .apply()
    }

    fun loadEchoState(): EchoState {
        val affinityName = prefs.getString(KEY_PRIMARY_AFFINITY, EchoAffinity.EQUILIBRIO.name)
        val affinity = runCatching { EchoAffinity.valueOf(affinityName ?: EchoAffinity.EQUILIBRIO.name) }
            .getOrDefault(EchoAffinity.EQUILIBRIO)

        val state = EchoState(primaryAffinity = affinity, tension = prefs.getInt(KEY_TENSION, 0))
        state.affinityPoints[EchoAffinity.PIEDAD] = prefs.getInt(KEY_POINTS_PIEDAD, 0)
        state.affinityPoints[EchoAffinity.RESOLUCION] = prefs.getInt(KEY_POINTS_RESOLUCION, 0)
        state.affinityPoints[EchoAffinity.EQUILIBRIO] = prefs.getInt(KEY_POINTS_EQUILIBRIO, 0)
        state.affinityPoints[EchoAffinity.RUINA] = prefs.getInt(KEY_POINTS_RUINA, 0)
        state.primaryAffinity = state.affinityPoints.maxByOrNull { it.value }?.key ?: affinity
        return state
    }

    companion object {
        private const val PREFS_NAME = "the_echo_effect_prefs"

        private const val KEY_PLAYER_NAME = "player_name"
        private const val KEY_CHARACTER = "selected_character"
        private const val KEY_LAST_SCREEN = "last_screen"
        private const val KEY_PRIMARY_AFFINITY = "primary_affinity"
        private const val KEY_TENSION = "echo_tension"
        private const val KEY_POINTS_PIEDAD = "points_piedad"
        private const val KEY_POINTS_RESOLUCION = "points_resolucion"
        private const val KEY_POINTS_EQUILIBRIO = "points_equilibrio"
        private const val KEY_POINTS_RUINA = "points_ruina"
        private const val KEY_SOUND_ENABLED = "sound_enabled"
    }
}
