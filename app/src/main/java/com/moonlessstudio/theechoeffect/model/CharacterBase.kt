package com.moonlessstudio.theechoeffect.model

open class CharacterBase(
    val codeName: String,
    val displayName: String,
    val introText: String
) {
    constructor(displayName: String) : this(
        codeName = displayName.lowercase().replace(" ", "_"),
        displayName = displayName,
        introText = "Un eco despierta entre sombras."
    )

    open fun describeCharacter(): String = "$displayName ($codeName): $introText"
}
