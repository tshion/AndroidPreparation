package work.shion.androidpreparation.intentbuilder

import android.app.Activity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams
import android.widget.Button
import android.widget.LinearLayout

class BrowserSample : Activity() {

    companion object {
        val test = Pair("", "https://mokumokulog.netlify.com/")
        val testFailure = Pair("", "hoge://mokumokulog.netlify.com/")
        val testHTML = Pair("text/html", "https://mokumokulog.netlify.com/")
        val testPlain = Pair("text/plain", "https://mokumokulog.netlify.com/")
        val testXHtml = Pair("application/xhtml+xml", "https://mokumokulog.netlify.com/")
        val testXHtmlMobile = Pair("application/vnd.wap.xhtml+xml", "https://mokumokulog.netlify.com/")


        fun decorateText(pair: Pair<String, String>) = "MIME: ${pair.first}\nURL: ${pair.second}"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
        }

        root.addView(Button(this).apply {
            setOnClickListener {
                BrowserIntentBuilder().apply {
                    trySetUri(test.second)
                }.build()?.launch(this@BrowserSample)
            }
            text = decorateText(test)
        }, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)

        root.addView(Button(this).apply {
            setOnClickListener {
                BrowserIntentBuilder().apply {
                    trySetUri(testFailure.second)
                }.build() ?: throw Error()
            }
            text = decorateText(testFailure)
        }, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)

        root.addView(Button(this).apply {
            setOnClickListener {
                BrowserIntentBuilder().apply {
                    setTextHtml()
                    trySetUri(testHTML.second)
                }.build()?.launch(this@BrowserSample) {
                    throw NotImplementedError()
                }
            }
            text = decorateText(testHTML)
        }, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)

        root.addView(Button(this).apply {
            setOnClickListener {
                BrowserIntentBuilder().apply {
                    setTextPlain()
                    trySetUri(testPlain.second)
                }.build()?.launch(this@BrowserSample) {
                    throw NotImplementedError()
                }
            }
            text = decorateText(testPlain)
        }, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)

        root.addView(Button(this).apply {
            setOnClickListener {
                BrowserIntentBuilder().apply {
                    setXHtml()
                    trySetUri(testXHtml.second)
                }.build()?.launch(this@BrowserSample) {
                    throw NotImplementedError()
                }
            }
            text = decorateText(testXHtml)
        }, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)

        root.addView(Button(this).apply {
            setOnClickListener {
                BrowserIntentBuilder().apply {
                    setXHtmlMobile()
                    trySetUri(testXHtmlMobile.second)
                }.build()?.launch(this@BrowserSample) {
                    throw NotImplementedError()
                }
            }
            text = decorateText(testXHtmlMobile)
        }, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)

        setContentView(root)
    }
}
