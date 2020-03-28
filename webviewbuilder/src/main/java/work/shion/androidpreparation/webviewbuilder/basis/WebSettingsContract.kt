package work.shion.androidpreparation.webviewbuilder.basis

import android.annotation.TargetApi
import android.webkit.WebSettings
import android.webkit.WebSettings.*
import androidx.annotation.IntDef

interface WebSettingsContract {

    @IntDef(LOAD_CACHE_ELSE_NETWORK, LOAD_CACHE_ONLY, LOAD_DEFAULT, LOAD_NO_CACHE)
    annotation class CacheModeType

    @IntDef(FORCE_DARK_AUTO, FORCE_DARK_OFF, FORCE_DARK_ON)
    @TargetApi(29)
    annotation class ForceDarkType

    @IntDef(MENU_ITEM_NONE, MENU_ITEM_PROCESS_TEXT, MENU_ITEM_SHARE, MENU_ITEM_WEB_SEARCH)
    @TargetApi(24)
    annotation class MenuItemsType

    @IntDef(MIXED_CONTENT_ALWAYS_ALLOW, MIXED_CONTENT_COMPATIBILITY_MODE, MIXED_CONTENT_NEVER_ALLOW)
    annotation class MixedContentModeType


    /** @see WebSettings.setAllowContentAccess */
    val allowContentAccess: Boolean?

    /** @see WebSettings.setAllowFileAccess */
    val allowFileAccess: Boolean?

    /** @see WebSettings.setAllowFileAccessFromFileURLs */
    val allowFileAccessFromFileURLs: Boolean?

    /** @see WebSettings.setAllowUniversalAccessFromFileURLs */
    val allowUniversalAccessFromFileURLs: Boolean?

    /** @see WebSettings.setAppCacheEnabled */
    val appCacheEnabled: Boolean?

    /** @see WebSettings.setAppCachePath */
    val appCachePath: String?

    /** @see WebSettings.setBlockNetworkImage */
    val blockNetworkImage: Boolean?

    /** @see WebSettings.setBlockNetworkLoads */
    val blockNetworkLoads: Boolean?

    /** @see WebSettings.setBuiltInZoomControls */
    val builtInZoomControls: Boolean?

    /** @see WebSettings.setCacheMode */
    @CacheModeType
    val cacheMode: Int?

    /** @see WebSettings.setCursiveFontFamily */
    val cursiveFontFamily: String?

    /** @see WebSettings.setDatabaseEnabled */
    val databaseEnabled: Boolean?

    /** @see WebSettings.setDefaultFixedFontSize */
    val defaultFixedFontSize: Int?

    /** @see WebSettings.setDefaultFontSize */
    val defaultFontSize: Int?

    /** @see WebSettings.setDefaultTextEncodingName */
    val defaultTextEncodingName: String?

    /** @see WebSettings.setDisabledActionModeMenuItems */
    @MenuItemsType
    val disabledActionModeMenuItems: Int?

    /** @see WebSettings.setDisplayZoomControls */
    val displayZoomControls: Boolean?

    /** @see WebSettings.setDomStorageEnabled */
    val domStorageEnabled: Boolean?

    /** @see WebSettings.setFantasyFontFamily */
    val fantasyFontFamily: String?

    /** @see WebSettings.setFixedFontFamily */
    val fixedFontFamily: String?

    /** @see WebSettings.setForceDark */
    @ForceDarkType
    val forceDark: Int?

    /** @see WebSettings.setGeolocationEnabled */
    val geolocationEnabled: Boolean?

    /** @see WebSettings.setJavaScriptCanOpenWindowsAutomatically */
    val javaScriptCanOpenWindowsAutomatically: Boolean?

    /** @see WebSettings.setJavaScriptEnabled */
    val javaScriptEnabled: Boolean?

    /** @see WebSettings.setLayoutAlgorithm */
    val layoutAlgorithm: LayoutAlgorithm?

    /** @see WebSettings.setLoadWithOverviewMode */
    val loadWithOverviewMode: Boolean?

    /** @see WebSettings.setLoadsImagesAutomatically */
    val loadsImagesAutomatically: Boolean?

    /** @see WebSettings.setMediaPlaybackRequiresUserGesture */
    val mediaPlaybackRequiresUserGesture: Boolean?

    /** @see WebSettings.setMinimumFontSize */
    val minimumFontSize: Int?

    /** @see WebSettings.setMinimumLogicalFontSize */
    val minimumLogicalFontSize: Int?

    /** @see WebSettings.setMixedContentMode */
    @MixedContentModeType
    val mixedContentMode: Int?

    /** @see WebSettings.setNeedInitialFocus */
    val needInitialFocus: Boolean?

    /** @see WebSettings.setOffscreenPreRaster */
    val offscreenPreRaster: Boolean?

    /** @see WebSettings.setSafeBrowsingEnabled */
    val safeBrowsingEnabled: Boolean?

    /** @see WebSettings.setSansSerifFontFamily */
    val sansSerifFontFamily: String?

    /** @see WebSettings.setSerifFontFamily */
    val serifFontFamily: String?

    /** @see WebSettings.setStandardFontFamily */
    val standardFontFamily: String?

    /** @see WebSettings.supportMultipleWindows */
    val supportMultipleWindows: Boolean?

    /** @see WebSettings.supportZoom */
    val supportZoom: Boolean?

    /** @see WebSettings.setTextZoom */
    val textZoom: Int?

    /** @see WebSettings.setUserAgentString */
    val userAgentString: String?

    /** @see WebSettings.setUseWideViewPort */
    val useWideViewPort: Boolean?


