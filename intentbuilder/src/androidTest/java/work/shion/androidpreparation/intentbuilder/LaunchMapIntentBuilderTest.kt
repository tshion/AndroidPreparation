package work.shion.androidpreparation.intentbuilder

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
import org.hamcrest.CoreMatchers
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.net.URLEncoder

@RunWith(AndroidJUnit4::class)
class LaunchMapIntentBuilderTest {

    @get:Rule
    val testRule = IntentsTestRule(LaunchMapSample::class.java)

    @Before
    fun setUp() {
        intending(hasAction(Intent.ACTION_VIEW))
                .respondWith(Instrumentation.ActivityResult(Activity.RESULT_OK, null))
    }


    @Test
    fun empty() {
        val (key, _) = "Empty".let { it to LaunchMapSample.testData[it] }
        Espresso.onView(ViewMatchers.withText(key)).perform(ViewActions.click())
        Intents.intended(CoreMatchers.allOf(
                hasAction(Intent.ACTION_VIEW)
        ))
    }

    @Test
    fun example1() {
        val (key, data) = "Example1".let { it to LaunchMapSample.testData[it] }
        Espresso.onView(ViewMatchers.withText(key)).perform(ViewActions.click())
        Intents.intended(CoreMatchers.allOf(
                hasAction(Intent.ACTION_VIEW),
                hasData(Uri.parse("geo:${data?.latitude},${data?.longitude}?"))
        ))
    }

    @Test
    fun example2() {
        val (key, data) = "Example2".let { it to LaunchMapSample.testData[it] }
        Espresso.onView(ViewMatchers.withText(key)).perform(ViewActions.click())
        Intents.intended(CoreMatchers.allOf(
                hasAction(Intent.ACTION_VIEW),
                hasData(Uri.parse("geo:${data?.latitude},${data?.longitude}?z=${data?.zoom}"))
        ))
    }

    @Test
    fun example3() {
        val (key, data) = "Example3".let { it to LaunchMapSample.testData[it] }
        Espresso.onView(ViewMatchers.withText(key)).perform(ViewActions.click())
        Intents.intended(CoreMatchers.allOf(
                hasAction(Intent.ACTION_VIEW),
                hasData(Uri.parse("geo:${data?.latitude},${data?.longitude}?q=${URLEncoder.encode(data?.label?.first(), "UTF-8")}"))
        ))
    }

    @Test
    fun example3a() {
        val (key, data) = "Example3a".let { it to LaunchMapSample.testData[it] }
        Espresso.onView(ViewMatchers.withText(key)).perform(ViewActions.click())
        Intents.intended(CoreMatchers.allOf(
                hasAction(Intent.ACTION_VIEW),
                hasData(Uri.parse("geo:${data?.latitude},${data?.longitude}?q=${URLEncoder.encode(data?.label?.first(), "UTF-8")}"))
        ))
    }

    @Test
    fun example4() {
        val (key, data) = "Example4".let { it to LaunchMapSample.testData[it] }
        Espresso.onView(ViewMatchers.withText(key)).perform(ViewActions.click())
        Intents.intended(CoreMatchers.allOf(
                hasAction(Intent.ACTION_VIEW),
                hasData(Uri.parse("geo:${data?.latitude},${data?.longitude}?q=${URLEncoder.encode(data?.label?.first(), "UTF-8")}"))
        ))
    }

    @Test
    fun example4a() {
        val (key, data) = "Example4a".let { it to LaunchMapSample.testData[it] }
        Espresso.onView(ViewMatchers.withText(key)).perform(ViewActions.click())
        Intents.intended(CoreMatchers.allOf(
                hasAction(Intent.ACTION_VIEW),
                hasData(Uri.parse("geo:${data?.latitude},${data?.longitude}?q=${URLEncoder.encode(data?.label?.first(), "UTF-8")}"))
        ))
    }
}
