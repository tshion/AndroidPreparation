package work.shion.androidpreparation.webviewbuilder

import android.graphics.Bitmap
import android.net.Uri
import android.os.Message
import android.view.View
import android.webkit.*
import work.shion.androidpreparation.webviewbuilder.basis.WebChromeClientContract

/**
 * Builder for WebChromeClient
 */
@Deprecated("Duplication")
class WebChromeClientBuilder : WebChromeClientContract {

    /** @see WebChromeClient.getDefaultVideoPoster */
    override var getDefaultVideoPoster: (() -> Bitmap?)? = null

    /** @see WebChromeClient.getVideoLoadingProgressView */
    override var getVideoLoadingProgressView: (() -> View?)? = null

    /** @see WebChromeClient.getVisitedHistory */
    override var getVisitedHistory: ((callback: ValueCallback<Array<String>>?) -> Unit)? = null

    /** @see WebChromeClient.onCloseWindow */
    override var onCloseWindow: ((window: WebView?) -> Unit)? = null

    /** @see WebChromeClient.onConsoleMessage */
    override var onConsoleMessage: ((consoleMessage: ConsoleMessage?) -> Boolean)? = null

    /** @see WebChromeClient.onCreateWindow */
    override var onCreateWindow: ((view: WebView?, isDialog: Boolean, isUserGesture: Boolean, resultMsg: Message?) -> Boolean)? = null

    /** @see WebChromeClient.onGeolocationPermissionsHidePrompt */
    override var onGeolocationPermissionsHidePrompt: (() -> Unit)? = null

    /** @see WebChromeClient.onGeolocationPermissionsShowPrompt */
    override var onGeolocationPermissionsShowPrompt: ((origin: String?, callback: GeolocationPermissions.Callback?) -> Unit)? = null

    /** @see WebChromeClient.onHideCustomView */
    override var onHideCustomView: (() -> Unit)? = null

    /** @see WebChromeClient.onJsAlert */
    override var onJsAlert: ((view: WebView?, url: String?, message: String?, result: JsResult?) -> Boolean)? = null

    /** @see WebChromeClient.onJsBeforeUnload */
    override var onJsBeforeUnload: ((view: WebView?, url: String?, message: String?, result: JsResult?) -> Boolean)? = null

    /** @see WebChromeClient.onJsConfirm */
    override var onJsConfirm: ((view: WebView?, url: String?, message: String?, result: JsResult?) -> Boolean)? = null

    /** @see WebChromeClient.onJsPrompt */
    override var onJsPrompt: ((view: WebView?, url: String?, message: String?, defaultValue: String?, result: JsPromptResult?) -> Boolean)? = null

    /** @see WebChromeClient.onPermissionRequest */
    override var onPermissionRequest: ((request: PermissionRequest?) -> Unit)? = null

    /** @see WebChromeClient.onPermissionRequestCanceled */
    override var onPermissionRequestCanceled: ((request: PermissionRequest?) -> Unit)? = null

    /** @see WebChromeClient.onProgressChanged */
    override var onProgressChanged: ((view: WebView?, newProgress: Int) -> Unit)? = null

    /** @see WebChromeClient.onReceivedIcon */
    override var onReceivedIcon: ((view: WebView?, icon: Bitmap?) -> Unit)? = null

    /** @see WebChromeClient.onReceivedTitle */
    override var onReceivedTitle: ((view: WebView?, title: String?) -> Unit)? = null

    /** @see WebChromeClient.onReceivedTouchIconUrl */
    override var onReceivedTouchIconUrl: ((view: WebView?, url: String?, precomposed: Boolean) -> Unit)? = null

    /** @see WebChromeClient.onRequestFocus */
    override var onRequestFocus: ((view: WebView?) -> Unit)? = null

    /** @see WebChromeClient.onShowCustomView */
    override var onShowCustomView: ((view: View?, callback: WebChromeClient.CustomViewCallback?) -> Unit)? = null

    /** @see WebChromeClient.onShowFileChooser */
    override var onShowFileChooser: ((webView: WebView?, filePathCallback: ValueCallback<Array<Uri>>?, fileChooserParams: WebChromeClient.FileChooserParams?) -> Boolean)? = null


    /** @see WebChromeClient.getDefaultVideoPoster */
    override fun getDefaultVideoPoster(callback: (() -> Bitmap?)?) = apply { getDefaultVideoPoster = callback }

    /** @see WebChromeClient.getVideoLoadingProgressView */
    override fun getVideoLoadingProgressView(callback: (() -> View?)?) = apply { getVideoLoadingProgressView = callback }

