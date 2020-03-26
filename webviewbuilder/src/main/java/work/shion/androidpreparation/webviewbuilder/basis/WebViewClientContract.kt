package work.shion.androidpreparation.webviewbuilder.basis

import android.graphics.Bitmap
import android.net.http.SslError
import android.os.Message
import android.view.KeyEvent
import android.webkit.*
import androidx.webkit.SafeBrowsingResponseCompat
import androidx.webkit.WebResourceErrorCompat

interface WebViewClientContract {

    /** @see WebViewClient.doUpdateVisitedHistory */
    val doUpdateVisitedHistory: ((view: WebView?, url: String?, isReload: Boolean) -> Unit)?

    /** @see WebViewClient.onFormResubmission */
    val onFormResubmission: ((view: WebView?, dontResend: Message?, resend: Message?) -> Unit)?

    /** @see WebViewClient.onLoadResource */
    val onLoadResource: ((view: WebView?, url: String?) -> Unit)?

    /** @see WebViewClient.onPageCommitVisible */
    val onPageCommitVisible: ((view: WebView?, url: String?) -> Unit)?

    /** @see WebViewClient.onPageFinished */
    val onPageFinished: ((view: WebView?, url: String?) -> Unit)?

    /** @see WebViewClient.onPageStarted */
    val onPageStarted: ((view: WebView?, url: String?, favicon: Bitmap?) -> Unit)?

    /** @see WebViewClient.onReceivedClientCertRequest */
    val onReceivedClientCertRequest: ((view: WebView?, request: ClientCertRequest?) -> Unit)?

    /** @see WebViewClient.onReceivedError */
    val onReceivedError: ((view: WebView, request: WebResourceRequest, error: WebResourceErrorCompat) -> Unit)?

    /** @see WebViewClient.onReceivedHttpAuthRequest */
    val onReceivedHttpAuthRequest: ((view: WebView?, handler: HttpAuthHandler?, host: String?, realm: String?) -> Unit)?

    /** @see WebViewClient.onReceivedHttpError */
    val onReceivedHttpError: ((view: WebView?, request: WebResourceRequest?, errorResponse: WebResourceResponse?) -> Unit)?

    /** @see WebViewClient.onReceivedLoginRequest */
    val onReceivedLoginRequest: ((view: WebView?, realm: String?, account: String?, args: String?) -> Unit)?

    /** @see WebViewClient.onReceivedSslError */
    val onReceivedSslError: ((view: WebView?, handler: SslErrorHandler?, error: SslError?) -> Unit)?

    /** @see WebViewClient.onRenderProcessGone */
    val onRenderProcessGone: ((view: WebView?, detail: RenderProcessGoneDetail?) -> Boolean)?

    /** @see WebViewClient.onSafeBrowsingHit */
    val onSafeBrowsingHit: ((view: WebView?, request: WebResourceRequest?, threatType: Int, callback: SafeBrowsingResponseCompat) -> Unit)?

    /** @see WebViewClient.onScaleChanged */
    val onScaleChanged: ((view: WebView?, oldScale: Float, newScale: Float) -> Unit)?

    /** @see WebViewClient.shouldInterceptRequest */
    val shouldInterceptRequest: ((view: WebView?, request: WebResourceRequest?) -> WebResourceResponse?)?

    /** @see WebViewClient.shouldOverrideKeyEvent */
    val shouldOverrideKeyEvent: ((view: WebView?, event: KeyEvent?) -> Boolean)?

    /** @see WebViewClient.shouldOverrideUrlLoading */
    val shouldOverrideUrlLoading: ((view: WebView?, request: WebResourceRequest?) -> Boolean)?


    /** @see WebViewClient.doUpdateVisitedHistory */
    fun doUpdateVisitedHistory(fx: ((view: WebView?, url: String?, isReload: Boolean) -> Unit)?): WebViewClientContract

    /** @see WebViewClient.onFormResubmission */
    fun onFormResubmission(fx: ((view: WebView?, dontResend: Message?, resend: Message?) -> Unit)?): WebViewClientContract

    /** @see WebViewClient.onLoadResource */
    fun onLoadResource(fx: ((view: WebView?, url: String?) -> Unit)?): WebViewClientContract

    /** @see WebViewClient.onPageCommitVisible */
    fun onPageCommitVisible(fx: ((view: WebView?, url: String?) -> Unit)?): WebViewClientContract

    /** @see WebViewClient.onPageFinished */
    fun onPageFinished(fx: ((view: WebView?, url: String?) -> Unit)?): WebViewClientContract

    /** @see WebViewClient.onPageStarted */
    fun onPageStarted(fx: ((view: WebView?, url: String?, favicon: Bitmap?) -> Unit)?): WebViewClientContract

    /** @see WebViewClient.onReceivedClientCertRequest */
    fun onReceivedClientCertRequest(fx: ((view: WebView?, request: ClientCertRequest?) -> Unit)?): WebViewClientContract

    /** @see WebViewClient.onReceivedError */
    fun onReceivedError(fx: ((view: WebView, request: WebResourceRequest, error: WebResourceErrorCompat) -> Unit)?): WebViewClientContract

    /** @see WebViewClient.onReceivedHttpAuthRequest */
    fun onReceivedHttpAuthRequest(fx: ((view: WebView?, handler: HttpAuthHandler?, host: String?, realm: String?) -> Unit)?): WebViewClientContract

    /** @see WebViewClient.onReceivedHttpError */
    fun onReceivedHttpError(fx: ((view: WebView?, request: WebResourceRequest?, errorResponse: WebResourceResponse?) -> Unit)?): WebViewClientContract

    /** @see WebViewClient.onReceivedLoginRequest */
    fun onReceivedLoginRequest(fx: ((view: WebView?, realm: String?, account: String?, args: String?) -> Unit)?): WebViewClientContract

    /** @see WebViewClient.onReceivedSslError */
    fun onReceivedSslError(fx: ((view: WebView?, handler: SslErrorHandler?, error: SslError?) -> Unit)?): WebViewClientContract

    /** @see WebViewClient.onRenderProcessGone */
    fun onRenderProcessGone(fx: ((view: WebView?, detail: RenderProcessGoneDetail?) -> Boolean)?): WebViewClientContract

    /** @see WebViewClient.onSafeBrowsingHit */
    fun onSafeBrowsingHit(fx: ((view: WebView?, request: WebResourceRequest?, threatType: Int, callback: SafeBrowsingResponseCompat) -> Unit)?): WebViewClientContract

    /** @see WebViewClient.onScaleChanged */
    fun onScaleChanged(fx: ((view: WebView?, oldScale: Float, newScale: Float) -> Unit)?): WebViewClientContract

    /** @see WebViewClient.shouldInterceptRequest */
    fun shouldInterceptRequest(fx: ((view: WebView?, request: WebResourceRequest?) -> WebResourceResponse?)?): WebViewClientContract

    /** @see WebViewClient.shouldOverrideKeyEvent */
    fun shouldOverrideKeyEvent(fx: ((view: WebView?, event: KeyEvent?) -> Boolean)?): WebViewClientContract

    /** @see WebViewClient.shouldOverrideUrlLoading */
    fun shouldOverrideUrlLoading(fx: ((view: WebView?, request: WebResourceRequest?) -> Boolean)?): WebViewClientContract
}
