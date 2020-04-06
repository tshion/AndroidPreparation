package work.shion.androidpreparation.webviewbuilder

import android.annotation.TargetApi
import android.graphics.Bitmap
import android.net.Uri
import android.net.http.SslError
import android.os.Message
import android.view.KeyEvent
import android.view.View
import android.webkit.*
import androidx.webkit.SafeBrowsingResponseCompat
import androidx.webkit.WebResourceErrorCompat
import work.shion.androidpreparation.webviewbuilder.basis.WebChromeClientContract
import work.shion.androidpreparation.webviewbuilder.basis.WebSettingsContract
import work.shion.androidpreparation.webviewbuilder.basis.WebSettingsContract.*
import work.shion.androidpreparation.webviewbuilder.basis.WebViewClientContract
import work.shion.androidpreparation.webviewbuilder.basis.WebViewContract

/**
 * Builder for WebView
 */
class WebViewBuilder : WebChromeClientContract, WebSettingsContract, WebViewContract, WebViewClientContract {

    /** @see WebSettings.setAllowContentAccess */
    override var allowContentAccess: Boolean? = null

    /** @see WebSettings.setAllowFileAccess */
    override var allowFileAccess: Boolean? = null

    /** @see WebSettings.setAllowFileAccessFromFileURLs */
    override var allowFileAccessFromFileURLs: Boolean? = null

    /** @see WebSettings.setAllowUniversalAccessFromFileURLs */
    override var allowUniversalAccessFromFileURLs: Boolean? = null

    /** @see WebSettings.setAppCacheEnabled */
    override var appCacheEnabled: Boolean? = null

    /** @see WebSettings.setAppCachePath */
    override var appCachePath: String? = null

    /** @see WebSettings.setBlockNetworkImage */
    override var blockNetworkImage: Boolean? = null

    /** @see WebSettings.setBlockNetworkLoads */
    override var blockNetworkLoads: Boolean? = null

    /** @see WebSettings.setBuiltInZoomControls */
    override var builtInZoomControls: Boolean? = null

    /** @see WebSettings.setCacheMode */
    @get:CacheModeType
    @setparam:CacheModeType
    override var cacheMode: Int? = null

    /** @see WebSettings.setCursiveFontFamily */
    override var cursiveFontFamily: String? = null

    /** @see WebSettings.setDatabaseEnabled */
    override var databaseEnabled: Boolean? = null

    /** @see WebSettings.setDefaultFixedFontSize */
    override var defaultFixedFontSize: Int? = null

    /** @see WebSettings.setDefaultFontSize */
    override var defaultFontSize: Int? = null

    /** @see WebSettings.setDefaultTextEncodingName */
    override var defaultTextEncodingName: String? = null

    /** @see WebSettings.setDisabledActionModeMenuItems */
    @get:MenuItemsType
    @setparam:MenuItemsType
    override var disabledActionModeMenuItems: Int? = null

    /** @see WebSettings.setDisplayZoomControls */
    override var displayZoomControls: Boolean? = null

    /** @see WebSettings.setDomStorageEnabled */
    override var domStorageEnabled: Boolean? = null

    /** @see WebViewClient.doUpdateVisitedHistory */
    override var doUpdateVisitedHistory: ((view: WebView?, url: String?, isReload: Boolean) -> Unit)? = null

    /** @see WebSettings.setFantasyFontFamily */
    override var fantasyFontFamily: String? = null

    /** @see WebSettings.setFixedFontFamily */
    override var fixedFontFamily: String? = null

    /** @see WebSettings.setForceDark */
    @get:ForceDarkType
    @setparam:ForceDarkType
    override var forceDark: Int? = null

    /** @see WebSettings.setGeolocationEnabled */
    override var geolocationEnabled: Boolean? = null

    /** @see WebChromeClient.getDefaultVideoPoster */
    override var getDefaultVideoPoster: (() -> Bitmap?)? = null

