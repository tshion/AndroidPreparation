package work.shion.androidpreparation.debugger.android

import android.os.Handler
import android.os.Looper
import android.webkit.WebView
import work.shion.androidpreparation.debugger.BuildConfig

interface IWebViewAttacher {

    /**
     * Setup debugging settings for WebView
     *
     * **Don't use in production.**
     *
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
