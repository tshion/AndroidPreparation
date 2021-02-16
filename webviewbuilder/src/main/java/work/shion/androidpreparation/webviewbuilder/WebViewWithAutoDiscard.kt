package work.shion.androidpreparation.webviewbuilder

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.fragment.app.Fragment

/**
 * WebView with lifecycle auto-discard.
 */
@Deprecated("In development")
open class WebViewWithAutoDiscard : Fragment() {

    private var isAvailable = false
    var webView: WebView? = null
        get() = if (isAvailable) field else null
        private set


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        webView?.destroy()
        webView = newWebView()
        isAvailable = true
        return webView
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


    protected fun newWebView() = WebView(requireContext())
}
