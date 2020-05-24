package work.shion.androidpreparation.intentbuilder

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent.ACTION_CREATE_DOCUMENT
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CreateFileBuilderTest {

    @get:Rule
    val testRule = IntentsTestRule(CreateFileSample::class.java)

    @Before
    fun setUp() {
        intending(hasAction(ACTION_CREATE_DOCUMENT))
                .respondWith(Instrumentation.ActivityResult(Activity.RESULT_OK, null))
    }


    @Test
    fun empty() {
        val data = "Empty".let { it to CreateFileSample.testData[it] }
        Espresso.onView(ViewMatchers.withText(data.first)).perform(ViewActions.click())
    }

    @Test
    fun image() {
        val data = "Image".let { it to CreateFileSample.testData[it] }
        Espresso.onView(ViewMatchers.withText(data.first)).perform(ViewActions.click())
    }
}