    /** @see WebChromeClient.getVideoLoadingProgressView */
    override var getVideoLoadingProgressView: (() -> View?)? = null

    /** @see WebChromeClient.getVisitedHistory */
    override var getVisitedHistory: ((callback: ValueCallback<Array<String>>?) -> Unit)? = null

    /** @see WebSettings.setJavaScriptCanOpenWindowsAutomatically */
    override var javaScriptCanOpenWindowsAutomatically: Boolean? = null

    /** @see WebSettings.setJavaScriptEnabled */
    override var javaScriptEnabled: Boolean? = null

    /** @see WebSettings.setLayoutAlgorithm */
    override var layoutAlgorithm: WebSettings.LayoutAlgorithm? = null

    /** @see WebSettings.setLoadWithOverviewMode */
    override var loadWithOverviewMode: Boolean? = null

    /** @see WebSettings.setLoadsImagesAutomatically */
    override var loadsImagesAutomatically: Boolean? = null

    /** @see WebSettings.setMediaPlaybackRequiresUserGesture */
    override var mediaPlaybackRequiresUserGesture: Boolean? = null

    /** @see WebSettings.setMinimumFontSize */
    override var minimumFontSize: Int? = null

    /** @see WebSettings.setMinimumLogicalFontSize */
    @get:MixedContentModeType
    @setparam:MixedContentModeType
    override var minimumLogicalFontSize: Int? = null

    /** @see WebSettings.setMixedContentMode */
    override var mixedContentMode: Int? = null

    /** @see WebSettings.setNeedInitialFocus */
    override var needInitialFocus: Boolean? = null

    /** @see WebSettings.setOffscreenPreRaster */
    override var offscreenPreRaster: Boolean? = null

    /** @see WebChromeClient.onCloseWindow */
    override var onCloseWindow: ((window: WebView?) -> Unit)? = null

    /** @see WebChromeClient.onConsoleMessage */
    override var onConsoleMessage: ((consoleMessage: ConsoleMessage?) -> Boolean)? = null

    /** @see WebChromeClient.onCreateWindow */
    override var onCreateWindow: ((view: WebView?, isDialog: Boolean, isUserGesture: Boolean, resultMsg: Message?) -> Boolean)? = null

    /** @see WebViewClient.onFormResubmission */
    override var onFormResubmission: ((view: WebView?, dontResend: Message?, resend: Message?) -> Unit)? = null

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

    /** @see WebViewClient.onLoadResource */
    override var onLoadResource: ((view: WebView?, url: String?) -> Unit)? = null

    /** @see WebViewClient.onPageCommitVisible */
    @TargetApi(23)
    override var onPageCommitVisible: ((view: WebView?, url: String?) -> Unit)? = null

    /** @see WebViewClient.onPageFinished */
    override var onPageFinished: ((view: WebView?, url: String?) -> Unit)? = null

    /** @see WebViewClient.onPageStarted */
    override var onPageStarted: ((view: WebView?, url: String?, favicon: Bitmap?) -> Unit)? = null

    /** @see WebChromeClient.onPermissionRequest */
    override var onPermissionRequest: ((request: PermissionRequest?) -> Unit)? = null

    /** @see WebChromeClient.onPermissionRequestCanceled */
    override var onPermissionRequestCanceled: ((request: PermissionRequest?) -> Unit)? = null

    /** @see WebChromeClient.onProgressChanged */
    override var onProgressChanged: ((view: WebView?, newProgress: Int) -> Unit)? = null

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

    /** @see WebChromeClient.onReceivedIcon */
    override var onReceivedIcon: ((view: WebView?, icon: Bitmap?) -> Unit)? = null

    /** @see WebViewClient.onReceivedLoginRequest */
    override var onReceivedLoginRequest: ((view: WebView?, realm: String?, account: String?, args: String?) -> Unit)? = null

    /** @see WebViewClient.onReceivedSslError */
    override var onReceivedSslError: ((view: WebView?, handler: SslErrorHandler?, error: SslError?) -> Unit)? = null

