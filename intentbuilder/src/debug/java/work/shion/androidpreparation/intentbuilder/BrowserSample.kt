package work.shion.androidpreparation.intentbuilder

import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import android.widget.Button

class BrowserSample : BaseActivity() {

    companion object {
        val testData = mapOf(
                "Empty" to "",
                "Failure" to "hoge://mokumokulog.netlify.com/",
                "Success" to "https://mokumokulog.netlify.com/"
        )
    }


    override fun setupUI(root: ViewGroup): ViewGroup {
        testData.forEach { (key, value) ->
            val from = this@BrowserSample
            root.addView(Button(from).apply {
                setOnClickListener {
                    BrowserIntentBuilder().apply {
                        trySetUri(value)
                    }.build()?.start(from) ?: throw Error()
                }
                text = key
            }, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        }

        return root
    }
}
