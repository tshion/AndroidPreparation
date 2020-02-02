package work.shion.androidpreparation.intentbuilder

import android.app.Activity
import android.app.Instrumentation
import android.app.SearchManager
import android.content.Intent
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SearchWebIntentBuilderTest {

    @get:Rule
    val testRule = IntentsTestRule(SearchWebSample::class.java)


    @Before
    fun setUp() {
        intending(hasAction(Intent.ACTION_WEB_SEARCH))
                .respondWith(Instrumentation.ActivityResult(Activity.RESULT_OK, null))
    }


    @Test
    fun testEmpty() {
        Espresso.onView(ViewMatchers.withText(SearchWebSample.queryEmpty)).perform(ViewActions.click())
        Intents.intended(CoreMatchers.allOf(
                hasAction(Intent.ACTION_WEB_SEARCH),
                hasExtra(SearchManager.QUERY, SearchWebSample.queryEmpty)
        ))
    }

    @Test
    fun testEnglish() {
        Espresso.onView(ViewMatchers.withText(SearchWebSample.queryEnglish)).perform(ViewActions.click())
        Intents.intended(CoreMatchers.allOf(
                hasAction(Intent.ACTION_WEB_SEARCH),
                hasExtra(SearchManager.QUERY, SearchWebSample.queryEnglish)
        ))
    }

    @Test
    fun testJapanese() {
        Espresso.onView(ViewMatchers.withText(SearchWebSample.queryJapanese)).perform(ViewActions.click())
        Intents.intended(CoreMatchers.allOf(
                hasAction(Intent.ACTION_WEB_SEARCH),
                hasExtra(SearchManager.QUERY, SearchWebSample.queryJapanese)
        ))
    }

    @Test
    fun testNull() {
        Espresso.onView(ViewMatchers.withText(SearchWebSample.queryNullTitle)).perform(ViewActions.click())
        Intents.intended(CoreMatchers.allOf(
                hasAction(Intent.ACTION_WEB_SEARCH),
                hasExtra(SearchManager.QUERY, SearchWebSample.queryNull)
        ))
    }
}
