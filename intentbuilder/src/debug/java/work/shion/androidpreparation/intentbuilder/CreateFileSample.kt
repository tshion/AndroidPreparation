package work.shion.androidpreparation.intentbuilder

import android.view.ViewGroup
import android.widget.Button
import work.shion.androidpreparation.intentbuilder.basis.CreateFileIntent

class CreateFileSample : BaseActivity() {

    companion object {
        private const val REQUEST_CODE = 1000
        val testData = mapOf(
                "Empty" to CreateFileIntentBuilder().appendMimeType("image/png").build(),
                "Image" to CreateFileIntentBuilder().appendMimeType("image/png").title("image").build()
        )
    }

    override fun setupUI(root: ViewGroup): ViewGroup {
        testData.forEach { (key, value) ->
            val from = this@CreateFileSample
            root.addView(Button(from).apply {
                setOnClickListener { value?.start(from, REQUEST_CODE) }
                text = key
            }, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        }

        return root
    }
}
