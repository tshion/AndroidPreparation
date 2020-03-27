package work.shion.androidpreparation.webviewbuilder

import android.annotation.TargetApi
import android.graphics.Bitmap
import android.net.http.SslError
import android.os.Message
import android.view.KeyEvent
import android.webkit.*
import androidx.webkit.SafeBrowsingResponseCompat
import androidx.webkit.WebResourceErrorCompat
import androidx.webkit.WebViewClientCompat
import work.shion.androidpreparation.webviewbuilder.basis.WebViewClientContract

/**
 * Builder for WebViewClient
 */
class WebViewClientBuilder : WebViewClientContract {

    /** @see WebViewClient.doUpdateVisitedHistory */
    override var doUpdateVisitedHistory: ((view: WebView?, url: String?, isReload: Boolean) -> Unit)? = null

    /** @see WebViewClient.onFormResubmission */
    override var onFormResubmission: ((view: WebView?, dontResend: Message?, resend: Message?) -> Unit)? = null

    /** @see WebViewClient.onLoadResource */
    override var onLoadResource: ((view: WebView?, url: String?) -> Unit)? = null

    /** @see WebViewClient.onPageCommitVisible */
    @TargetApi(23)
    override var onPageCommitVisible: ((view: WebView?, url: String?) -> Unit)? = null

    /** @see WebViewClient.onPageFinished */
    override var onPageFinished: ((view: WebView?, url: String?) -> Unit)? = null

    /** @see WebViewClient.onPageStarted */
    override var onPageStarted: ((view: WebView?, url: String?, favicon: Bitmap?) -> Unit)? = null

    /** @see WebViewClient.onReceivedClientCertRequest */
    override var onReceivedClientCertRequest: ((view: WebView?, request: ClientCertRequest?) -> Unit)? = null

    /** @see WebViewClient.onReceivedError */
    @TargetApi(23)
    override var onReceivedError: ((view: WebView, request: WebResourceRequest, error: WebResourceErrorCompat) -> Unit)? = null

    /** @see WebViewClient.onReceivedHttpAuthRequest */
    override var onReceivedHttpAuthRequest: ((view: WebView?, handler: HttpAuthHandler?, host: String?, realm: String?) -> Unit)? = null

    /** @see WebViewClient.onReceivedHttpError */
    @TargetApi(23)
    override var onReceivedHttpError: ((view: WebView?, request: WebResourceRequest?, errorResponse: WebResourceResponse?) -> Unit)? = null

    /** @see WebViewClient.onReceivedLoginRequest */
    override var onReceivedLoginRequest: ((view: WebView?, realm: String?, account: String?, args: String?) -> Unit)? = null

    /** @see WebViewClient.onReceivedSslError */
    override var onReceivedSslError: ((view: WebView?, handler: SslErrorHandler?, error: SslError?) -> Unit)? = null

    /** @see WebViewClient.onRenderProcessGone */
    @TargetApi(26)
    override var onRenderProcessGone: ((view: WebView?, detail: RenderProcessGoneDetail?) -> Boolean)? = null

    /** @see WebViewClient.onSafeBrowsingHit */
    @TargetApi(27)
    override var onSafeBrowsingHit: ((view: WebView?, request: WebResourceRequest?, threatType: Int, callback: SafeBrowsingResponseCompat) -> Unit)? = null

    /** @see WebViewClient.onScaleChanged */
    override var onScaleChanged: ((view: WebView?, oldScale: Float, newScale: Float) -> Unit)? = null

    /** @see WebViewClient.shouldInterceptRequest */
    override var shouldInterceptRequest: ((view: WebView?, request: WebResourceRequest?) -> WebResourceResponse?)? = null

    /** @see WebViewClient.shouldOverrideKeyEvent */
    override var shouldOverrideKeyEvent: ((view: WebView?, event: KeyEvent?) -> Boolean)? = null

    /** @see WebViewClient.shouldOverrideUrlLoading */
    override var shouldOverrideUrlLoading: ((view: WebView?, request: WebResourceRequest?) -> Boolean)? = null


    /** @see WebViewClient.doUpdateVisitedHistory */
    override fun doUpdateVisitedHistory(callback: ((view: WebView?, url: String?, isReload: Boolean) -> Unit)?) = apply { doUpdateVisitedHistory = callback }

