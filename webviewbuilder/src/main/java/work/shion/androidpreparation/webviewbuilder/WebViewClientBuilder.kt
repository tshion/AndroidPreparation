package work.shion.androidpreparation.webviewbuilder

import android.annotation.TargetApi
import android.graphics.Bitmap
import android.net.Uri
import android.net.http.SslError
import android.os.Message
import android.view.KeyEvent
import android.webkit.*
import androidx.annotation.RequiresApi


/**
 * WebViewClient 設定ビルダー
 */
class WebViewClientBuilder {
    private var mDoUpdateVisitedHistory: ((view: WebView?, url: String?, isReload: Boolean) -> Unit)? = null
    private var mOnFormResubmission: ((view: WebView?, dontResend: Message?, resend: Message?) -> Unit)? = null
    private var mOnLoadResource: ((view: WebView?, url: String?) -> Unit)? = null
    private var mOnPageCommitVisible: ((view: WebView?, url: String?) -> Unit)? = null
    private var mOnPageFinished: ((view: WebView?, url: String?) -> Unit)? = null
    private var mOnPageStarted: ((view: WebView?, url: String?, favicon: Bitmap?) -> Unit)? = null
    private var mOnReceivedClientCertRequest: ((view: WebView?, request: ClientCertRequest?) -> Unit)? = null
    private var mOnReceivedError: ((view: WebView?, errorCode: Int, description: String?, failingUrl: String?) -> Unit)? = null
    private var mOnReceivedHttpAuthRequest: ((view: WebView?, handler: HttpAuthHandler?, host: String?, realm: String?) -> Unit)? = null
    private var mOnReceivedHttpError: ((view: WebView?, request: WebResourceRequest?, errorResponse: WebResourceResponse?) -> Unit)? = null
    private var mOnReceivedLoginRequest: ((view: WebView?, realm: String?, account: String?, args: String?) -> Unit)? = null
    private var mOnReceivedSslError: ((view: WebView?, handler: SslErrorHandler?, error: SslError?) -> Unit)? = null
    private var mOnRenderProcessGone: ((view: WebView?, detail: RenderProcessGoneDetail?) -> Boolean)? = null
    private var mOnSafeBrowsingHit: ((view: WebView?, request: WebResourceRequest?, threatType: Int, callback: SafeBrowsingResponse?) -> Unit)? = null
    private var mOnScaleChanged: ((view: WebView?, oldScale: Float, newScale: Float) -> Unit)? = null
    private var mShouldInterceptRequest: ((view: WebView?, request: WebResourceRequest?) -> WebResourceResponse?)? = null
    private var mShouldOverrideKeyEvent: ((view: WebView?, event: KeyEvent?) -> Boolean)? = null
    private var mShouldOverrideUrlLoading: ((view: WebView?, request: WebResourceRequest?) -> Boolean)? = null


    /**
     * WebViewClient の生成
     */
    fun build() = object : WebViewClient() {
        override fun doUpdateVisitedHistory(view: WebView?, url: String?, isReload: Boolean) {
            mDoUpdateVisitedHistory?.invoke(view, url, isReload)
                    ?: super.doUpdateVisitedHistory(view, url, isReload)
        }

        override fun onFormResubmission(view: WebView?, dontResend: Message?, resend: Message?) {
            mOnFormResubmission?.invoke(view, dontResend, resend)
                    ?: super.onFormResubmission(view, dontResend, resend)
        }

        override fun onLoadResource(view: WebView?, url: String?) {
            mOnLoadResource?.invoke(view, url) ?: super.onLoadResource(view, url)
        }

        @TargetApi(23)
        override fun onPageCommitVisible(view: WebView?, url: String?) {
            mOnPageCommitVisible?.invoke(view, url) ?: super.onPageCommitVisible(view, url)
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            mOnPageFinished?.invoke(view, url) ?: super.onPageFinished(view, url)
        }

        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            mOnPageStarted?.invoke(view, url, favicon) ?: super.onPageStarted(view, url, favicon)
        }

        override fun onReceivedClientCertRequest(view: WebView?, request: ClientCertRequest?) {
            mOnReceivedClientCertRequest?.invoke(view, request)
                    ?: super.onReceivedClientCertRequest(view, request)
        }

        override fun onReceivedError(view: WebView?, errorCode: Int, description: String?, failingUrl: String?) {
            mOnReceivedError?.invoke(view, errorCode, description, failingUrl)
                    ?: super.onReceivedError(view, errorCode, description, failingUrl)
        }

        @TargetApi(23)
        override fun onReceivedError(view: WebView?, request: WebResourceRequest?, error: WebResourceError?) {
            mOnReceivedError?.invoke(
                    view,
                    error?.errorCode ?: 0,
                    error?.description?.toString(),
                    request?.url?.toString()
            ) ?: super.onReceivedError(view, request, error)
        }

