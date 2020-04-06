package work.shion.androidpreparation.webviewbuilder.basis

import android.graphics.Bitmap
import android.net.http.SslError
import android.os.Message
import android.view.KeyEvent
import android.webkit.*
import androidx.webkit.SafeBrowsingResponseCompat
import androidx.webkit.WebResourceErrorCompat
import androidx.webkit.WebViewClientCompat

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
    fun doUpdateVisitedHistory(callback: ((view: WebView?, url: String?, isReload: Boolean) -> Unit)?): WebViewClientContract

    /** @see WebViewClient.onFormResubmission */
    fun onFormResubmission(callback: ((view: WebView?, dontResend: Message?, resend: Message?) -> Unit)?): WebViewClientContract

    /** @see WebViewClient.onLoadResource */
    fun onLoadResource(callback: ((view: WebView?, url: String?) -> Unit)?): WebViewClientContract

    /** @see WebViewClient.onPageCommitVisible */
    fun onPageCommitVisible(callback: ((view: WebView?, url: String?) -> Unit)?): WebViewClientContract

    /** @see WebViewClient.onPageFinished */
    fun onPageFinished(callback: ((view: WebView?, url: String?) -> Unit)?): WebViewClientContract

    /** @see WebViewClient.onPageStarted */
    fun onPageStarted(callback: ((view: WebView?, url: String?, favicon: Bitmap?) -> Unit)?): WebViewClientContract

    /** @see WebViewClient.onReceivedClientCertRequest */
    fun onReceivedClientCertRequest(callback: ((view: WebView?, request: ClientCertRequest?) -> Unit)?): WebViewClientContract

    /** @see WebViewClient.onReceivedError */
    fun onReceivedError(callback: ((view: WebView, request: WebResourceRequest, error: WebResourceErrorCompat) -> Unit)?): WebViewClientContract

    /** @see WebViewClient.onReceivedHttpAuthRequest */
    fun onReceivedHttpAuthRequest(callback: ((view: WebView?, handler: HttpAuthHandler?, host: String?, realm: String?) -> Unit)?): WebViewClientContract

    /** @see WebViewClient.onReceivedHttpError */
    fun onReceivedHttpError(callback: ((view: WebView?, request: WebResourceRequest?, errorResponse: WebResourceResponse?) -> Unit)?): WebViewClientContract

    /** @see WebViewClient.onReceivedLoginRequest */
    fun onReceivedLoginRequest(callback: ((view: WebView?, realm: String?, account: String?, args: String?) -> Unit)?): WebViewClientContract

    /** @see WebViewClient.onReceivedSslError */
    fun onReceivedSslError(callback: ((view: WebView?, handler: SslErrorHandler?, error: SslError?) -> Unit)?): WebViewClientContract

    /** @see WebViewClient.onRenderProcessGone */
    fun onRenderProcessGone(callback: ((view: WebView?, detail: RenderProcessGoneDetail?) -> Boolean)?): WebViewClientContract

    /** @see WebViewClient.onSafeBrowsingHit */
    fun onSafeBrowsingHit(callback: ((view: WebView?, request: WebResourceRequest?, threatType: Int, callback: SafeBrowsingResponseCompat) -> Unit)?): WebViewClientContract

    /** @see WebViewClient.onScaleChanged */
    fun onScaleChanged(callback: ((view: WebView?, oldScale: Float, newScale: Float) -> Unit)?): WebViewClientContract

    /** @see WebViewClient.shouldInterceptRequest */
    fun shouldInterceptRequest(callback: ((view: WebView?, request: WebResourceRequest?) -> WebResourceResponse?)?): WebViewClientContract

    /** @see WebViewClient.shouldOverrideKeyEvent */
    fun shouldOverrideKeyEvent(callback: ((view: WebView?, event: KeyEvent?) -> Boolean)?): WebViewClientContract

    /** @see WebViewClient.shouldOverrideUrlLoading */
    fun shouldOverrideUrlLoading(callback: ((view: WebView?, request: WebResourceRequest?) -> Boolean)?): WebViewClientContract


    /**
     * Generate by builder's settings.
     */
    fun buildViewClient() = object : WebViewClientCompat() {
        override fun doUpdateVisitedHistory(view: WebView?, url: String?, isReload: Boolean) = doUpdateVisitedHistory?.invoke(view, url, isReload)
                ?: super.doUpdateVisitedHistory(view, url, isReload)

        override fun onFormResubmission(view: WebView?, dontResend: Message?, resend: Message?) = onFormResubmission?.invoke(view, dontResend, resend)
                ?: super.onFormResubmission(view, dontResend, resend)

        override fun onLoadResource(view: WebView?, url: String?) = onLoadResource?.invoke(view, url)
                ?: super.onLoadResource(view, url)

        override fun onPageCommitVisible(view: WebView, url: String) = onPageCommitVisible?.invoke(view, url)
                ?: super.onPageCommitVisible(view, url)

        override fun onPageFinished(view: WebView?, url: String?) = onPageFinished?.invoke(view, url)
                ?: super.onPageFinished(view, url)

        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) = onPageStarted?.invoke(view, url, favicon)
                ?: super.onPageStarted(view, url, favicon)

        override fun onReceivedClientCertRequest(view: WebView?, request: ClientCertRequest?) = onReceivedClientCertRequest?.invoke(view, request)
                ?: super.onReceivedClientCertRequest(view, request)

        override fun onReceivedError(view: WebView, request: WebResourceRequest, error: WebResourceErrorCompat) = onReceivedError?.invoke(view, request, error)
                ?: super.onReceivedError(view, request, error)

        override fun onReceivedHttpAuthRequest(view: WebView?, handler: HttpAuthHandler?, host: String?, realm: String?) = onReceivedHttpAuthRequest?.invoke(view, handler, host, realm)
                ?: super.onReceivedHttpAuthRequest(view, handler, host, realm)

        override fun onReceivedHttpError(view: WebView, request: WebResourceRequest, errorResponse: WebResourceResponse) = onReceivedHttpError?.invoke(view, request, errorResponse)
                ?: super.onReceivedHttpError(view, request, errorResponse)

        override fun onReceivedLoginRequest(view: WebView?, realm: String?, account: String?, args: String?) = onReceivedLoginRequest?.invoke(view, realm, account, args)
                ?: super.onReceivedLoginRequest(view, realm, account, args)

        override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler?, error: SslError?) = onReceivedSslError?.invoke(view, handler, error)
                ?: super.onReceivedSslError(view, handler, error)

        override fun onRenderProcessGone(view: WebView?, detail: RenderProcessGoneDetail?) = onRenderProcessGone?.invoke(view, detail)
                ?: super.onRenderProcessGone(view, detail)

        override fun onSafeBrowsingHit(view: WebView, request: WebResourceRequest, threatType: Int, callback: SafeBrowsingResponseCompat) = onSafeBrowsingHit?.invoke(view, request, threatType, callback)
                ?: super.onSafeBrowsingHit(view, request, threatType, callback)

        override fun onScaleChanged(view: WebView?, oldScale: Float, newScale: Float) = onScaleChanged?.invoke(view, oldScale, newScale)
                ?: super.onScaleChanged(view, oldScale, newScale)

        override fun shouldInterceptRequest(view: WebView?, request: WebResourceRequest?) = shouldInterceptRequest?.invoke(view, request)
                ?: super.shouldInterceptRequest(view, request)

        override fun shouldOverrideKeyEvent(view: WebView?, event: KeyEvent?) = shouldOverrideKeyEvent?.invoke(view, event)
                ?: super.shouldOverrideKeyEvent(view, event)

        override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest) = shouldOverrideUrlLoading?.invoke(view, request)
                ?: super.shouldOverrideUrlLoading(view, request)
    }
}