    /** @see WebChromeClient.onReceivedTitle */
    override var onReceivedTitle: ((view: WebView?, title: String?) -> Unit)? = null

    /** @see WebChromeClient.onReceivedTouchIconUrl */
    override var onReceivedTouchIconUrl: ((view: WebView?, url: String?, precomposed: Boolean) -> Unit)? = null

    /** @see WebViewClient.onRenderProcessGone */
    @TargetApi(26)
    override var onRenderProcessGone: ((view: WebView?, detail: RenderProcessGoneDetail?) -> Boolean)? = null

    /** @see WebChromeClient.onRequestFocus */
    override var onRequestFocus: ((view: WebView?) -> Unit)? = null

    /** @see WebViewClient.onSafeBrowsingHit */
    @TargetApi(27)
    override var onSafeBrowsingHit: ((view: WebView?, request: WebResourceRequest?, threatType: Int, callback: SafeBrowsingResponseCompat) -> Unit)? = null

    /** @see WebViewClient.onScaleChanged */
    override var onScaleChanged: ((view: WebView?, oldScale: Float, newScale: Float) -> Unit)? = null

    /** @see WebChromeClient.onShowCustomView */
    override var onShowCustomView: ((view: View?, callback: WebChromeClient.CustomViewCallback?) -> Unit)? = null

    /** @see WebChromeClient.onShowFileChooser */
    override var onShowFileChooser: ((webView: WebView?, filePathCallback: ValueCallback<Array<Uri>>?, fileChooserParams: WebChromeClient.FileChooserParams?) -> Boolean)? = null

    /** @see WebSettings.setSafeBrowsingEnabled */
    override var safeBrowsingEnabled: Boolean? = null

    /** @see WebSettings.setSansSerifFontFamily */
    override var sansSerifFontFamily: String? = null

    /** @see WebSettings.setSerifFontFamily */
    override var serifFontFamily: String? = null

    /** @see WebViewClient.shouldInterceptRequest */
    override var shouldInterceptRequest: ((view: WebView?, request: WebResourceRequest?) -> WebResourceResponse?)? = null

    /** @see WebViewClient.shouldOverrideKeyEvent */
    override var shouldOverrideKeyEvent: ((view: WebView?, event: KeyEvent?) -> Boolean)? = null

    /** @see WebViewClient.shouldOverrideUrlLoading */
    override var shouldOverrideUrlLoading: ((view: WebView?, request: WebResourceRequest?) -> Boolean)? = null

    /** @see WebSettings.setStandardFontFamily */
    override var standardFontFamily: String? = null

    /** @see WebSettings.supportMultipleWindows */
    override var supportMultipleWindows: Boolean? = null

    /** @see WebSettings.supportZoom */
    override var supportZoom: Boolean? = null

    /** @see WebSettings.setTextZoom */
    override var textZoom: Int? = null

    /** @see WebSettings.setUserAgentString */
    override var userAgentString: String? = null

    /** @see WebSettings.setUseWideViewPort */
    override var useWideViewPort: Boolean? = null


    /** @see WebSettings.setAllowContentAccess */
    override fun allowContentAccess(input: Boolean?) = apply { allowContentAccess = input }

    /** @see WebSettings.setAllowFileAccess */
    override fun allowFileAccess(input: Boolean?) = apply { allowFileAccess = input }

    /** @see WebSettings.setAllowFileAccessFromFileURLs */
    override fun allowFileAccessFromFileURLs(input: Boolean?) = apply { allowFileAccessFromFileURLs = input }

    /** @see WebSettings.setAllowUniversalAccessFromFileURLs */
    override fun allowUniversalAccessFromFileURLs(input: Boolean?) = apply { allowUniversalAccessFromFileURLs = input }

    /** @see WebSettings.setAppCacheEnabled */
    override fun appCacheEnabled(input: Boolean?) = apply { appCacheEnabled = input }

