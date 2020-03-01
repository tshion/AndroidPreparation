package work.shion.androidpreparation.intentbuilder

import android.Manifest
import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import android.net.Uri
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.intent.matcher.IntentMatchers.hasData
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.GrantPermissionRule
import org.hamcrest.CoreMatchers
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CallVoiceMailIntentBuilderTest {

    @get:Rule
    val grantRule = GrantPermissionRule.grant(Manifest.permission.CALL_PHONE)

    @get:Rule
    val testRule = IntentsTestRule(CallVoiceMailSample::class.java)

    @Before
    fun setUp() {
        intending(hasAction(Intent.ACTION_CALL))
                .respondWith(Instrumentation.ActivityResult(Activity.RESULT_OK, null))
    }


    @Test
    fun empty() {
        val (key, _) = "Empty".let { it to CallVoiceMailSample.testData[it] }
        Espresso.onView(ViewMatchers.withText(key)).perform(ViewActions.click())
    }

    @Test
    fun success1() {
        val (key, data) = "Success1".let { it to CallVoiceMailSample.testData[it] }
        Espresso.onView(ViewMatchers.withText(key)).perform(ViewActions.click())
        Intents.intended(CoreMatchers.allOf(
                hasAction(Intent.ACTION_CALL),
                hasData(Uri.parse("voicemail:${data}"))
        ))
    }

    @Test
    fun success2() {
        val (key, data) = "Success2".let { it to CallVoiceMailSample.testData[it] }
        Espresso.onView(ViewMatchers.withText(key)).perform(ViewActions.click())
        Intents.intended(CoreMatchers.allOf(
                hasAction(Intent.ACTION_CALL),
                hasData(Uri.parse("voicemail:${data}"))
        ))
    }

    @Test
    fun unknown1() {
        val (key, _) = "Unknown1".let { it to CallVoiceMailSample.testData[it] }
        Espresso.onView(ViewMatchers.withText(key)).perform(ViewActions.click())
    }

    @Test
    fun unknown2() {
        val (key, _) = "Unknown2".let { it to CallVoiceMailSample.testData[it] }
        Espresso.onView(ViewMatchers.withText(key)).perform(ViewActions.click())
    }
}
