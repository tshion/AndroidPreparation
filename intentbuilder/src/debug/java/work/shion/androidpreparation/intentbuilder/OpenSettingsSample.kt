package work.shion.androidpreparation.intentbuilder

import android.app.Activity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import android.widget.ScrollView

class OpenSettingsSample : Activity() {

    companion object {
        val testData = mapOf(
                "settings" to OpenSettingsIntentBuilder().build()
        )
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ScrollView(this).apply {
            layoutParams = LayoutParams(MATCH_PARENT, MATCH_PARENT)
        }.let { root ->
            val from = this@OpenSettingsSample
            testData.forEach { (key, value) ->
                root.addView(Button(from).apply {
                    setOnClickListener { value.start(from) }
                    text = key
                }, MATCH_PARENT, WRAP_CONTENT)
            }
            root
        }.also { setContentView(it) }
    }
}
