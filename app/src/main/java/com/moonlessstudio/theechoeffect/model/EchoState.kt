package com.moonlessstudio.theechoeffect.model

class EchoState(
    var primaryAffinity: EchoAffinity = EchoAffinity.EQUILIBRIO,
    var tension: Int = 0,
    val affinityPoints: MutableMap<EchoAffinity, Int> = defaultPoints()
) {
    // Constructor secundario para cumplir con la rúbrica de sobrecarga.
    constructor(primaryAffinity: EchoAffinity, tension: Int) : this(
        primaryAffinity = primaryAffinity,
        tension = tension,
        affinityPoints = defaultPoints()
    )

    fun updateEcho(choice: EchoChoice): String {
        return updateEcho(choice.affinity, choice.tensionDelta, choice.narrativeMessage)
    }

    fun updateEcho(affinity: EchoAffinity, tensionAmount: Int): String {
        return updateEcho(affinity, tensionAmount, null)
    }

    private fun updateEcho(
        affinity: EchoAffinity,
        tensionAmount: Int,
        customMessage: String?
    ): String {
        // Cada decisión suma puntos a la afinidad elegida y ajusta la tensión global.
        val current = affinityPoints[affinity] ?: 0
        affinityPoints[affinity] = current + 1
        tension = (tension + tensionAmount).coerceAtLeast(0)
        primaryAffinity = affinityPoints.maxByOrNull { it.value }?.key ?: EchoAffinity.EQUILIBRIO

        val baseMessage = customMessage ?: affinityNarrative(affinity)
        val tensionMessage = tensionNarrative()
        return if (tensionMessage.isBlank()) baseMessage else "$baseMessage $tensionMessage"
    }

    fun tensionNarrative(): String {
        return when {
            tension >= 10 -> "El mundo empieza a responder a tu patrón."
            tension >= 6 -> "Tu Echo comienza a tensarse."
            else -> ""
        }
    }

    companion object {
        fun defaultPoints(): MutableMap<EchoAffinity, Int> = mutableMapOf(
            EchoAffinity.PIEDAD to 0,
            EchoAffinity.RESOLUCION to 0,
            EchoAffinity.EQUILIBRIO to 0,
            EchoAffinity.RUINA to 0
        )

        fun affinityNarrative(affinity: EchoAffinity): String = when (affinity) {
            EchoAffinity.PIEDAD -> "Tu Echo encontró calma."
            EchoAffinity.RESOLUCION -> "Tu Echo tomó firmeza."
            EchoAffinity.EQUILIBRIO -> "Tu Echo halló equilibrio."
            EchoAffinity.RUINA -> "Tu Echo dejó una grieta."
        }
    }
}