    /** @see WebViewClient.onFormResubmission */
    override fun onFormResubmission(callback: ((view: WebView?, dontResend: Message?, resend: Message?) -> Unit)?) = apply { onFormResubmission = callback }

    /** @see WebViewClient.onLoadResource */
    override fun onLoadResource(callback: ((view: WebView?, url: String?) -> Unit)?) = apply { onLoadResource = callback }

    /** @see WebViewClient.onPageCommitVisible */
    @TargetApi(23)
    override fun onPageCommitVisible(callback: ((view: WebView?, url: String?) -> Unit)?) = apply { onPageCommitVisible = callback }

    /** @see WebViewClient.onPageFinished */
    override fun onPageFinished(callback: ((view: WebView?, url: String?) -> Unit)?) = apply { onPageFinished = callback }

    /** @see WebViewClient.onPageStarted */
    override fun onPageStarted(callback: ((view: WebView?, url: String?, favicon: Bitmap?) -> Unit)?) = apply { onPageStarted = callback }

    /** @see WebViewClient.onReceivedClientCertRequest */
    override fun onReceivedClientCertRequest(callback: ((view: WebView?, request: ClientCertRequest?) -> Unit)?) = apply { onReceivedClientCertRequest = callback }

    /** @see WebViewClient.onReceivedError */
    @TargetApi(23)
    override fun onReceivedError(callback: ((view: WebView, request: WebResourceRequest, error: WebResourceErrorCompat) -> Unit)?) = apply { onReceivedError = callback }

    /** @see WebViewClient.onReceivedHttpAuthRequest */
    override fun onReceivedHttpAuthRequest(callback: ((view: WebView?, handler: HttpAuthHandler?, host: String?, realm: String?) -> Unit)?) = apply { onReceivedHttpAuthRequest = callback }

    /** @see WebViewClient.onReceivedHttpError */
    @TargetApi(23)
    override fun onReceivedHttpError(callback: ((view: WebView?, request: WebResourceRequest?, errorResponse: WebResourceResponse?) -> Unit)?) = apply { onReceivedHttpError = callback }

    /** @see WebViewClient.onReceivedLoginRequest */
    override fun onReceivedLoginRequest(callback: ((view: WebView?, realm: String?, account: String?, args: String?) -> Unit)?) = apply { onReceivedLoginRequest = callback }

    /** @see WebViewClient.onReceivedSslError */
    override fun onReceivedSslError(callback: ((view: WebView?, handler: SslErrorHandler?, error: SslError?) -> Unit)?) = apply { onReceivedSslError = callback }

    /** @see WebViewClient.onRenderProcessGone */
    @TargetApi(26)
    override fun onRenderProcessGone(callback: ((view: WebView?, detail: RenderProcessGoneDetail?) -> Boolean)?) = apply { onRenderProcessGone = callback }

    /** @see WebViewClient.onSafeBrowsingHit */
    @TargetApi(27)
    override fun onSafeBrowsingHit(callback: ((view: WebView?, request: WebResourceRequest?, threatType: Int, callback: SafeBrowsingResponseCompat) -> Unit)?) = apply { onSafeBrowsingHit = callback }

    /** @see WebViewClient.onScaleChanged */
    override fun onScaleChanged(callback: ((view: WebView?, oldScale: Float, newScale: Float) -> Unit)?) = apply { onScaleChanged = callback }

    /** @see WebViewClient.shouldInterceptRequest */
    override fun shouldInterceptRequest(callback: ((view: WebView?, request: WebResourceRequest?) -> WebResourceResponse?)?) = apply { shouldInterceptRequest = callback }

    /** @see WebViewClient.shouldOverrideKeyEvent */
    override fun shouldOverrideKeyEvent(callback: ((view: WebView?, event: KeyEvent?) -> Boolean)?) = apply { shouldOverrideKeyEvent = callback }

    /** @see WebViewClient.shouldOverrideUrlLoading */
    override fun shouldOverrideUrlLoading(callback: ((view: WebView?, request: WebResourceRequest?) -> Boolean)?) = apply { shouldOverrideUrlLoading = callback }


    /**
     * Generate by builder's settings.
     */
    fun build() = object : WebViewClientCompat() {

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
