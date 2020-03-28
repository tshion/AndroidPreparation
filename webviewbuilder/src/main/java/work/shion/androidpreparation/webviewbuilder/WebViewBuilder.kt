package work.shion.androidpreparation.webviewbuilder

import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.webkit.WebSettingsCompat
import androidx.webkit.WebViewFeature
import work.shion.androidpreparation.webviewbuilder.basis.WebSettingsContract
import work.shion.androidpreparation.webviewbuilder.basis.WebViewContract

/**
 * Builder for WebView
 */
class WebViewBuilder : WebSettingsContract, WebViewContract {

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
    override var disabledActionModeMenuItems: Int? = null

    /** @see WebSettings.setDisplayZoomControls */
    override var displayZoomControls: Boolean? = null

    /** @see WebSettings.setDomStorageEnabled */
    override var domStorageEnabled: Boolean? = null

    /** @see WebSettings.setFantasyFontFamily */
    override var fantasyFontFamily: String? = null

    /** @see WebSettings.setFixedFontFamily */
    override var fixedFontFamily: String? = null

    /** @see WebSettings.setForceDark */
    override var forceDark: Int? = null

    /** @see WebSettings.setGeolocationEnabled */
    override var geolocationEnabled: Boolean? = null

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
    override var minimumLogicalFontSize: Int? = null

    /** @see WebSettings.setMixedContentMode */
    override var mixedContentMode: Int? = null

    /** @see WebSettings.setNeedInitialFocus */
    override var needInitialFocus: Boolean? = null

    /** @see WebSettings.setOffscreenPreRaster */
    override var offscreenPreRaster: Boolean? = null

    /** @see WebSettings.setSafeBrowsingEnabled */
    override var safeBrowsingEnabled: Boolean? = null

    /** @see WebSettings.setSansSerifFontFamily */
    override var sansSerifFontFamily: String? = null

    /** @see WebSettings.setSerifFontFamily */
    override var serifFontFamily: String? = null

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

    /** @see WebView.setWebChromeClient */
    override var webChromeClient: WebChromeClient? = null

    /** @see WebView.setWebViewClient */
    override var webViewClient: WebViewClient? = null


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
    override fun cacheMode(input: Int?) = apply { cacheMode = input }

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
    override fun disabledActionModeMenuItems(input: Int?) = apply { disabledActionModeMenuItems = input }

    /** @see WebSettings.setDisplayZoomControls */
    override fun displayZoomControls(input: Boolean?) = apply { displayZoomControls = input }

    /** @see WebSettings.setDomStorageEnabled */
    override fun domStorageEnabled(input: Boolean?) = apply { domStorageEnabled = input }

    /** @see WebSettings.setFantasyFontFamily */
    override fun fantasyFontFamily(input: String?) = apply { fantasyFontFamily = input }

    /** @see WebSettings.setFixedFontFamily */
    override fun fixedFontFamily(input: String?) = apply { fixedFontFamily = input }

    /** @see WebSettings.setForceDark */
    override fun forceDark(input: Int?) = apply { forceDark = input }

    /** @see WebSettings.setGeolocationEnabled */
    override fun geolocationEnabled(input: Boolean?) = apply { geolocationEnabled = input }

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
    override fun mixedContentMode(input: Int?) = apply { mixedContentMode = input }

    /** @see WebSettings.setNeedInitialFocus */
    override fun needInitialFocus(input: Boolean?) = apply { needInitialFocus = input }

    /** @see WebSettings.setOffscreenPreRaster */
    override fun offscreenPreRaster(input: Boolean?) = apply { offscreenPreRaster = input }

    /** @see WebSettings.setSafeBrowsingEnabled */
    override fun safeBrowsingEnabled(input: Boolean?) = apply { safeBrowsingEnabled = input }

    /** @see WebSettings.setSansSerifFontFamily */
    override fun sansSerifFontFamily(input: String?) = apply { sansSerifFontFamily = input }

    /** @see WebSettings.setSerifFontFamily */
    override fun serifFontFamily(input: String?) = apply { serifFontFamily = input }

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

    /** @see WebView.setWebChromeClient */
    override fun webChromeClient(input: WebChromeClient?) = apply { webChromeClient = input }

