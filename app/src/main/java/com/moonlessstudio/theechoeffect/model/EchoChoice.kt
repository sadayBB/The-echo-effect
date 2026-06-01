package com.moonlessstudio.theechoeffect.model

open class EchoChoice(
    val affinity: EchoAffinity,
    val tensionDelta: Int,
    val narrativeMessage: String
)

class MercyChoice : EchoChoice(EchoAffinity.PIEDAD, 1, "Tu Echo encontró calma.")
class ResolveChoice : EchoChoice(EchoAffinity.RESOLUCION, 2, "Tu Echo tomó firmeza.")
class BalanceChoice : EchoChoice(EchoAffinity.EQUILIBRIO, 1, "Tu Echo halló equilibrio.")
class RuinChoice : EchoChoice(EchoAffinity.RUINA, 3, "Tu Echo dejó una grieta.")