    /** @see WebSettings.setAppCachePath */
    override fun appCachePath(input: String?) = apply { appCachePath = input }

    /** @see WebSettings.setBlockNetworkImage */
    override fun blockNetworkImage(input: Boolean?) = apply { blockNetworkImage = input }

    /** @see WebSettings.setBlockNetworkLoads */
    override fun blockNetworkLoads(input: Boolean?) = apply { blockNetworkLoads = input }

    /** @see WebSettings.setBuiltInZoomControls */
    override fun builtInZoomControls(input: Boolean?) = apply { builtInZoomControls = input }

    /** @see WebSettings.setCacheMode */
    override fun cacheMode(@CacheModeType input: Int?) = apply { cacheMode = input }

    /** @see WebSettings.setCursiveFontFamily */
    override fun cursiveFontFamily(input: String?) = apply { cursiveFontFamily = input }

    /** @see WebSettings.setDatabaseEnabled */
    override fun databaseEnabled(input: Boolean?) = apply { databaseEnabled = input }

    /** @see WebSettings.setDefaultFixedFontSize */
    override fun defaultFixedFontSize(input: Int?) = apply { defaultFixedFontSize = input }

    /** @see WebSettings.setDefaultFontSize */
    override fun defaultFontSize(input: Int?) = apply { defaultFontSize = input }

    /** @see WebSettings.setDefaultTextEncodingName */
    override fun defaultTextEncodingName(input: String?) = apply { defaultTextEncodingName = input }

    /** @see WebSettings.setDisabledActionModeMenuItems */
    override fun disabledActionModeMenuItems(@MenuItemsType input: Int?) = apply { disabledActionModeMenuItems = input }

    /** @see WebSettings.setDisplayZoomControls */
    override fun displayZoomControls(input: Boolean?) = apply { displayZoomControls = input }

    /** @see WebSettings.setDomStorageEnabled */
    override fun domStorageEnabled(input: Boolean?) = apply { domStorageEnabled = input }

    /** @see WebViewClient.doUpdateVisitedHistory */
    override fun doUpdateVisitedHistory(callback: ((view: WebView?, url: String?, isReload: Boolean) -> Unit)?) = apply { doUpdateVisitedHistory = callback }

    /** @see WebSettings.setFantasyFontFamily */
    override fun fantasyFontFamily(input: String?) = apply { fantasyFontFamily = input }

    /** @see WebSettings.setFixedFontFamily */
    override fun fixedFontFamily(input: String?) = apply { fixedFontFamily = input }

    /** @see WebSettings.setForceDark */
    override fun forceDark(@ForceDarkType input: Int?) = apply { forceDark = input }

    /** @see WebSettings.setGeolocationEnabled */
    override fun geolocationEnabled(input: Boolean?) = apply { geolocationEnabled = input }

    /** @see WebChromeClient.getDefaultVideoPoster */
    override fun getDefaultVideoPoster(callback: (() -> Bitmap?)?) = apply { getDefaultVideoPoster = callback }

    /** @see WebChromeClient.getVideoLoadingProgressView */
    override fun getVideoLoadingProgressView(callback: (() -> View?)?) = apply { getVideoLoadingProgressView = callback }

    /** @see WebChromeClient.getVisitedHistory */
    override fun getVisitedHistory(callback: ((callback: ValueCallback<Array<String>>?) -> Unit)?) = apply { getVisitedHistory = callback }

    /** @see WebSettings.setJavaScriptCanOpenWindowsAutomatically */
    override fun javaScriptCanOpenWindowsAutomatically(input: Boolean?) = apply { javaScriptCanOpenWindowsAutomatically = input }

    /** @see WebSettings.setJavaScriptEnabled */
    override fun javaScriptEnabled(input: Boolean?) = apply { javaScriptEnabled = input }

    /** @see WebSettings.setLayoutAlgorithm */
    override fun layoutAlgorithm(input: WebSettings.LayoutAlgorithm?) = apply { layoutAlgorithm = input }

