package work.shion.androidpreparation.intentbuilder

import android.content.Intent
import android.net.Uri
import android.webkit.URLUtil

/**
 * 連絡先を表示する設定ビルダー
 *
 * ### 実装例
 * ``` kotlin
 * ShowContactIntentBuilder().apply {
 *     trySetUri(uriText)
 * }.build()?.launch(activity!!)
 * ```
 *
 * ### 参考文献
 * [一般的なインテント | Android デベロッパー](https://developer.android.com/guide/components/intents-common?hl=ja#ViewContact)
 */
class ShowContactIntentBuilder : IntentBuilder<ConsumerIntent>() {

    private var uri: Uri? = null


    fun trySetUri(uri: String): Boolean {
        val isValid = URLUtil.isContentUrl(uri)
        if (isValid) this.uri = Uri.parse(uri)
        return isValid
    }


    /**
     * 与えられた設定からIntent を生成する
     */
    override fun build(): ConsumerIntent? {
        uri ?: return null
        return ConsumerIntent().apply {
            action = Intent.ACTION_VIEW
            data = uri
        }
    }
}