    /** @see WebChromeClient.getVisitedHistory */
    override fun getVisitedHistory(callback: ((callback: ValueCallback<Array<String>>?) -> Unit)?) = apply { getVisitedHistory = callback }

    /** @see WebChromeClient.onCloseWindow */
    override fun onCloseWindow(callback: ((window: WebView?) -> Unit)?) = apply { onCloseWindow = callback }

    /** @see WebChromeClient.onConsoleMessage */
    override fun onConsoleMessage(callback: ((consoleMessage: ConsoleMessage?) -> Boolean)?) = apply { onConsoleMessage = callback }

    /** @see WebChromeClient.onCreateWindow */
    override fun onCreateWindow(callback: ((view: WebView?, isDialog: Boolean, isUserGesture: Boolean, resultMsg: Message?) -> Boolean)?) = apply { onCreateWindow = callback }

    /** @see WebChromeClient.onGeolocationPermissionsHidePrompt */
    override fun onGeolocationPermissionsHidePrompt(callback: (() -> Unit)?) = apply { onGeolocationPermissionsHidePrompt = callback }

    /** @see WebChromeClient.onGeolocationPermissionsShowPrompt */
    override fun onGeolocationPermissionsShowPrompt(callback: ((origin: String?, callback: GeolocationPermissions.Callback?) -> Unit)?) = apply { onGeolocationPermissionsShowPrompt = callback }

    /** @see WebChromeClient.onHideCustomView */
    override fun onHideCustomView(callback: (() -> Unit)?) = apply { onHideCustomView = callback }

    /** @see WebChromeClient.onJsAlert */
    override fun onJsAlert(callback: ((view: WebView?, url: String?, message: String?, result: JsResult?) -> Boolean)?) = apply { onJsAlert = callback }

    /** @see WebChromeClient.onJsBeforeUnload */
    override fun onJsBeforeUnload(callback: ((view: WebView?, url: String?, message: String?, result: JsResult?) -> Boolean)?) = apply { onJsBeforeUnload = callback }

    /** @see WebChromeClient.onJsConfirm */
    override fun onJsConfirm(callback: ((view: WebView?, url: String?, message: String?, result: JsResult?) -> Boolean)?) = apply { onJsConfirm = callback }

    /** @see WebChromeClient.onJsPrompt */
    override fun onJsPrompt(callback: ((view: WebView?, url: String?, message: String?, defaultValue: String?, result: JsPromptResult?) -> Boolean)?) = apply { onJsPrompt = callback }

    /** @see WebChromeClient.onPermissionRequest */
    override fun onPermissionRequest(callback: ((request: PermissionRequest?) -> Unit)?) = apply { onPermissionRequest = callback }

    /** @see WebChromeClient.onPermissionRequestCanceled */
    override fun onPermissionRequestCanceled(callback: ((request: PermissionRequest?) -> Unit)?) = apply { onPermissionRequestCanceled = callback }

    /** @see WebChromeClient.onProgressChanged */
    override fun onProgressChanged(callback: ((view: WebView?, newProgress: Int) -> Unit)?) = apply { onProgressChanged = callback }

    /** @see WebChromeClient.onReceivedIcon */
    override fun onReceivedIcon(callback: ((view: WebView?, icon: Bitmap?) -> Unit)?) = apply { onReceivedIcon = callback }

    /** @see WebChromeClient.onReceivedTitle */
    override fun onReceivedTitle(callback: ((view: WebView?, title: String?) -> Unit)?) = apply { onReceivedTitle = callback }

    /** @see WebChromeClient.onReceivedTouchIconUrl */
    override fun onReceivedTouchIconUrl(callback: ((view: WebView?, url: String?, precomposed: Boolean) -> Unit)?) = apply { onReceivedTouchIconUrl = callback }

    /** @see WebChromeClient.onRequestFocus */
    override fun onRequestFocus(callback: ((view: WebView?) -> Unit)?) = apply { onRequestFocus = callback }

    /** @see WebChromeClient.onShowCustomView */
    override fun onShowCustomView(callback: ((view: View?, callback: WebChromeClient.CustomViewCallback?) -> Unit)?) = apply { onShowCustomView = callback }

    /** @see WebChromeClient.onShowFileChooser */
    override fun onShowFileChooser(callback: ((webView: WebView?, filePathCallback: ValueCallback<Array<Uri>>?, fileChooserParams: WebChromeClient.FileChooserParams?) -> Boolean)?) = apply { onShowFileChooser = callback }