        override fun onReceivedHttpAuthRequest(view: WebView?, handler: HttpAuthHandler?, host: String?, realm: String?) {
            mOnReceivedHttpAuthRequest?.invoke(view, handler, host, realm)
                    ?: super.onReceivedHttpAuthRequest(view, handler, host, realm)
        }

        @TargetApi(23)
        override fun onReceivedHttpError(view: WebView?, request: WebResourceRequest?, errorResponse: WebResourceResponse?) {
            mOnReceivedHttpError?.invoke(view, request, errorResponse)
                    ?: super.onReceivedHttpError(view, request, errorResponse)
        }

        override fun onReceivedLoginRequest(view: WebView?, realm: String?, account: String?, args: String?) {
            mOnReceivedLoginRequest?.invoke(view, realm, account, args)
                    ?: super.onReceivedLoginRequest(view, realm, account, args)
        }

        override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler?, error: SslError?) {
            mOnReceivedSslError?.invoke(view, handler, error)
                    ?: super.onReceivedSslError(view, handler, error)
        }

        @TargetApi(26)
        override fun onRenderProcessGone(view: WebView?, detail: RenderProcessGoneDetail?) =
                mOnRenderProcessGone?.invoke(view, detail)
                        ?: super.onRenderProcessGone(view, detail)

        @TargetApi(27)
        override fun onSafeBrowsingHit(view: WebView?, request: WebResourceRequest?, threatType: Int, callback: SafeBrowsingResponse?) {
            mOnSafeBrowsingHit?.invoke(view, request, threatType, callback)
                    ?: super.onSafeBrowsingHit(view, request, threatType, callback)
        }

        override fun onScaleChanged(view: WebView?, oldScale: Float, newScale: Float) {
            mOnScaleChanged?.invoke(view, oldScale, newScale)
                    ?: super.onScaleChanged(view, oldScale, newScale)
        }

        override fun shouldInterceptRequest(view: WebView?, request: WebResourceRequest?) =
                mShouldInterceptRequest?.invoke(view, request)
                        ?: super.shouldInterceptRequest(view, request)

        override fun shouldOverrideKeyEvent(view: WebView?, event: KeyEvent?) =
                mShouldOverrideKeyEvent?.invoke(view, event)
                        ?: super.shouldOverrideKeyEvent(view, event)

        override fun shouldOverrideUrlLoading(view: WebView?, url: String?) =
                mShouldOverrideUrlLoading?.invoke(view, newWebResourceRequest(url))
                        ?: super.shouldOverrideUrlLoading(view, url)

        @TargetApi(24)
        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?) =
                mShouldOverrideUrlLoading?.invoke(view, request)
                        ?: super.shouldOverrideUrlLoading(view, request)
    }

    /**
     * @see android.webkit.WebViewClient.doUpdateVisitedHistory
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebViewClient.html#doUpdateVisitedHistory">Android Developers</a>
     */
    fun setDoUpdateVisitedHistory(fx: ((view: WebView?, url: String?, isReload: Boolean) -> Unit)?) = this.apply { mDoUpdateVisitedHistory = fx }

    /**
     * @see android.webkit.WebViewClient.onFormResubmission
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebViewClient.html#onFormResubmission">Android Developers</a>
     */
    fun setOnFormResubmission(fx: ((view: WebView?, dontResend: Message?, resend: Message?) -> Unit)?) = this.apply { mOnFormResubmission = fx }

    /**
     * @see android.webkit.WebViewClient.onLoadResource
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebViewClient.html#onLoadResource">Android Developers</a>
     */
    fun setOnLoadResource(fx: ((view: WebView?, url: String?) -> Unit)?) = this.apply { mOnLoadResource = fx }

    /**
     * @see android.webkit.WebViewClient.onPageCommitVisible
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebViewClient.html#onPageCommitVisible">Android Developers</a>
     */
    @RequiresApi(23)
    fun setOnPageCommitVisible(fx: ((view: WebView?, url: String?) -> Unit)?) = this.apply { mOnPageCommitVisible = fx }

    /**
     * @see android.webkit.WebViewClient.onPageFinished
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebViewClient.html#onPageFinished">Android Developers</a>
     */
    fun setOnPageFinished(fx: ((view: WebView?, url: String?) -> Unit)?) = this.apply { mOnPageFinished = fx }

    /**
     * @see android.webkit.WebViewClient.onPageStarted
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebViewClient.html#onPageStarted">Android Developers</a>
     */
    fun setOnPageStarted(fx: ((view: WebView?, url: String?, favicon: Bitmap?) -> Unit)?) = this.apply { mOnPageStarted = fx }

    /**
     * @see android.webkit.WebViewClient.onReceivedClientCertRequest
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebViewClient.html#onReceivedClientCertRequest">Android Developers</a>
     */
    fun setOnReceivedClientCertRequest(fx: ((view: WebView?, request: ClientCertRequest?) -> Unit)?) = this.apply { mOnReceivedClientCertRequest = fx }

    /**
     * @see android.webkit.WebViewClient.onReceivedError
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebViewClient.html#onReceivedError">Android Developers</a>
     */
    fun setOnReceivedError(fx: ((view: WebView?, errorCode: Int, description: String?, failingUrl: String?) -> Unit)?) = this.apply { mOnReceivedError = fx }

    /**
     * @see android.webkit.WebViewClient.onReceivedHttpAuthRequest
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebViewClient.html#onReceivedHttpAuthRequest">Android Developers</a>
     */
    fun setOnReceivedHttpAuthRequest(fx: ((view: WebView?, handler: HttpAuthHandler?, host: String?, realm: String?) -> Unit)?) = this.apply { mOnReceivedHttpAuthRequest = fx }

    /**
     * @see android.webkit.WebViewClient.onReceivedHttpError
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebViewClient.html#onReceivedHttpError">Android Developers</a>
     */
    @RequiresApi(23)
    fun setOnReceivedHttpError(fx: ((view: WebView?, request: WebResourceRequest?, errorResponse: WebResourceResponse?) -> Unit)?) = this.apply { mOnReceivedHttpError = fx }

    /**
     * @see android.webkit.WebViewClient.onReceivedLoginRequest
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebViewClient.html#onReceivedLoginRequest">Android Developers</a>
     */
    fun setOnReceivedLoginRequest(fx: ((view: WebView?, realm: String?, account: String?, args: String?) -> Unit)?) = this.apply { mOnReceivedLoginRequest = fx }

    /**
     * @see android.webkit.WebViewClient.onReceivedSslError
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebViewClient.html#onReceivedSslError">Android Developers</a>
     */
    fun setOnReceivedSslError(fx: ((view: WebView?, handler: SslErrorHandler?, error: SslError?) -> Unit)?) = this.apply { mOnReceivedSslError = fx }

    /**
     * @see android.webkit.WebViewClient.onRenderProcessGone
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebViewClient.html#onRenderProcessGone">Android Developers</a>
     */
    @RequiresApi(26)
    fun setOnRenderProcessGone(fx: ((view: WebView?, detail: RenderProcessGoneDetail?) -> Boolean)?) = this.apply { mOnRenderProcessGone = fx }

    /**
     * @see android.webkit.WebViewClient.onSafeBrowsingHit
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebViewClient.html#onSafeBrowsingHit">Android Developers</a>
     */
    @RequiresApi(27)
    fun setOnSafeBrowsingHit(fx: ((view: WebView?, request: WebResourceRequest?, threatType: Int, callback: SafeBrowsingResponse?) -> Unit)?) = this.apply { mOnSafeBrowsingHit = fx }

    /**
     * @see android.webkit.WebViewClient.onScaleChanged
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebViewClient.html#onScaleChanged">Android Developers</a>
     */
    fun setOnScaleChanged(fx: ((view: WebView?, oldScale: Float, newScale: Float) -> Unit)?) = this.apply { mOnScaleChanged = fx }

    /**
     * @see android.webkit.WebViewClient.shouldInterceptRequest
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebViewClient.html#shouldInterceptRequest">Android Developers</a>
     */
    fun setShouldInterceptRequest(fx: ((view: WebView?, request: WebResourceRequest?) -> WebResourceResponse?)?) = this.apply { mShouldInterceptRequest = fx }

    /**
     * @see android.webkit.WebViewClient.shouldOverrideKeyEvent
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebViewClient.html#shouldOverrideKeyEvent">Android Developers</a>
     */
    fun setShouldOverrideKeyEvent(fx: ((view: WebView?, event: KeyEvent?) -> Boolean)?) = this.apply { mShouldOverrideKeyEvent = fx }

    /**
     * @see android.webkit.WebViewClient.shouldOverrideUrlLoading
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebViewClient.html#shouldOverrideUrlLoading">Android Developers</a>
     */
    fun setShouldOverrideUrlLoading(fx: ((view: WebView?, request: WebResourceRequest?) -> Boolean)?) = this.apply { mShouldOverrideUrlLoading = fx }


    /**
     * WebResourceRequest の生成
     */
    private fun newWebResourceRequest(url: String?) = object : WebResourceRequest {
        override fun getMethod() = ""
        override fun getRequestHeaders() = mutableMapOf<String, String>()
        override fun getUrl() = if (URLUtil.isValidUrl(url)) Uri.parse(url) else Uri.Builder().build()
        override fun hasGesture() = false
        override fun isForMainFrame() = false
        override fun isRedirect() = false
    }
}
