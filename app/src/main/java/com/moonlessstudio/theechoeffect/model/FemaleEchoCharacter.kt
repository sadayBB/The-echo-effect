package com.moonlessstudio.theechoeffect.model

class FemaleEchoCharacter : CharacterBase(
    codeName = "echo_female",
    displayName = "Echo femenino",
    introText = "Su voz corta la niebla con elegancia y misterio."
) {
    override fun describeCharacter(): String = "$displayName: lúcida ante lo desconocido."
}
