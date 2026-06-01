package com.moonlessstudio.theechoeffect.model

class MaleEchoCharacter : CharacterBase(
    codeName = "echo_male",
    displayName = "Echo masculino",
    introText = "Su paso resuena con temple entre los restos del Umbral."
) {
    override fun describeCharacter(): String = "$displayName: firme ante la noche."
}
