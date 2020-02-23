package work.shion.androidpreparation.intentbuilder

import android.content.Intent
import android.net.Uri
import android.webkit.URLUtil
import work.shion.androidpreparation.intentbuilder.basis.ConsumerIntent
import work.shion.androidpreparation.intentbuilder.basis.IntentBuilder

/**
 * アプリ外ブラウザ起動用の設定ビルダー
 *
 * ### 実装例
 * ``` kotlin
 * BrowserIntentBuilder().apply {
 *     trySetUri("https://mokumokulog.netlify.com/")
 * }.build()?.launch(activity!!)
 * ```
 *
 * ### 参考文献
 * [一般的なインテント | Android デベロッパー](https://developer.android.com/guide/components/intents-common#Browser)
 */
@Deprecated("In development")
class BrowserIntentBuilder : IntentBuilder<ConsumerIntent>() {

    private var mimeType: String? = null
    private var uri: Uri? = null


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
     * 与えられた設定からIntent を生成する
     */
    override fun build(): ConsumerIntent? {
        uri ?: return null
        val intent = ConsumerIntent().apply {
            action = Intent.ACTION_VIEW
            data = uri
        }
        mimeType?.also { intent.type = it }
        return intent
    }
}
