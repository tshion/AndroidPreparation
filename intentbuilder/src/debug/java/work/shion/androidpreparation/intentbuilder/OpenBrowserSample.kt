package work.shion.androidpreparation.intentbuilder

import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import android.widget.Button

class OpenBrowserSample : BaseActivity() {

    companion object {
        val testData = mapOf(
                "Empty" to "",
                "Failure" to "hoge://mokumokulog.netlify.com/",
                "Success" to "https://mokumokulog.netlify.com/"
        )
    }


    override fun setupUI(root: ViewGroup): ViewGroup {
        testData.forEach { (key, value) ->
            val from = this@OpenBrowserSample
            root.addView(Button(from).apply {
                setOnClickListener {
                    OpenBrowserIntentBuilder()
                            .uriString(value)
                            .build()
                            ?.start(from) ?: throw Error()
                }
                text = key
            }, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        }

        return root
    }
}
