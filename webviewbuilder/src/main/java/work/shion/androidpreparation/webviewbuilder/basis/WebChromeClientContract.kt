package work.shion.androidpreparation.webviewbuilder.basis

import android.graphics.Bitmap
import android.net.Uri
import android.os.Message
import android.view.View
import android.webkit.*
import android.webkit.WebChromeClient.CustomViewCallback
import android.webkit.WebChromeClient.FileChooserParams

interface WebChromeClientContract {

    /** @see WebChromeClient.getDefaultVideoPoster */
    val getDefaultVideoPoster: (() -> Bitmap?)?

    /** @see WebChromeClient.getVideoLoadingProgressView */
    val getVideoLoadingProgressView: (() -> View?)?

    /** @see WebChromeClient.getVisitedHistory */
    val getVisitedHistory: ((callback: ValueCallback<Array<String>>?) -> Unit)?

    /** @see WebChromeClient.onCloseWindow */
    val onCloseWindow: ((window: WebView?) -> Unit)?

    /** @see WebChromeClient.onConsoleMessage */
    val onConsoleMessage: ((consoleMessage: ConsoleMessage?) -> Boolean)?

    /** @see WebChromeClient.onCreateWindow */
    val onCreateWindow: ((view: WebView?, isDialog: Boolean, isUserGesture: Boolean, resultMsg: Message?) -> Boolean)?

    /** @see WebChromeClient.onGeolocationPermissionsHidePrompt */
    val onGeolocationPermissionsHidePrompt: (() -> Unit)?

    /** @see WebChromeClient.onGeolocationPermissionsShowPrompt */
    val onGeolocationPermissionsShowPrompt: ((origin: String?, callback: GeolocationPermissions.Callback?) -> Unit)?

    /** @see WebChromeClient.onHideCustomView */
    val onHideCustomView: (() -> Unit)?

    /** @see WebChromeClient.onJsAlert */
    val onJsAlert: ((view: WebView?, url: String?, message: String?, result: JsResult?) -> Boolean)?

    /** @see WebChromeClient.onJsBeforeUnload */
    val onJsBeforeUnload: ((view: WebView?, url: String?, message: String?, result: JsResult?) -> Boolean)?

    /** @see WebChromeClient.onJsConfirm */
    val onJsConfirm: ((view: WebView?, url: String?, message: String?, result: JsResult?) -> Boolean)?

    /** @see WebChromeClient.onJsPrompt */
    val onJsPrompt: ((view: WebView?, url: String?, message: String?, defaultValue: String?, result: JsPromptResult?) -> Boolean)?

    /** @see WebChromeClient.onPermissionRequest */
    val onPermissionRequest: ((request: PermissionRequest?) -> Unit)?

    /** @see WebChromeClient.onPermissionRequestCanceled */
    val onPermissionRequestCanceled: ((request: PermissionRequest?) -> Unit)?

    /** @see WebChromeClient.onProgressChanged */
    val onProgressChanged: ((view: WebView?, newProgress: Int) -> Unit)?

    /** @see WebChromeClient.onReceivedIcon */
    val onReceivedIcon: ((view: WebView?, icon: Bitmap?) -> Unit)?

    /** @see WebChromeClient.onReceivedTitle */
    val onReceivedTitle: ((view: WebView?, title: String?) -> Unit)?

    /** @see WebChromeClient.onReceivedTouchIconUrl */
    val onReceivedTouchIconUrl: ((view: WebView?, url: String?, precomposed: Boolean) -> Unit)?

    /** @see WebChromeClient.onRequestFocus */
    val onRequestFocus: ((view: WebView?) -> Unit)?

    /** @see WebChromeClient.onShowCustomView */
    val onShowCustomView: ((view: View?, callback: CustomViewCallback?) -> Unit)?

    /** @see WebChromeClient.onShowFileChooser */
    val onShowFileChooser: ((webView: WebView?, filePathCallback: ValueCallback<Array<Uri>>?, fileChooserParams: FileChooserParams?) -> Boolean)?


    /** @see WebChromeClient.getDefaultVideoPoster */
    fun getDefaultVideoPoster(callback: (() -> Bitmap?)?): WebChromeClientContract

    /** @see WebChromeClient.getVideoLoadingProgressView */
    fun getVideoLoadingProgressView(callback: (() -> View?)?): WebChromeClientContract

    /** @see WebChromeClient.getVisitedHistory */
    fun getVisitedHistory(callback: ((callback: ValueCallback<Array<String>>?) -> Unit)?): WebChromeClientContract

