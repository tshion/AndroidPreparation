package work.shion.androidpreparation.debugger.android

import android.os.Handler
import android.os.Looper
import android.webkit.WebView
import work.shion.androidpreparation.debugger.BuildConfig

/**
 * WebView の機能付与
 * [WebView](https://developer.android.com/reference/android/webkit/WebView)
 */
interface IWebViewAttacher {

    /**
     * WebView のデバッグ設定のセットアップ
     *
     * **本番環境では使わないこと**
     * ### 実装例
     * ``` kotlin
     * class DebugApplication : Application(), IWebViewAttacher {
     *     override fun onCreate() {
     *         super.onCreate()
     *         setupWebDebugger()
     *     }
     * }
     * ```
     */
    fun setupWebDebugger(isEnabled: Boolean = BuildConfig.DEBUG) {
        Handler(Looper.getMainLooper())
                .post { WebView.setWebContentsDebuggingEnabled(isEnabled) }
    }
}
