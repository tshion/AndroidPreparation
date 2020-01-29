package work.shion.androidpreparation.intentbuilder

import android.app.Activity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams
import android.widget.Button
import android.widget.LinearLayout

class BrowserSample : Activity() {

    companion object {
        const val buttonEmpty = "empty"
        const val buttonEmptyUri = "empty uri"
        const val buttonHtml = "text/html"
        const val buttonPlain = "text/plain"
        const val buttonXHtml = "application/xhtml+xml"
        const val buttonXHtmlMobile = "application/vnd.wap.xhtml+xml"
        const val url = "https://mokumokulog.netlify.com/"
        const val uriFailure = "hoge://mokumokulog.netlify.com/"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
        }

        root.addView(Button(this).apply {
            setOnClickListener {
                BrowserIntentBuilder().apply {
                    trySetUri(url)
                }.build()?.launch(this@BrowserSample)
            }
            text = buttonEmpty
        }, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)

        root.addView(Button(this).apply {
            setOnClickListener {
                BrowserIntentBuilder().apply {
                    trySetUri(uriFailure)
                }.build()?.launch(this@BrowserSample)
            }
            text = buttonEmptyUri
        }, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)

//        root.addView(Button(this).apply {
//            setOnClickListener {
//                BrowserIntentBuilder().apply {
//                    setTextHtml()
//                    trySetUri(url)
//                }.build()?.launch(this@BrowserSample)
//            }
//            text = buttonHtml
//        }, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)

//        root.addView(Button(this).apply {
//            setOnClickListener {
//                BrowserIntentBuilder().apply {
//                    setTextPlain()
//                    trySetUri(url)
//                }.build()?.launch(this@BrowserSample)
//            }
//            text = buttonPlain
//        }, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)

//        root.addView(Button(this).apply {
//            setOnClickListener {
//                BrowserIntentBuilder().apply {
//                    setXHtml()
//                    trySetUri(url)
//                }.build()?.launch(this@BrowserSample)
//            }
//            text = buttonXHtml
//        }, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)

//        root.addView(Button(this).apply {
//            setOnClickListener {
//                BrowserIntentBuilder().apply {
//                    setXHtmlMobile()
//                    trySetUri(url)
//                }.build()?.launch(this@BrowserSample)
//            }
//            text = buttonXHtmlMobile
//        }, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)

        setContentView(root)
    }
}