    /** @see WebSettings.setAllowContentAccess */
    fun allowContentAccess(input: Boolean?): WebSettingsContract

    /** @see WebSettings.setAllowFileAccess */
    fun allowFileAccess(input: Boolean?): WebSettingsContract

    /** @see WebSettings.setAllowFileAccessFromFileURLs */
    fun allowFileAccessFromFileURLs(input: Boolean?): WebSettingsContract

    /** @see WebSettings.setAllowUniversalAccessFromFileURLs */
    fun allowUniversalAccessFromFileURLs(input: Boolean?): WebSettingsContract

    /** @see WebSettings.setAppCacheEnabled */
    fun appCacheEnabled(input: Boolean?): WebSettingsContract

    /** @see WebSettings.setAppCachePath */
    fun appCachePath(input: String?): WebSettingsContract

    /** @see WebSettings.setBlockNetworkImage */
    fun blockNetworkImage(input: Boolean?): WebSettingsContract

    /** @see WebSettings.setBlockNetworkLoads */
    fun blockNetworkLoads(input: Boolean?): WebSettingsContract

    /** @see WebSettings.setBuiltInZoomControls */
    fun builtInZoomControls(input: Boolean?): WebSettingsContract

    /** @see WebSettings.setCacheMode */
    fun cacheMode(@CacheModeType input: Int?): WebSettingsContract

    /** @see WebSettings.setCursiveFontFamily */
    fun cursiveFontFamily(input: String?): WebSettingsContract

    /** @see WebSettings.setDatabaseEnabled */
    fun databaseEnabled(input: Boolean?): WebSettingsContract

    /** @see WebSettings.setDefaultFixedFontSize */
    fun defaultFixedFontSize(input: Int?): WebSettingsContract

    /** @see WebSettings.setDefaultFontSize */
    fun defaultFontSize(input: Int?): WebSettingsContract

    /** @see WebSettings.setDefaultTextEncodingName */
    fun defaultTextEncodingName(input: String?): WebSettingsContract

    /** @see WebSettings.setDisabledActionModeMenuItems */
    fun disabledActionModeMenuItems(@MenuItemsType input: Int?): WebSettingsContract

    /** @see WebSettings.setDisplayZoomControls */
    fun displayZoomControls(input: Boolean?): WebSettingsContract

    /** @see WebSettings.setDomStorageEnabled */
    fun domStorageEnabled(input: Boolean?): WebSettingsContract

    /** @see WebSettings.setFantasyFontFamily */
    fun fantasyFontFamily(input: String?): WebSettingsContract

    /** @see WebSettings.setFixedFontFamily */
    fun fixedFontFamily(input: String?): WebSettingsContract

    /** @see WebSettings.setForceDark */
    fun forceDark(@ForceDarkType input: Int?): WebSettingsContract

    /** @see WebSettings.setGeolocationEnabled */
    fun geolocationEnabled(input: Boolean?): WebSettingsContract

    /** @see WebSettings.setJavaScriptCanOpenWindowsAutomatically */
    fun javaScriptCanOpenWindowsAutomatically(input: Boolean?): WebSettingsContract

    /** @see WebSettings.setJavaScriptEnabled */
    fun javaScriptEnabled(input: Boolean?): WebSettingsContract

    /** @see WebSettings.setLayoutAlgorithm */
    fun layoutAlgorithm(input: LayoutAlgorithm?): WebSettingsContract

    /** @see WebSettings.setLoadsImagesAutomatically */
    fun loadsImagesAutomatically(input: Boolean?): WebSettingsContract

    /** @see WebSettings.setLoadWithOverviewMode */
    fun loadWithOverviewMode(input: Boolean?): WebSettingsContract

    /** @see WebSettings.setMediaPlaybackRequiresUserGesture */
    fun mediaPlaybackRequiresUserGesture(input: Boolean?): WebSettingsContract

    /** @see WebSettings.setMinimumFontSize */
    fun minimumFontSize(input: Int?): WebSettingsContract

    /** @see WebSettings.setMinimumLogicalFontSize */
    fun minimumLogicalFontSize(input: Int?): WebSettingsContract

    /** @see WebSettings.setMixedContentMode */
    fun mixedContentMode(@MixedContentModeType input: Int?): WebSettingsContract

    /** @see WebSettings.setNeedInitialFocus */
    fun needInitialFocus(input: Boolean?): WebSettingsContract

    /** @see WebSettings.setOffscreenPreRaster */
    fun offscreenPreRaster(input: Boolean?): WebSettingsContract

    /** @see WebSettings.setSafeBrowsingEnabled */
    fun safeBrowsingEnabled(input: Boolean?): WebSettingsContract

    /** @see WebSettings.setSansSerifFontFamily */
    fun sansSerifFontFamily(input: String?): WebSettingsContract

    /** @see WebSettings.setSerifFontFamily */
    fun serifFontFamily(input: String?): WebSettingsContract

    /** @see WebSettings.setStandardFontFamily */
    fun standardFontFamily(input: String?): WebSettingsContract

    /** @see WebSettings.supportMultipleWindows */
    fun supportMultipleWindows(input: Boolean?): WebSettingsContract

    /** @see WebSettings.supportZoom */
    fun supportZoom(input: Boolean?): WebSettingsContract

    /** @see WebSettings.setTextZoom */
    fun textZoom(input: Int?): WebSettingsContract

    /** @see WebSettings.setUserAgentString */
    fun userAgentString(input: String?): WebSettingsContract

    /** @see WebSettings.setUseWideViewPort */
    fun useWideViewPort(input: Boolean?): WebSettingsContract
}
