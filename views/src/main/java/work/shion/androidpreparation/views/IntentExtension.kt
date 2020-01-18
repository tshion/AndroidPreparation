package work.shion.androidpreparation.views

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
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
fun AppCompatActivity?.openExtraBrowser(uri: Uri) {
    this ?: return
    Intent(Intent.ACTION_VIEW, uri).also { startActivity(it) }
}

/**
 * アプリ外ブラウザの起動
 */
fun Fragment?.openExtraBrowser(uri: Uri) = (this?.activity as? AppCompatActivity)?.openExtraBrowser(uri)
