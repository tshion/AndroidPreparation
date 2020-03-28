package work.shion.androidpreparation.webviewbuilder.basis

import android.webkit.WebChromeClient
import  android.webkit.WebView
import android.webkit.WebViewClient

interface WebViewContract {

    /** @see WebView.setWebChromeClient */
    val webChromeClient: WebChromeClient?

    /** * @see WebView.setWebViewClient */
    val webViewClient: WebViewClient?


    /** @see WebView.setWebChromeClient */
    fun webChromeClient(input: WebChromeClient?): WebViewContract

    /** * @see WebView.setWebViewClient */
    fun webViewClient(input: WebViewClient?): WebViewContract
}
