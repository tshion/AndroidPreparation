package work.shion.androidpreparation.intentbuilder

import android.view.ViewGroup
import android.widget.Button

class OpenFileSample : BaseActivity() {

    companion object {
        private const val REQUEST_CODE = 1000
        val testData = mapOf(
                "Empty" to OpenFileIntentBuilder().build(),
                "Image" to OpenFileIntentBuilder().appendMimeType("image/*").build()
        )
    }

    override fun setupUI(root: ViewGroup): ViewGroup {
        testData.forEach { (key, value) ->
            val from = this@OpenFileSample
            root.addView(Button(from).apply {
                setOnClickListener { value?.start(from, REQUEST_CODE) }
                text = key
            }, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        }

        return root
    }
}
