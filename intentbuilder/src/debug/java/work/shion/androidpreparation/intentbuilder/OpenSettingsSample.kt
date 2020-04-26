package work.shion.androidpreparation.intentbuilder

import android.app.Activity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView

class OpenSettingsSample : Activity() {

    companion object {
        val testData = mapOf(
                "settings" to OpenSettingsIntentBuilder().build()
        )
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

            val from = this@OpenSettingsSample
        LinearLayout(from).apply {
            layoutParams = LayoutParams(MATCH_PARENT, WRAP_CONTENT)
            orientation = LinearLayout.VERTICAL
        }.let { linearRoot ->
            testData.forEach { (key, value) ->
                linearRoot.addView(Button(from).apply {
                    setOnClickListener { value.start(from) }
                    text = key
                }, MATCH_PARENT, WRAP_CONTENT)
            }
            linearRoot
        }.let { linearRoot ->
            ScrollView(this).apply {
                layoutParams = LayoutParams(MATCH_PARENT, MATCH_PARENT)
                addView(linearRoot)
            }
        }.also { setContentView(it) }
    }
}
