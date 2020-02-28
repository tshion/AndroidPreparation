package work.shion.androidpreparation.intentbuilder

import android.content.Intent
import android.net.Uri
import android.webkit.URLUtil
import work.shion.androidpreparation.intentbuilder.basis.ConsumerIntent
import work.shion.androidpreparation.intentbuilder.basis.IntentBuilder

/**
 * To open a web page
 *
 * ### Example
 * ``` kotlin
 * BrowserIntentBuilder().apply {
 *     trySetUri("https://mokumokulog.netlify.com/")
 * }.build()?.start(from)
 * ```
 *
 * ### References
 * * [Common Intents | Android Developers](https://developer.android.com/guide/components/intents-common#Browser)
 */
class BrowserIntentBuilder : IntentBuilder<ConsumerIntent>() {

    var mimeType: String? = null
        private set

    var uri: Uri? = null
        private set


    fun clearType() {
        mimeType = null
    }

    fun setTextHtml() {
        mimeType = "text/html"
    }

    fun setTextPlain() {
        mimeType = "text/plain"
    }

    fun setXHtml() {
        mimeType = "application/xhtml+xml"
    }

    fun setXHtmlMobile() {
        mimeType = "application/vnd.wap.xhtml+xml"
    }

    fun trySetUri(uri: String): Boolean {
        val isValid = URLUtil.isNetworkUrl(uri)
        if (isValid) this.uri = Uri.parse(uri)
        return isValid
    }


    /**
     * Generate an intent by builder's settings.
     */
    override fun build() = uri?.let {
        ConsumerIntent().apply {
            action = Intent.ACTION_VIEW
            data = uri
            if (mimeType != null) type = mimeType
        }
    }
}
