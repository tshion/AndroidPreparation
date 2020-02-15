package work.shion.androidpreparation.webviewbuilder

import android.graphics.Bitmap
import android.net.Uri
import android.os.Message
import android.view.View
import android.webkit.*


/**
 * WebChromeClient 設定ビルダー
 */
class WebChromeClientBuilder {
    private var mGetDefaultVideoPoster: (() -> Bitmap?)? = null
    private var mGetVideoLoadingProgressView: (() -> View?)? = null
    private var mGetVisitedHistory: ((callback: ValueCallback<Array<String>>?) -> Unit)? = null
    private var mOnCloseWindow: ((window: WebView?) -> Unit)? = null
    private var mOnConsoleMessage: ((consoleMessage: ConsoleMessage?) -> Boolean)? = null
    private var mOnCreateWindow: ((view: WebView?, isDialog: Boolean, isUserGesture: Boolean, resultMsg: Message?) -> Boolean)? = null
    private var mOnGeolocationPermissionsHidePrompt: (() -> Unit)? = null
    private var mOnGeolocationPermissionsShowPrompt: ((origin: String?, callback: GeolocationPermissions.Callback?) -> Unit)? = null
    private var mOnHideCustomView: (() -> Unit)? = null
    private var mOnJsAlert: ((view: WebView?, url: String?, message: String?, result: JsResult?) -> Boolean)? = null
    private var mOnJsBeforeUnload: ((view: WebView?, url: String?, message: String?, result: JsResult?) -> Boolean)? = null
    private var mOnJsConfirm: ((view: WebView?, url: String?, message: String?, result: JsResult?) -> Boolean)? = null
    private var mOnJsPrompt: ((view: WebView?, url: String?, message: String?, defaultValue: String?, result: JsPromptResult?) -> Boolean)? = null
    private var mOnPermissionRequest: ((request: PermissionRequest?) -> Unit)? = null
    private var mOnPermissionRequestCanceled: ((request: PermissionRequest?) -> Unit)? = null
    private var mOnProgressChanged: ((view: WebView?, newProgress: Int) -> Unit)? = null
    private var mOnReceivedIcon: ((view: WebView?, icon: Bitmap?) -> Unit)? = null
    private var mOnReceivedTitle: ((view: WebView?, title: String?) -> Unit)? = null
    private var mOnReceivedTouchIconUrl: ((view: WebView?, url: String?, precomposed: Boolean) -> Unit)? = null
    private var mOnRequestFocus: ((view: WebView?) -> Unit)? = null
    private var mOnShowCustomView: ((view: View?, callback: WebChromeClient.CustomViewCallback?) -> Unit)? = null
    private var mOnShowFileChooser: ((webView: WebView?, filePathCallback: ValueCallback<Array<Uri>>?, fileChooserParams: WebChromeClient.FileChooserParams?) -> Boolean)? = null