    /** @see WebChromeClient.onCloseWindow */
    fun onCloseWindow(callback: ((window: WebView?) -> Unit)?): WebChromeClientContract

    /** @see WebChromeClient.onConsoleMessage */
    fun onConsoleMessage(callback: ((consoleMessage: ConsoleMessage?) -> Boolean)?): WebChromeClientContract

    /** @see WebChromeClient.onCreateWindow */
    fun onCreateWindow(callback: ((view: WebView?, isDialog: Boolean, isUserGesture: Boolean, resultMsg: Message?) -> Boolean)?): WebChromeClientContract

    /** @see WebChromeClient.onGeolocationPermissionsHidePrompt */
    fun onGeolocationPermissionsHidePrompt(callback: (() -> Unit)?): WebChromeClientContract

    /** @see WebChromeClient.onGeolocationPermissionsShowPrompt */
    fun onGeolocationPermissionsShowPrompt(callback: ((origin: String?, callback: GeolocationPermissions.Callback?) -> Unit)?): WebChromeClientContract

    /** @see WebChromeClient.onHideCustomView */
    fun onHideCustomView(callback: (() -> Unit)?): WebChromeClientContract

    /** @see WebChromeClient.onJsAlert */
    fun onJsAlert(callback: ((view: WebView?, url: String?, message: String?, result: JsResult?) -> Boolean)?): WebChromeClientContract

    /** @see WebChromeClient.onJsBeforeUnload */
    fun onJsBeforeUnload(callback: ((view: WebView?, url: String?, message: String?, result: JsResult?) -> Boolean)?): WebChromeClientContract

    /** @see WebChromeClient.onJsConfirm */
    fun onJsConfirm(callback: ((view: WebView?, url: String?, message: String?, result: JsResult?) -> Boolean)?): WebChromeClientContract

    /** @see WebChromeClient.onJsPrompt */
    fun onJsPrompt(callback: ((view: WebView?, url: String?, message: String?, defaultValue: String?, result: JsPromptResult?) -> Boolean)?): WebChromeClientContract

    /** @see WebChromeClient.onPermissionRequest */
    fun onPermissionRequest(callback: ((request: PermissionRequest?) -> Unit)?): WebChromeClientContract

    /** @see WebChromeClient.onPermissionRequestCanceled */
    fun onPermissionRequestCanceled(callback: ((request: PermissionRequest?) -> Unit)?): WebChromeClientContract

    /** @see WebChromeClient.onProgressChanged */
    fun onProgressChanged(callback: ((view: WebView?, newProgress: Int) -> Unit)?): WebChromeClientContract

    /** @see WebChromeClient.onReceivedIcon */
    fun onReceivedIcon(callback: ((view: WebView?, icon: Bitmap?) -> Unit)?): WebChromeClientContract

    /** @see WebChromeClient.onReceivedTitle */
    fun onReceivedTitle(callback: ((view: WebView?, title: String?) -> Unit)?): WebChromeClientContract

    /** @see WebChromeClient.onReceivedTouchIconUrl */
    fun onReceivedTouchIconUrl(callback: ((view: WebView?, url: String?, precomposed: Boolean) -> Unit)?): WebChromeClientContract

    /** @see WebChromeClient.onRequestFocus */
    fun onRequestFocus(callback: ((view: WebView?) -> Unit)?): WebChromeClientContract

    /** @see WebChromeClient.onShowCustomView */
    fun onShowCustomView(callback: ((view: View?, callback: CustomViewCallback?) -> Unit)?): WebChromeClientContract

    /** @see WebChromeClient.onShowFileChooser */
    fun onShowFileChooser(callback: ((webView: WebView?, filePathCallback: ValueCallback<Array<Uri>>?, fileChooserParams: FileChooserParams?) -> Boolean)?): WebChromeClientContract


    /**
     * Was set at least one
     */
    fun wasSetChromeClient() = (getDefaultVideoPoster
            ?: getVideoLoadingProgressView
            ?: getVisitedHistory
            ?: onCloseWindow
            ?: onConsoleMessage
            ?: onCreateWindow
            ?: onGeolocationPermissionsHidePrompt
            ?: onGeolocationPermissionsShowPrompt
            ?: onHideCustomView
            ?: onJsAlert
            ?: onJsBeforeUnload
            ?: onJsConfirm
            ?: onJsPrompt
            ?: onPermissionRequest
            ?: onPermissionRequestCanceled
            ?: onProgressChanged
            ?: onReceivedIcon
            ?: onReceivedTitle
            ?: onReceivedTouchIconUrl
            ?: onRequestFocus
            ?: onShowCustomView
            ?: onShowFileChooser
            ) != null
}