    /** @see WebView.setWebViewClient */
    override fun webViewClient(input: WebViewClient?) = apply { webViewClient = input }


    /**
     * Reflect builder's settings.
     */
    fun into(target: WebView) {
        allowContentAccess?.also { target.settings.allowContentAccess = it }
        allowFileAccess?.also { target.settings.allowFileAccess = it }
        allowFileAccessFromFileURLs?.also { target.settings.allowFileAccessFromFileURLs = it }
        allowUniversalAccessFromFileURLs?.also { target.settings.allowUniversalAccessFromFileURLs = it }
        appCacheEnabled?.also { target.settings.setAppCacheEnabled(it) }
        appCachePath?.also { target.settings.setAppCachePath(it) }
        blockNetworkImage?.also { target.settings.blockNetworkImage = it }
        blockNetworkLoads?.also { target.settings.blockNetworkLoads = it }
        builtInZoomControls?.also { target.settings.builtInZoomControls = it }
        cacheMode?.also { target.settings.cacheMode = it }
        cursiveFontFamily?.also { target.settings.cursiveFontFamily = it }
        databaseEnabled?.also { target.settings.databaseEnabled = it }
        defaultFixedFontSize?.also { target.settings.defaultFixedFontSize = it }
        defaultFontSize?.also { target.settings.defaultFontSize = it }
        defaultTextEncodingName?.also { target.settings.defaultTextEncodingName = it }
        disabledActionModeMenuItems?.also {
            if (WebViewFeature.isFeatureSupported(WebViewFeature.DISABLED_ACTION_MODE_MENU_ITEMS)) {
                WebSettingsCompat.setDisabledActionModeMenuItems(target.settings, it)
            }
        }
        displayZoomControls?.also { target.settings.displayZoomControls = it }
        domStorageEnabled?.also { target.settings.domStorageEnabled = it }
        fantasyFontFamily?.also { target.settings.fantasyFontFamily = it }
        fixedFontFamily?.also { target.settings.fixedFontFamily = it }
        forceDark?.also {
            if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK)) {
                WebSettingsCompat.setForceDark(target.settings, it)
            }
        }
        geolocationEnabled?.also { target.settings.setGeolocationEnabled(it) }
        javaScriptCanOpenWindowsAutomatically?.also { target.settings.javaScriptCanOpenWindowsAutomatically = it }
        javaScriptEnabled?.also { target.settings.javaScriptEnabled = it }
        layoutAlgorithm?.also { target.settings.layoutAlgorithm = it }
        loadsImagesAutomatically?.also { target.settings.loadsImagesAutomatically = it }
        loadWithOverviewMode?.also { target.settings.loadWithOverviewMode = it }
        mediaPlaybackRequiresUserGesture?.also { target.settings.mediaPlaybackRequiresUserGesture = it }
        minimumFontSize?.also { target.settings.minimumFontSize = it }
        minimumLogicalFontSize?.also { target.settings.minimumLogicalFontSize = it }
        mixedContentMode?.also { target.settings.mixedContentMode = it }
        needInitialFocus?.also { target.settings.setNeedInitialFocus(it) }
        offscreenPreRaster?.also {
            if (WebViewFeature.isFeatureSupported(WebViewFeature.OFF_SCREEN_PRERASTER)) {
                WebSettingsCompat.setOffscreenPreRaster(target.settings, it)
            }
        }
        safeBrowsingEnabled?.also {
            if (WebViewFeature.isFeatureSupported(WebViewFeature.SAFE_BROWSING_ENABLE)) {
                WebSettingsCompat.setSafeBrowsingEnabled(target.settings, it)
            }
        }
        sansSerifFontFamily?.also { target.settings.sansSerifFontFamily = it }
        serifFontFamily?.also { target.settings.serifFontFamily = it }
        standardFontFamily?.also { target.settings.standardFontFamily = it }
        supportMultipleWindows?.also { target.settings.setSupportMultipleWindows(it) }
        supportZoom?.also { target.settings.setSupportZoom(it) }
        textZoom?.also { target.settings.textZoom = it }
        userAgentString?.also { target.settings.userAgentString = it }
        useWideViewPort?.also { target.settings.useWideViewPort = it }


        webChromeClient?.also { target.webChromeClient = it }
        webViewClient?.also { target.webViewClient = it }
    }
}
