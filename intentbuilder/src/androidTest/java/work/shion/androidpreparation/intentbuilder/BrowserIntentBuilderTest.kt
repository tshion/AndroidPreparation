package work.shion.androidpreparation.intentbuilder

import android.app.Activity
import android.app.Instrumentation.ActivityResult
import android.content.Intent
import android.net.Uri
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.intent.matcher.IntentMatchers.hasData
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers.allOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BrowserIntentBuilderTest {

    @get:Rule
    val testRule = IntentsTestRule(BrowserSample::class.java)


    @Before
    fun setUp() {
        intending(hasAction(Intent.ACTION_VIEW))
                .respondWith(ActivityResult(Activity.RESULT_OK, null))
    }


    @Test
    fun testEmpty() {
        onView(withText(BrowserSample.buttonEmpty)).perform(click())
        intended(allOf(
                hasAction(Intent.ACTION_VIEW),
                hasData(Uri.parse(BrowserSample.url))
        ))
    }

    @Test(expected = Error::class)
    fun testEmptyUri() {
        onView(withText(BrowserSample.buttonEmptyUri)).perform(click())
    }

    @Test(expected = NotImplementedError::class)
    fun testHtml() {
        onView(withText(BrowserSample.buttonHtml)).perform(click())
    }

    @Test(expected = NotImplementedError::class)
    fun testPlain() {
        onView(withText(BrowserSample.buttonPlain)).perform(click())
    }

    @Test(expected = NotImplementedError::class)
    fun testXHtml() {
        onView(withText(BrowserSample.buttonXHtml)).perform(click())
    }

    @Test(expected = NotImplementedError::class)
    fun testXHtmlMobile() {
        onView(withText(BrowserSample.buttonXHtmlMobile)).perform(click())
    }
}