    /**
     * WebChromeClient の生成
     */
    fun build(): WebChromeClient = object : WebChromeClient() {
        override fun getDefaultVideoPoster() = if (mGetDefaultVideoPoster != null) {
            mGetDefaultVideoPoster?.invoke()
        } else {
            super.getDefaultVideoPoster()
        }

        override fun getVideoLoadingProgressView() = if (mGetVideoLoadingProgressView != null) {
            mGetVideoLoadingProgressView?.invoke()
        } else {
            super.getVideoLoadingProgressView()
        }

        override fun getVisitedHistory(callback: ValueCallback<Array<String>>?) {
            mGetVisitedHistory?.invoke(callback) ?: super.getVisitedHistory(callback)
        }

        override fun onCloseWindow(window: WebView?) {
            mOnCloseWindow?.invoke(window) ?: super.onCloseWindow(window)
        }

        override fun onConsoleMessage(consoleMessage: ConsoleMessage?) =
                mOnConsoleMessage?.invoke(consoleMessage) ?: super.onConsoleMessage(consoleMessage)

        override fun onCreateWindow(view: WebView?, isDialog: Boolean, isUserGesture: Boolean, resultMsg: Message?) =
                mOnCreateWindow?.invoke(view, isDialog, isUserGesture, resultMsg)
                        ?: super.onCreateWindow(view, isDialog, isUserGesture, resultMsg)

        override fun onGeolocationPermissionsHidePrompt() {
            mOnGeolocationPermissionsHidePrompt?.invoke()
                    ?: super.onGeolocationPermissionsHidePrompt()
        }

        override fun onGeolocationPermissionsShowPrompt(origin: String?, callback: GeolocationPermissions.Callback?) {
            mOnGeolocationPermissionsShowPrompt?.invoke(origin, callback)
                    ?: super.onGeolocationPermissionsShowPrompt(origin, callback)
        }

        override fun onHideCustomView() {
            mOnHideCustomView?.invoke() ?: super.onHideCustomView()
        }

        override fun onJsAlert(view: WebView?, url: String?, message: String?, result: JsResult?) =
                mOnJsAlert?.invoke(view, url, message, result)
                        ?: super.onJsAlert(view, url, message, result)

        override fun onJsBeforeUnload(view: WebView?, url: String?, message: String?, result: JsResult?) =
                mOnJsBeforeUnload?.invoke(view, url, message, result)
                        ?: super.onJsBeforeUnload(view, url, message, result)

        override fun onJsConfirm(view: WebView?, url: String?, message: String?, result: JsResult?) =
                mOnJsConfirm?.invoke(view, url, message, result)
                        ?: super.onJsConfirm(view, url, message, result)

        override fun onJsPrompt(view: WebView?, url: String?, message: String?, defaultValue: String?, result: JsPromptResult?) =
                mOnJsPrompt?.invoke(view, url, message, defaultValue, result)
                        ?: super.onJsPrompt(view, url, message, defaultValue, result)

        override fun onPermissionRequest(request: PermissionRequest?) {
            mOnPermissionRequest?.invoke(request) ?: super.onPermissionRequest(request)
        }

        override fun onPermissionRequestCanceled(request: PermissionRequest?) {
            mOnPermissionRequestCanceled ?: super.onPermissionRequestCanceled(request)
        }

        override fun onProgressChanged(view: WebView?, newProgress: Int) {
            mOnProgressChanged?.invoke(view, newProgress)
                    ?: super.onProgressChanged(view, newProgress)
        }

        override fun onReceivedIcon(view: WebView?, icon: Bitmap?) {
            mOnReceivedIcon?.invoke(view, icon) ?: super.onReceivedIcon(view, icon)
        }

        override fun onReceivedTitle(view: WebView?, title: String?) {
            mOnReceivedTitle?.invoke(view, title) ?: super.onReceivedTitle(view, title)
        }

        override fun onReceivedTouchIconUrl(view: WebView?, url: String?, precomposed: Boolean) {
            mOnReceivedTouchIconUrl?.invoke(view, url, precomposed)
                    ?: super.onReceivedTouchIconUrl(view, url, precomposed)
        }

        override fun onRequestFocus(view: WebView?) {
            mOnRequestFocus?.invoke(view) ?: super.onRequestFocus(view)
        }

        override fun onShowCustomView(view: View?, callback: CustomViewCallback?) {
            mOnShowCustomView?.invoke(view, callback) ?: super.onShowCustomView(view, callback)
        }

        override fun onShowFileChooser(webView: WebView?, filePathCallback: ValueCallback<Array<Uri>>?, fileChooserParams: FileChooserParams?) =
                mOnShowFileChooser?.invoke(webView, filePathCallback, fileChooserParams)
                        ?: super.onShowFileChooser(webView, filePathCallback, fileChooserParams)
    }

    /**
     * @see android.webkit.WebChromeClient.getDefaultVideoPoster
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebChromeClient.html#getDefaultVideoPoster">Android Developers</a>
     */
    fun setGetDefaultVideoPoster(fx: (() -> Bitmap?)?) = this.apply { mGetDefaultVideoPoster = fx }

    /**
     * @see android.webkit.WebChromeClient.getVideoLoadingProgressView
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebChromeClient.html#getVideoLoadingProgressView">Android Developers</a>
     */
    fun setGetVideoLoadingProgressView(fx: (() -> View?)?) = this.apply { mGetVideoLoadingProgressView = fx }

    /**
     * @see android.webkit.WebChromeClient.getVisitedHistory
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebChromeClient.html#getVisitedHistory">Android Developers</a>
     */
    fun setGetVisitedHistory(fx: ((callback: ValueCallback<Array<String>>?) -> Unit)?) = this.apply { mGetVisitedHistory = fx }

    /**
     * @see android.webkit.WebChromeClient.onCloseWindow
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebChromeClient.html#onCloseWindow">Android Developers</a>
     */
    fun setOnCloseWindow(fx: ((window: WebView?) -> Unit)?) = this.apply { mOnCloseWindow = fx }

    /**
     * @see android.webkit.WebChromeClient.onConsoleMessage
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebChromeClient.html#onConsoleMessage">Android Developers</a>
     */
    fun setOnConsoleMessage(fx: ((consoleMessage: ConsoleMessage?) -> Boolean)?) = this.apply { mOnConsoleMessage = fx }

    /**
     * @see android.webkit.WebChromeClient.onCreateWindow
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebChromeClient.html#onCreateWindow">Android Developers</a>
     */
    fun setOnCreateWindow(fx: ((view: WebView?, isDialog: Boolean, isUserGesture: Boolean, resultMsg: Message?) -> Boolean)?) = this.apply { mOnCreateWindow = fx }

    /**
     * @see android.webkit.WebChromeClient.onGeolocationPermissionsHidePrompt
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebChromeClient.html#onGeolocationPermissionsHidePrompt">Android Developers</a>
     */
    fun setOnGeolocationPermissionsHidePrompt(fx: (() -> Unit)?) = this.apply { mOnGeolocationPermissionsHidePrompt = fx }

