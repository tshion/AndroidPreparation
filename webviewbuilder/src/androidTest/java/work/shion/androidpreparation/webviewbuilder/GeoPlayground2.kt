package work.shion.androidpreparation.webviewbuilder

import androidx.test.espresso.web.sugar.Web.onWebView
import androidx.test.espresso.web.webdriver.DriverAtoms.findElement
import androidx.test.espresso.web.webdriver.DriverAtoms.webClick
import androidx.test.espresso.web.webdriver.Locator
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class GeoPlayground2 {

    @get:Rule
    val targetRule = activityScenarioRule<GeoActivity2>()


    @Test
    fun tapGeo() {
        onWebView().forceJavascriptEnabled()
                .withElement(findElement(Locator.CSS_SELECTOR, "button.ml-button-my-location-fab"))
                .perform(webClick())
    }
}
