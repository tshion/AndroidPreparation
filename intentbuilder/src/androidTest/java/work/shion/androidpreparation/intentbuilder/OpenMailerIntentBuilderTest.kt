package work.shion.androidpreparation.intentbuilder

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import android.net.Uri
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers.*
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class OpenMailerIntentBuilderTest {

    @get:Rule
    val testRule = IntentsTestRule(OpenMailerSample::class.java)

    @Before
    fun setUp() {
        intending(hasAction(Intent.ACTION_SEND))
                .respondWith(Instrumentation.ActivityResult(Activity.RESULT_OK, null))
        intending(hasAction(Intent.ACTION_SEND_MULTIPLE))
                .respondWith(Instrumentation.ActivityResult(Activity.RESULT_OK, null))
        intending(hasAction(Intent.ACTION_SENDTO))
                .respondWith(Instrumentation.ActivityResult(Activity.RESULT_OK, null))
    }


    @Test
    fun empty() {
        val (key, _) = "Empty".let { it to OpenMailerSample.testData[it] }
        Espresso.onView(ViewMatchers.withText(key)).perform(ViewActions.click())
        Intents.intended(CoreMatchers.allOf(
                hasAction(Intent.ACTION_SENDTO),
                hasData(Uri.parse("mailto:"))
        ))
    }

    @Test
    fun success1() {
        val (key, data) = "Success1".let { it to OpenMailerSample.testData[it] }
        Espresso.onView(ViewMatchers.withText(key)).perform(ViewActions.click())
        Intents.intended(CoreMatchers.allOf(
                hasAction(Intent.ACTION_SENDTO),
                hasData(Uri.parse("mailto:")),
                hasExtra(Intent.EXTRA_BCC, data?.bcc?.toTypedArray()),
                hasExtra(Intent.EXTRA_CC, data?.cc?.toTypedArray()),
                hasExtra(Intent.EXTRA_EMAIL, data?.to?.toTypedArray()),
                hasExtra(Intent.EXTRA_SUBJECT, data?.subject),
                hasExtra(Intent.EXTRA_TEXT, data?.text)
        ))
    }
}