    /** @see WebSettings.setLoadsImagesAutomatically */
    override fun loadsImagesAutomatically(input: Boolean?) = apply { loadsImagesAutomatically = input }

    /** @see WebSettings.setLoadWithOverviewMode */
    override fun loadWithOverviewMode(input: Boolean?) = apply { loadWithOverviewMode = input }

    /** @see WebSettings.setMediaPlaybackRequiresUserGesture */
    override fun mediaPlaybackRequiresUserGesture(input: Boolean?) = apply { mediaPlaybackRequiresUserGesture = input }

    /** @see WebSettings.setMinimumFontSize */
    override fun minimumFontSize(input: Int?) = apply { minimumFontSize = input }

    /** @see WebSettings.setMinimumLogicalFontSize */
    override fun minimumLogicalFontSize(input: Int?) = apply { minimumLogicalFontSize = input }

    /** @see WebSettings.setMixedContentMode */
    override fun mixedContentMode(@MixedContentModeType input: Int?) = apply { mixedContentMode = input }

    /** @see WebSettings.setNeedInitialFocus */
    override fun needInitialFocus(input: Boolean?) = apply { needInitialFocus = input }

    /** @see WebSettings.setOffscreenPreRaster */
    override fun offscreenPreRaster(input: Boolean?) = apply { offscreenPreRaster = input }

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

    /** @see WebViewClient.onFormResubmission */
    override fun onFormResubmission(callback: ((view: WebView?, dontResend: Message?, resend: Message?) -> Unit)?) = apply { onFormResubmission = callback }

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

    /** @see WebViewClient.onLoadResource */
    override fun onLoadResource(callback: ((view: WebView?, url: String?) -> Unit)?) = apply { onLoadResource = callback }

    /** @see WebViewClient.onPageCommitVisible */
    @TargetApi(23)
    override fun onPageCommitVisible(callback: ((view: WebView?, url: String?) -> Unit)?) = apply { onPageCommitVisible = callback }

    /** @see WebViewClient.onPageFinished */
    override fun onPageFinished(callback: ((view: WebView?, url: String?) -> Unit)?) = apply { onPageFinished = callback }

    /** @see WebViewClient.onPageStarted */
    override fun onPageStarted(callback: ((view: WebView?, url: String?, favicon: Bitmap?) -> Unit)?) = apply { onPageStarted = callback }

    /** @see WebChromeClient.onPermissionRequest */
    override fun onPermissionRequest(callback: ((request: PermissionRequest?) -> Unit)?) = apply { onPermissionRequest = callback }

    /** @see WebChromeClient.onPermissionRequestCanceled */
    override fun onPermissionRequestCanceled(callback: ((request: PermissionRequest?) -> Unit)?) = apply { onPermissionRequestCanceled = callback }

    /** @see WebChromeClient.onProgressChanged */
    override fun onProgressChanged(callback: ((view: WebView?, newProgress: Int) -> Unit)?) = apply { onProgressChanged = callback }

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

    /** @see WebChromeClient.onReceivedIcon */
    override fun onReceivedIcon(callback: ((view: WebView?, icon: Bitmap?) -> Unit)?) = apply { onReceivedIcon = callback }

    /** @see WebViewClient.onReceivedLoginRequest */
    override fun onReceivedLoginRequest(callback: ((view: WebView?, realm: String?, account: String?, args: String?) -> Unit)?) = apply { onReceivedLoginRequest = callback }

    /** @see WebViewClient.onReceivedSslError */
    override fun onReceivedSslError(callback: ((view: WebView?, handler: SslErrorHandler?, error: SslError?) -> Unit)?) = apply { onReceivedSslError = callback }

    /** @see WebChromeClient.onReceivedTitle */
    override fun onReceivedTitle(callback: ((view: WebView?, title: String?) -> Unit)?) = apply { onReceivedTitle = callback }

