package com.example.module2

import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class Task8Test {
    @get:Rule
    val compose = androidx.compose.ui.test.junit4.v2.createComposeRule()

    private fun counterValue(tag: String): Int =
        compose.onNodeWithTag(tag)
            .fetchSemanticsNode()
            .config[SemanticsProperties.Text].first().text
            .filter { it.isDigit() }
            .toInt()

    private fun water() = counterValue("water_counter")
    private fun streak() = counterValue("streak_counter")

    private fun addWater(times: Int = 1) {
        repeat(times) { compose.onNodeWithText("+250 мл").performClick() }
    }

    @Before
    fun setUp() {
        compose.setContent { WaterTracker() }
    }

    @Test
    fun checkAdditionButton() {
        val before = water()

        compose.onNodeWithText("+250 мл")
            .assertIsDisplayed()

        addWater()

        assertEquals(before + 250, water())
    }

    @Test
    fun checkFinishDayButton() {
        addWater()
        assertEquals(250, water())

        compose.onNodeWithText("Завершить день")
            .assertExists()
            .performClick()

        assertEquals(0, water())
    }

    @Test
    fun checkGoalStreakButton() {
        val goal = 1500
        val initStreak = streak()

        addWater(goal / 250)

        assertEquals(goal, water())
        assertEquals(initStreak + 1, streak())

    }
}