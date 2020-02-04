package work.shion.androidpreparation.intentbuilder

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import android.provider.CalendarContract.Events
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CalendarEventIntentBuilderTest {

    @get:Rule
    val testRule = IntentsTestRule(CalendarEventSample::class.java)


    @Before
    fun setUp() {
        Intents.intending(IntentMatchers.hasAction(Intent.ACTION_INSERT))
                .respondWith(Instrumentation.ActivityResult(Activity.RESULT_OK, null))
    }

    @Test
    fun testEmpty() {
        onView(withText(CalendarEventSample.paramEmpty)).perform(click())
        intended(CoreMatchers.allOf(
                IntentMatchers.hasAction(Intent.ACTION_INSERT),
                IntentMatchers.hasData(Events.CONTENT_URI)
        ))
    }

    @Test
    fun testFull() {
        onView(withText(CalendarEventSample.paramFull)).perform(click())
        intended(CoreMatchers.allOf(
                IntentMatchers.hasAction(Intent.ACTION_INSERT),
                IntentMatchers.hasData(Events.CONTENT_URI)
        ))
    }
}
