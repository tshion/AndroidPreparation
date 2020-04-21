package work.shion.androidpreparation.intentbuilder

import android.app.Activity
import android.app.Instrumentation
import android.provider.MediaStore
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LaunchPictureCameraIntentBuilderTest {

    @get:Rule
    val testRule = IntentsTestRule(LaunchPictureCameraSample::class.java)

    @Before
    fun setUp() {
        intending(hasAction(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA))
                .respondWith(Instrumentation.ActivityResult(Activity.RESULT_OK, null))
    }


    @Test
    fun empty() {
        val data = "Empty".let { it to LaunchPhoneSample.testData[it] }
        Espresso.onView(ViewMatchers.withText(data.first)).perform(ViewActions.click())
        Intents.intended(CoreMatchers.allOf(
                hasAction(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA)
        ))
    }
}
