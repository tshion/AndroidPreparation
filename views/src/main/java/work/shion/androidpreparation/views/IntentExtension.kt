package work.shion.androidpreparation.views

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.fragment.app.Fragment

/**
 * アプリ外ブラウザの起動
 *
 * ### 実装例
 * ``` kotlin
 * runCatching {
 *     openExtraBrowser(Uri.parse("https://mokumokulog.netlify.com/"))
 * }
 * ```
 */
fun Activity?.launchBrowser(uri: Uri) {
    this ?: return
    Intent(Intent.ACTION_VIEW, uri).also { startActivity(it) }
}

/**
 * アプリ外ブラウザの起動
 */
fun Fragment?.launchBrowser(uri: Uri) = (this?.activity as? Activity)?.launchBrowser(uri)
