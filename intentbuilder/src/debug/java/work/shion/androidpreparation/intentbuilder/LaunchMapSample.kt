package work.shion.androidpreparation.intentbuilder

import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import android.widget.Button

class LaunchMapSample : BaseActivity() {

    companion object {
        val testData = mapOf(
                "Empty" to LaunchMapIntentBuilder(),
                "Example1" to LaunchMapIntentBuilder().apply {
                    latitude = 47.6
                    longitude = -122.3
                },
                "Example2" to LaunchMapIntentBuilder().apply {
                    latitude = 47.6
                    longitude = -122.3
                    trySetZoom(11)
                },
                "Example3" to LaunchMapIntentBuilder().apply {
                    appendLabel(34.99, -106.61, "Treasure")
                    latitude = 0.0
                    longitude = 0.0
                },
                "Example4" to LaunchMapIntentBuilder().apply {
                    label.add("my street address")
                    latitude = 0.0
                    longitude = 0.0
                }
        )
    }


    override fun setupUI(root: ViewGroup): ViewGroup {
        testData.forEach { (key, value) ->
            val from = this@LaunchMapSample
            root.addView(Button(from).apply {
                setOnClickListener { value.build().start(from) }
                text = key
            }, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        }
        return root
    }
}
