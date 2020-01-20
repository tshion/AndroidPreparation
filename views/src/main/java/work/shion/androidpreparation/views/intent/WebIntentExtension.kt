package work.shion.androidpreparation.views.intent

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.webkit.URLUtil


/**
 * アプリ外ブラウザ起動で指定できるMIME タイプ
 */
enum class WebIntentMime(name: String) {
    TEXT_HTML("text/html"),
    TEXT_PLAIN("text/plain"),
    XHTML("application/xhtml+xml"),
    XHTML_MOBILE("application/vnd.wap.xhtml+xml")
}


/**
 * アプリ外ブラウザを起動できるかどうか
 *
 * ### 実装例
 * ``` kotlin
 * val mime = WebIntentMime.TEXT_HTML
 * val url = "https://mokumokulog.netlify.com/"
 * if (canLaunchBrowser(url, mime)) {
 *     launchBrowser(url, mime)
 * }
 * ```
 *
 * ### 参考文献
 * * [一般的なインテント | Android デベロッパー | Android Developers](https://developer.android.com/guide/components/intents-common?hl=ja#Browser)
 */
fun Activity.canLaunchBrowser(url: String, mime: WebIntentMime? = null): Boolean {
    val isMime = mime == null || WebIntentMime.values().contains(mime)
    val isUrl = URLUtil.isNetworkUrl(url)
    return isMime && isUrl && create(url, mime).resolveActivity(packageManager) != null
}

/**
 * アプリ外ブラウザの起動
 *
 * ### 実装例
 * ``` kotlin
 * val mime = WebIntentMime.TEXT_HTML
 * val url = "https://mokumokulog.netlify.com/"
 * if (canLaunchBrowser(url, mime)) {
 *     launchBrowser(url, mime)
 * }
 * ```
 *
 * ### 参考文献
 * * [一般的なインテント | Android デベロッパー | Android Developers](https://developer.android.com/guide/components/intents-common?hl=ja#Browser)
 */
fun Activity.launchBrowser(url: String, mime: WebIntentMime? = null) = startActivity(create(url, mime))


/**
 * インテント生成
 */
private fun create(url: String, mime: WebIntentMime? = null): Intent {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    mime?.also { intent.type = it.name }
    return intent
}
