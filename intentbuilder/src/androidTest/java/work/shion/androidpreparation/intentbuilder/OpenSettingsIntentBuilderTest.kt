package work.shion.androidpreparation.intentbuilder

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class OpenSettingsIntentBuilderTest {

    @get:Rule
    val testRule = IntentsTestRule(OpenSettingsSample::class.java)


    @Test
    fun settings() = test("settings")


    private fun test(key: String) {
        val (title, data) = key.let { it to OpenSettingsSample.testData[it] }
        Espresso.onView(ViewMatchers.withText(title)).perform(ViewActions.click())
        Intents.intended(CoreMatchers.allOf(
                hasAction(data!!.action)
        ))
    }
}
