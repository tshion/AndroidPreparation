package work.shion.androidpreparation.intentbuilder

import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import android.widget.Button

class SearchWebSample : BaseActivity() {

    companion object {
        val testData = mapOf(
                "Empty" to "",
                "English" to "Android",
                "Japanese" to "アンドロイド",
                "Null" to null
        )
    }


    override fun setupUI(root: ViewGroup): ViewGroup {
        testData.forEach { (key, value) ->
            val from = this@SearchWebSample
            root.addView(Button(from).apply {
                setOnClickListener {
                    SearchWebIntentBuilder()
                            .query(value)
                            .build()
                            .start(from)
                }
                text = key
            }, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        }

        return root
    }
}
