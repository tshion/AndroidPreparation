package work.shion.androidpreparation.intentbuilder

import android.app.Activity
import android.app.Instrumentation.ActivityResult
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
import org.hamcrest.CoreMatchers
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class OpenBrowserIntentBuilderTest {

    @get:Rule
    val testRule = IntentsTestRule(OpenBrowserSample::class.java)


    @Before
    fun setUp() {
        intending(hasAction(Intent.ACTION_VIEW))
                .respondWith(ActivityResult(Activity.RESULT_OK, null))
    }


    @Test(expected = Error::class)
    fun empty() {
        val (key, _) = "Empty".let { it to OpenBrowserSample.testData[it] }
        Espresso.onView(ViewMatchers.withText(key)).perform(ViewActions.click())
        Intents.intended(CoreMatchers.allOf(
                hasAction(Intent.ACTION_VIEW)
        ))
    }

    @Test(expected = Error::class)
    fun failure() {
        val (key, _) = "Failure".let { it to OpenBrowserSample.testData[it] }
        Espresso.onView(ViewMatchers.withText(key)).perform(ViewActions.click())
        Intents.intended(CoreMatchers.allOf(
                hasAction(Intent.ACTION_VIEW)
        ))
    }

    @Test
    fun success() {
        val (key, data) = "Success".let { it to OpenBrowserSample.testData[it] }
        Espresso.onView(ViewMatchers.withText(key)).perform(ViewActions.click())
        Intents.intended(CoreMatchers.allOf(
                hasAction(Intent.ACTION_VIEW),
                hasData(Uri.parse(data))
        ))
    }
}
