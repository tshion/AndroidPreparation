package work.shion.androidpreparation.intentbuilder

import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import android.widget.Button

class OpenMapSample : BaseActivity() {

    companion object {
        val testData = mapOf(
                "Empty" to OpenMapIntentBuilder(),
                "Example1" to OpenMapIntentBuilder()
                        .latitude(47.6)
                        .longitude(-122.3),
                "Example2" to OpenMapIntentBuilder()
                        .latitude(47.6)
                        .longitude(-122.3)
                        .zoom(11),
                "Example3" to OpenMapIntentBuilder()
                        .appendLabel(34.99, -106.61, "Treasure")
                        .latitude(0.0)
                        .longitude(0.0),
                "Example3a" to OpenMapIntentBuilder()
                        .appendLabel(35.681236, 139.767125, "東京駅")
                        .latitude(0.0)
                        .longitude(0.0),
                "Example4" to OpenMapIntentBuilder()
                        .appendLabel("my street address")
                        .latitude(0.0)
                        .longitude(0.0),
                "Example4a" to OpenMapIntentBuilder()
                        .appendLabel("東京駅 ランチ")
                        .latitude(0.0)
                        .longitude(0.0)
        )
    }


    override fun setupUI(root: ViewGroup): ViewGroup {
        testData.forEach { (key, value) ->
            val from = this@OpenMapSample
            root.addView(Button(from).apply {
                setOnClickListener { value.build().start(from) }
                text = key
            }, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        }
        return root
    }
}
