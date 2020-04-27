package work.shion.androidpreparation.intentbuilder

import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import android.widget.Button

class LaunchPictureCameraSample : BaseActivity() {

    companion object {
        val testData = mapOf(
                "Empty" to ""
        )
    }


    override fun setupUI(root: ViewGroup): ViewGroup {
        testData.forEach { (key, _) ->
            val from = this@LaunchPictureCameraSample
            root.addView(Button(from).apply {
                setOnClickListener {
                    LaunchPictureCameraIntentBuilder()
                            .build()
                            .start(from)
                }
                text = key
            }, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        }

        return root
    }
}