    /**
     * Generate by builder's settings.
     */
    fun build() = object : WebChromeClient() {
        override fun getDefaultVideoPoster() = getDefaultVideoPoster?.invoke()
                ?: super.getDefaultVideoPoster()

        override fun getVideoLoadingProgressView() = getVideoLoadingProgressView?.invoke()
                ?: super.getVideoLoadingProgressView()

        override fun getVisitedHistory(callback: ValueCallback<Array<String>>?) = getVisitedHistory?.invoke(callback)
                ?: super.getVisitedHistory(callback)

        override fun onCloseWindow(window: WebView?) = onCloseWindow?.invoke(window)
                ?: super.onCloseWindow(window)

        override fun onConsoleMessage(consoleMessage: ConsoleMessage?) = onConsoleMessage?.invoke(consoleMessage)
                ?: super.onConsoleMessage(consoleMessage)

        override fun onCreateWindow(view: WebView?, isDialog: Boolean, isUserGesture: Boolean, resultMsg: Message?) = onCreateWindow?.invoke(view, isDialog, isUserGesture, resultMsg)
                ?: super.onCreateWindow(view, isDialog, isUserGesture, resultMsg)

        override fun onGeolocationPermissionsHidePrompt() = onGeolocationPermissionsHidePrompt?.invoke()
                ?: super.onGeolocationPermissionsHidePrompt()

        override fun onGeolocationPermissionsShowPrompt(origin: String?, callback: GeolocationPermissions.Callback?) = onGeolocationPermissionsShowPrompt?.invoke(origin, callback)
                ?: super.onGeolocationPermissionsShowPrompt(origin, callback)

        override fun onHideCustomView() = onHideCustomView?.invoke()
                ?: super.onHideCustomView()

        override fun onJsAlert(view: WebView?, url: String?, message: String?, result: JsResult?) = onJsAlert?.invoke(view, url, message, result)
                ?: super.onJsAlert(view, url, message, result)

        override fun onJsBeforeUnload(view: WebView?, url: String?, message: String?, result: JsResult?) = onJsBeforeUnload?.invoke(view, url, message, result)
                ?: super.onJsBeforeUnload(view, url, message, result)

        override fun onJsConfirm(view: WebView?, url: String?, message: String?, result: JsResult?) = onJsConfirm?.invoke(view, url, message, result)
                ?: super.onJsConfirm(view, url, message, result)

        override fun onJsPrompt(view: WebView?, url: String?, message: String?, defaultValue: String?, result: JsPromptResult?) = onJsPrompt?.invoke(view, url, message, defaultValue, result)
                ?: super.onJsPrompt(view, url, message, defaultValue, result)

        override fun onPermissionRequest(request: PermissionRequest?) = onPermissionRequest?.invoke(request)
                ?: super.onPermissionRequest(request)

        override fun onPermissionRequestCanceled(request: PermissionRequest?) = onPermissionRequestCanceled?.invoke(request)
                ?: super.onPermissionRequestCanceled(request)

        override fun onProgressChanged(view: WebView?, newProgress: Int) = onProgressChanged?.invoke(view, newProgress)
                ?: super.onProgressChanged(view, newProgress)

        override fun onReceivedIcon(view: WebView?, icon: Bitmap?) = onReceivedIcon?.invoke(view, icon)
                ?: super.onReceivedIcon(view, icon)

        override fun onReceivedTitle(view: WebView?, title: String?) = onReceivedTitle?.invoke(view, title)
                ?: super.onReceivedTitle(view, title)

        override fun onReceivedTouchIconUrl(view: WebView?, url: String?, precomposed: Boolean) = onReceivedTouchIconUrl?.invoke(view, url, precomposed)
                ?: super.onReceivedTouchIconUrl(view, url, precomposed)

        override fun onRequestFocus(view: WebView?) = onRequestFocus?.invoke(view)
                ?: super.onRequestFocus(view)

        override fun onShowCustomView(view: View?, callback: CustomViewCallback?) = onShowCustomView?.invoke(view, callback)
                ?: super.onShowCustomView(view, callback)

        override fun onShowFileChooser(webView: WebView?, filePathCallback: ValueCallback<Array<Uri>>?, fileChooserParams: FileChooserParams?) = onShowFileChooser?.invoke(webView, filePathCallback, fileChooserParams)
                ?: super.onShowFileChooser(webView, filePathCallback, fileChooserParams)
    }
}
