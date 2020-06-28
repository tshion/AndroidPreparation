package work.shion.androidpreparation.webviewbuilder

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.webview_with_auto_discard.*

/**
 * WebView with lifecycle auto-discard.
 */
open class WebViewWithAutoDiscard : Fragment(R.layout.webview_with_auto_discard) {
    private var isAvailable = false
    var webView: WebView? = null
        get() = if (isAvailable) field else null
        private set


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        webView?.destroy()
        webView = webview_with_auto_discard
        isAvailable = true
    }

    override fun onResume() {
        webView?.onResume()
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
        webView?.onPause()
    }

    override fun onDestroyView() {
        isAvailable = false
        super.onDestroyView()
    }

    override fun onDestroy() {
        webView?.destroy()
        webView = null
        super.onDestroy()
    }
}
