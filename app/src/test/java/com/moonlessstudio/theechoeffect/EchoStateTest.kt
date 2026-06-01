package com.moonlessstudio.theechoeffect

import com.moonlessstudio.theechoeffect.model.BalanceChoice
import com.moonlessstudio.theechoeffect.model.EchoAffinity
import com.moonlessstudio.theechoeffect.model.EchoState
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class EchoStateTest {

    @Test
    fun updateEcho_withChoice_updatesAffinityAndTension() {
        val state = EchoState()

        val message = state.updateEcho(BalanceChoice())

        assertEquals(1, state.affinityPoints[EchoAffinity.EQUILIBRIO])
        assertEquals(1, state.tension)
        assertTrue(message.contains("Tu Echo halló equilibrio."))
    }

    @Test
    fun updateEcho_withOverloadedMethod_updatesData() {
        val state = EchoState()

        state.updateEcho(EchoAffinity.RUINA, 6)

        assertEquals(EchoAffinity.RUINA, state.primaryAffinity)
        assertEquals(6, state.tension)
    }
}