    /**
     * @see android.webkit.WebChromeClient.onGeolocationPermissionsShowPrompt
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebChromeClient.html#onGeolocationPermissionsShowPrompt">Android Developers</a>
     */
    fun setOnGeolocationPermissionsShowPrompt(fx: ((origin: String?, callback: GeolocationPermissions.Callback?) -> Unit)?) = this.apply { mOnGeolocationPermissionsShowPrompt = fx }

    /**
     * @see android.webkit.WebChromeClient.onHideCustomView
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebChromeClient.html#onHideCustomView">Android Developers</a>
     */
    fun setOnHideCustomView(fx: (() -> Unit)?) = this.apply { mOnHideCustomView = fx }

    /**
     * @see android.webkit.WebChromeClient.onJsAlert
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebChromeClient.html#onJsAlert">Android Developers</a>
     */
    fun setOnJsAlert(fx: ((view: WebView?, url: String?, message: String?, result: JsResult?) -> Boolean)?) = this.apply { mOnJsAlert = fx }

    /**
     * @see android.webkit.WebChromeClient.onJsBeforeUnload
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebChromeClient.html#onJsBeforeUnload">Android Developers</a>
     */
    fun setOnJsBeforeUnload(fx: ((view: WebView?, url: String?, message: String?, result: JsResult?) -> Boolean)?) = this.apply { mOnJsBeforeUnload = fx }

    /**
     * @see android.webkit.WebChromeClient.onJsConfirm
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebChromeClient.html#onJsConfirm">Android Developers</a>
     */
    fun setOnJsConfirm(fx: ((view: WebView?, url: String?, message: String?, result: JsResult?) -> Boolean)?) = this.apply { mOnJsConfirm = fx }

    /**
     * @see android.webkit.WebChromeClient.onJsPrompt
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebChromeClient.html#onJsPrompt">Android Developers</a>
     */
    fun setOnJsPrompt(fx: ((view: WebView?, url: String?, message: String?, defaultValue: String?, result: JsPromptResult?) -> Boolean)?) = this.apply { mOnJsPrompt = fx }

    /**
     * @see android.webkit.WebChromeClient.onPermissionRequest
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebChromeClient.html#onPermissionRequest">Android Developers</a>
     */
    fun setOnPermissionRequest(fx: ((request: PermissionRequest?) -> Unit)?) = this.apply { mOnPermissionRequest = fx }

    /**
     * @see android.webkit.WebChromeClient.onPermissionRequestCanceled
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebChromeClient.html#onPermissionRequestCanceled">Android Developers</a>
     */
    fun setOnPermissionRequestCanceled(fx: ((request: PermissionRequest?) -> Unit)?) = this.apply { mOnPermissionRequestCanceled = fx }

    /**
     * @see android.webkit.WebChromeClient.onProgressChanged
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebChromeClient.html#onProgressChanged">Android Developers</a>
     */
    fun setOnProgressChanged(fx: ((view: WebView?, newProgress: Int) -> Unit)?) = this.apply { mOnProgressChanged = fx }

    /**
     * @see android.webkit.WebChromeClient.onReceivedIcon
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebChromeClient.html#onReceivedIcon">Android Developers</a>
     */
    fun setOnReceivedIcon(fx: ((view: WebView?, icon: Bitmap?) -> Unit)?) = this.apply { mOnReceivedIcon = fx }

    /**
     * @see android.webkit.WebChromeClient.onReceivedTitle
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebChromeClient.html#onReceivedTitle">Android Developers</a>
     */
    fun setOnReceivedTitle(fx: ((view: WebView?, title: String?) -> Unit)?) = this.apply { mOnReceivedTitle = fx }

    /**
     * @see android.webkit.WebChromeClient.onReceivedTouchIconUrl
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebChromeClient.html#onReceivedTouchIconUrl">Android Developers</a>
     */
    fun setOnReceivedTouchIconUrl(fx: ((view: WebView?, url: String?, precomposed: Boolean) -> Unit)?) = this.apply { mOnReceivedTouchIconUrl = fx }

    /**
     * @see android.webkit.WebChromeClient.onRequestFocus
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebChromeClient.html#onRequestFocus">Android Developers</a>
     */
    fun setOnRequestFocus(fx: ((view: WebView?) -> Unit)?) = this.apply { mOnRequestFocus = fx }

    /**
     * @see android.webkit.WebChromeClient.onShowCustomView
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebChromeClient.html#onShowCustomView">Android Developers</a>
     */
    fun setOnShowCustomView(fx: ((view: View?, callback: WebChromeClient.CustomViewCallback?) -> Unit)?) = this.apply { mOnShowCustomView = fx }

    /**
     * @see android.webkit.WebChromeClient.onShowFileChooser
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebChromeClient.html#onShowFileChooser">Android Developers</a>
     */
    fun setOnShowFileChooser(fx: ((webView: WebView?, filePathCallback: ValueCallback<Array<Uri>>?, fileChooserParams: WebChromeClient.FileChooserParams?) -> Boolean)?) = this.apply { mOnShowFileChooser = fx }
}
