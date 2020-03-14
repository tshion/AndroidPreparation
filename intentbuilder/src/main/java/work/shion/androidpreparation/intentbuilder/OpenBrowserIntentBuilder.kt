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
 * OpenBrowserIntentBuilder().apply {
 *     trySetUri("https://mokumokulog.netlify.com/")
 * }.build()?.start(from)
 * ```
 *
 * ### References
 * * [Common Intents | Android Developers](https://developer.android.com/guide/components/intents-common#Browser)
 */
class OpenBrowserIntentBuilder : IntentBuilder<ConsumerIntent>() {

    @Deprecated("In development")
    var mimeType: String? = null
        private set

    var uri: Uri? = null
        private set


    @Deprecated("In development")
    fun clearType() {
        mimeType = null
    }

    @Deprecated("In development")
    fun setTextHtml() {
        mimeType = "text/html"
    }

    @Deprecated("In development")
    fun setTextPlain() {
        mimeType = "text/plain"
    }

    @Deprecated("In development")
    fun setXHtml() {
        mimeType = "application/xhtml+xml"
    }

    @Deprecated("In development")
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