    /** @see WebChromeClient.onReceivedTouchIconUrl */
    override fun onReceivedTouchIconUrl(callback: ((view: WebView?, url: String?, precomposed: Boolean) -> Unit)?) = apply { onReceivedTouchIconUrl = callback }

    /** @see WebViewClient.onRenderProcessGone */
    @TargetApi(26)
    override fun onRenderProcessGone(callback: ((view: WebView?, detail: RenderProcessGoneDetail?) -> Boolean)?) = apply { onRenderProcessGone = callback }

    /** @see WebChromeClient.onRequestFocus */
    override fun onRequestFocus(callback: ((view: WebView?) -> Unit)?) = apply { onRequestFocus = callback }

    /** @see WebViewClient.onSafeBrowsingHit */
    @TargetApi(27)
    override fun onSafeBrowsingHit(callback: ((view: WebView?, request: WebResourceRequest?, threatType: Int, callback: SafeBrowsingResponseCompat) -> Unit)?) = apply { onSafeBrowsingHit = callback }

    /** @see WebViewClient.onScaleChanged */
    override fun onScaleChanged(callback: ((view: WebView?, oldScale: Float, newScale: Float) -> Unit)?) = apply { onScaleChanged = callback }

    /** @see WebChromeClient.onShowCustomView */
    override fun onShowCustomView(callback: ((view: View?, callback: WebChromeClient.CustomViewCallback?) -> Unit)?) = apply { onShowCustomView = callback }

    /** @see WebChromeClient.onShowFileChooser */
    override fun onShowFileChooser(callback: ((webView: WebView?, filePathCallback: ValueCallback<Array<Uri>>?, fileChooserParams: WebChromeClient.FileChooserParams?) -> Boolean)?) = apply { onShowFileChooser = callback }

    /** @see WebSettings.setSafeBrowsingEnabled */
    override fun safeBrowsingEnabled(input: Boolean?) = apply { safeBrowsingEnabled = input }

    /** @see WebSettings.setSansSerifFontFamily */
    override fun sansSerifFontFamily(input: String?) = apply { sansSerifFontFamily = input }

    /** @see WebSettings.setSerifFontFamily */
    override fun serifFontFamily(input: String?) = apply { serifFontFamily = input }

    /** @see WebViewClient.shouldInterceptRequest */
    override fun shouldInterceptRequest(callback: ((view: WebView?, request: WebResourceRequest?) -> WebResourceResponse?)?) = apply { shouldInterceptRequest = callback }

    /** @see WebViewClient.shouldOverrideKeyEvent */
    override fun shouldOverrideKeyEvent(callback: ((view: WebView?, event: KeyEvent?) -> Boolean)?) = apply { shouldOverrideKeyEvent = callback }

    /** @see WebViewClient.shouldOverrideUrlLoading */
    override fun shouldOverrideUrlLoading(callback: ((view: WebView?, request: WebResourceRequest?) -> Boolean)?) = apply { shouldOverrideUrlLoading = callback }

    /** @see WebSettings.setStandardFontFamily */
    override fun standardFontFamily(input: String?) = apply { standardFontFamily = input }

    /** @see WebSettings.supportMultipleWindows */
    override fun supportMultipleWindows(input: Boolean?) = apply { supportMultipleWindows = input }

    /** @see WebSettings.supportZoom */
    override fun supportZoom(input: Boolean?) = apply { supportZoom = input }

    /** @see WebSettings.setTextZoom */
    override fun textZoom(input: Int?) = apply { textZoom = input }

    /** @see WebSettings.setUserAgentString */
    override fun userAgentString(input: String?) = apply { userAgentString = input }

    /** @see WebSettings.setUseWideViewPort */
    override fun useWideViewPort(input: Boolean?) = apply { useWideViewPort = input }


    /**
     * Reflect builder's settings.
     */
    fun into(target: WebView) = target.apply {
        into(settings)
        webChromeClient = buildChromeClient()
        webViewClient = buildViewClient()
    }
}
