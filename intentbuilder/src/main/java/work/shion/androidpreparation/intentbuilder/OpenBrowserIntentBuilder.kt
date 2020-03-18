package work.shion.androidpreparation.intentbuilder

import android.content.Intent
import android.net.Uri
import android.webkit.URLUtil
import work.shion.androidpreparation.intentbuilder.basis.ConsumerIntent
import work.shion.androidpreparation.intentbuilder.basis.IntentBuilder

/**
 * To open a web page
 *
 * ### Example1
 * ``` kotlin
 * OpenBrowserIntentBuilder().apply {
 *     uriString = "https://mokumokulog.netlify.com/"
 * }.build()?.start(from)
 * ```
 *
 * ### Example2
 * ``` kotlin
 * OpenBrowserIntentBuilder()
 *     .uriString("https://mokumokulog.netlify.com/")
 *     .build()
 *     ?.start(from)
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

    var uriString: String? = null
        set(value) {
            if (URLUtil.isNetworkUrl(value ?: "https://a")) {
                uri = value?.let { Uri.parse(it) }
                field = value
            }
        }


    @Deprecated("In development")
    fun clearType() = apply { mimeType = null }

    @Deprecated("In development")
    fun setTextHtml() = apply { mimeType = "text/html" }

    @Deprecated("In development")
    fun setTextPlain() = apply { mimeType = "text/plain" }

    @Deprecated("In development")
    fun setXHtml() = apply { mimeType = "application/xhtml+xml" }

    @Deprecated("In development")
    fun setXHtmlMobile() = apply { mimeType = "application/vnd.wap.xhtml+xml" }

    @Deprecated("Duplicate implementation")
    fun trySetUri(uri: String): Boolean {
        val isValid = URLUtil.isNetworkUrl(uri)
        if (isValid) this.uri = Uri.parse(uri)
        return isValid
    }

    fun uriString(input: String?) = apply { uriString = input }


    /**
     * Generate an intent by builder's settings.
     */
    override fun build() = uri?.let {
        ConsumerIntent().apply {
            action = Intent.ACTION_VIEW
            data = uri
            mimeType?.also { type = it }
        }
    }
}
