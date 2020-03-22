package work.shion.androidpreparation.webviewbuilder

import android.annotation.TargetApi
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebSettings.*
import android.webkit.WebView
import androidx.annotation.IntDef
import androidx.annotation.RequiresApi
import androidx.webkit.WebSettingsCompat
import androidx.webkit.WebViewClientCompat
import androidx.webkit.WebViewFeature


/**
 * WebView 設定ビルダー
 */
class WebViewBuilder {
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


    private var mAllowContentAccess: Boolean? = null
    private var mAllowFileAccess: Boolean? = null
    private var mAllowFileAccessFromFileURLs: Boolean? = null
    private var mAllowUniversalAccessFromFileURLs: Boolean? = null
    private var mAppCacheEnabled: Boolean? = null
    private var mAppCachePath: String? = null
    private var mBlockNetworkImage: Boolean? = null
    private var mBlockNetworkLoads: Boolean? = null
    private var mBuiltInZoomControls: Boolean? = null
    private var mCacheMode: Int? = null
    private var mCursiveFontFamily: String? = null
    private var mDatabaseEnabled: Boolean? = null
    private var mDefaultFixedFontSize: Int? = null
    private var mDefaultFontSize: Int? = null
    private var mDefaultTextEncodingName: String? = null
    private var mDisabledActionModeMenuItems: Int? = null
    private var mDisplayZoomControls: Boolean? = null
    private var mDomStorageEnabled: Boolean? = null
    private var mFantasyFontFamily: String? = null
    private var mFixedFontFamily: String? = null
    private var mForceDark: Int? = null
    private var mGeolocationEnabled: Boolean? = null
    private var mJavaScriptCanOpenWindowsAutomatically: Boolean? = null
    private var mJavaScriptEnabled: Boolean? = null
    private var mLayoutAlgorithm: WebSettings.LayoutAlgorithm? = null
    private var mLoadWithOverviewMode: Boolean? = null
    private var mLoadsImagesAutomatically: Boolean? = null
    private var mMediaPlaybackRequiresUserGesture: Boolean? = null
    private var mMinimumFontSize: Int? = null
    private var mMinimumLogicalFontSize: Int? = null
    private var mMixedContentMode: Int? = null
    private var mNeedInitialFocus: Boolean? = null
    private var mOffscreenPreRaster: Boolean? = null
    private var mSafeBrowsingEnabled: Boolean? = null
    private var mSansSerifFontFamily: String? = null
    private var mSerifFontFamily: String? = null
    private var mStandardFontFamily: String? = null
    private var mSupportMultipleWindows: Boolean? = null
    private var mSupportZoom: Boolean? = null
    private var mTextZoom: Int? = null
    private var mUserAgentString: String? = null
    private var mUseWideViewPort: Boolean? = null
    private var mWebChromeClient: WebChromeClient? = null
    private var mWebViewClient: WebViewClientCompat? = null


    /**
     * 指定のWebView に設定を反映する
     */
    fun into(target: WebView) = target.apply {
        if (mWebChromeClient != null) webChromeClient = mWebChromeClient
        if (mWebViewClient != null) webViewClient = mWebViewClient

        with(settings) {
            allowContentAccess = mAllowContentAccess ?: allowContentAccess
            allowFileAccess = mAllowFileAccess ?: allowFileAccess
            allowFileAccessFromFileURLs =
                    mAllowFileAccessFromFileURLs ?: allowFileAccessFromFileURLs
            allowUniversalAccessFromFileURLs =
                    mAllowUniversalAccessFromFileURLs ?: allowUniversalAccessFromFileURLs
            if (mAppCacheEnabled != null) setAppCacheEnabled(mAppCacheEnabled!!)
            if (mAppCachePath != null) setAppCachePath(mAppCachePath)
            blockNetworkImage = mBlockNetworkImage ?: blockNetworkImage
            blockNetworkLoads = mBlockNetworkLoads ?: blockNetworkLoads
            builtInZoomControls = mBuiltInZoomControls ?: builtInZoomControls
            cacheMode = mCacheMode ?: cacheMode
            cursiveFontFamily = mCursiveFontFamily ?: cursiveFontFamily
            databaseEnabled = mDatabaseEnabled ?: databaseEnabled
            defaultFixedFontSize = mDefaultFixedFontSize ?: defaultFontSize
            defaultFontSize = mDefaultFontSize ?: defaultFontSize
            defaultTextEncodingName = mDefaultTextEncodingName ?: defaultTextEncodingName
            if (WebViewFeature.isFeatureSupported(WebViewFeature.DISABLED_ACTION_MODE_MENU_ITEMS)) {
                val defaultValue = WebSettingsCompat.getDisabledActionModeMenuItems(settings)
                WebSettingsCompat.setDisabledActionModeMenuItems(
                        settings,
                        mDisabledActionModeMenuItems ?: defaultValue
                )
            }
            displayZoomControls = mDisplayZoomControls ?: displayZoomControls
            domStorageEnabled = mDomStorageEnabled ?: domStorageEnabled
            fantasyFontFamily = mFantasyFontFamily ?: fantasyFontFamily
            fixedFontFamily = mFixedFontFamily ?: fixedFontFamily
            if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK)) {
                val defaultValue = WebSettingsCompat.getForceDark(settings)
                WebSettingsCompat.setForceDark(
                        settings,
                        mForceDark ?: defaultValue
                )
            }
            if (mGeolocationEnabled != null) setGeolocationEnabled(mGeolocationEnabled!!)
            javaScriptCanOpenWindowsAutomatically =
                    mJavaScriptCanOpenWindowsAutomatically ?: javaScriptCanOpenWindowsAutomatically
            javaScriptEnabled = mJavaScriptEnabled ?: javaScriptEnabled
            layoutAlgorithm = mLayoutAlgorithm ?: layoutAlgorithm
            loadWithOverviewMode = mLoadWithOverviewMode ?: loadWithOverviewMode
            loadsImagesAutomatically = mLoadsImagesAutomatically ?: loadsImagesAutomatically
            mediaPlaybackRequiresUserGesture =
                    mMediaPlaybackRequiresUserGesture ?: mediaPlaybackRequiresUserGesture
            minimumFontSize = mMinimumFontSize ?: minimumFontSize
            minimumLogicalFontSize = mMinimumLogicalFontSize ?: minimumLogicalFontSize
            mixedContentMode = mMixedContentMode ?: mixedContentMode
            if (mNeedInitialFocus != null) setNeedInitialFocus(mNeedInitialFocus!!)
            if (WebViewFeature.isFeatureSupported(WebViewFeature.OFF_SCREEN_PRERASTER)) {
                val defaultValue = WebSettingsCompat.getOffscreenPreRaster(settings)
                WebSettingsCompat.setOffscreenPreRaster(
                        settings,
                        mOffscreenPreRaster ?: defaultValue
                )
            }
            if (WebViewFeature.isFeatureSupported(WebViewFeature.SAFE_BROWSING_ENABLE)) {
                val defaultValue = WebSettingsCompat.getSafeBrowsingEnabled(settings)
                WebSettingsCompat.setSafeBrowsingEnabled(
                        settings,
                        mSafeBrowsingEnabled ?: defaultValue
                )
            }
            sansSerifFontFamily = mSansSerifFontFamily ?: sansSerifFontFamily
            serifFontFamily = mSerifFontFamily ?: serifFontFamily
            standardFontFamily = mStandardFontFamily ?: standardFontFamily
            setSupportMultipleWindows(mSupportMultipleWindows ?: supportMultipleWindows())
            setSupportZoom(mSupportZoom ?: supportZoom())
            textZoom = mTextZoom ?: textZoom
            userAgentString = mUserAgentString ?: userAgentString
            useWideViewPort = mUseWideViewPort ?: useWideViewPort
        }
    }


    /**
     * @see android.webkit.WebSettings.setAllowContentAccess
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebSettings#setAllowContentAccess">Android Developers</a>
     */
    fun setAllowContentAccess(value: Boolean?) = this.apply { mAllowContentAccess = value }

    /**
     * @see android.webkit.WebSettings.setAllowFileAccess
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebSettings#setAllowFileAccess">Android Developers</a>
     */
    fun setAllowFileAccess(value: Boolean?) = this.apply { mAllowFileAccess = value }

    /**
     * @see android.webkit.WebSettings.setAllowFileAccessFromFileURLs
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebSettings#setAllowFileAccessFromFileURLs">Android Developers</a>
     */
    fun setAllowFileAccessFromFileURLs(value: Boolean?) = this.apply { mAllowFileAccessFromFileURLs = value }

    /**
     * @see android.webkit.WebSettings.setAllowUniversalAccessFromFileURLs
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebSettings#setAllowUniversalAccessFromFileURLs">Android Developers</a>
     */
    fun setAllowUniversalAccessFromFileURLs(value: Boolean?) = this.apply { mAllowUniversalAccessFromFileURLs = value }

    /**
     * @see android.webkit.WebSettings.setAppCacheEnabled
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebSettings#setAppCacheEnabled">Android Developers</a>
     */
    fun setAppCacheEnabled(value: Boolean?) = this.apply { mAppCacheEnabled = value }

    /**
     * @see android.webkit.WebSettings.setAppCachePath
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebSettings#setAppCachePath">Android Developers</a>
     */
    fun setAppCachePath(value: String?) = this.apply { mAppCachePath = value }

    /**
     * @see android.webkit.WebSettings.setBlockNetworkImage
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebSettings#setBlockNetworkImage">Android Developers</a>
     */
    fun setBlockNetworkImage(value: Boolean?) = this.apply { mBlockNetworkImage = value }

    /**
     * @see android.webkit.WebSettings.setBlockNetworkLoads
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebSettings#setBlockNetworkLoads">Android Developers</a>
     */
    fun setBlockNetworkLoads(value: Boolean?) = this.apply { mBlockNetworkLoads = value }

    /**
     * @see android.webkit.WebSettings.setBuiltInZoomControls
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebSettings#setBuiltInZoomControls">Android Developers</a>
     */
    fun setBuiltInZoomControls(value: Boolean?) = this.apply { mBuiltInZoomControls = value }

    /**
     * @see android.webkit.WebSettings.setCacheMode
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebSettings#setCacheMode">Android Developers</a>
     */
    fun setCacheMode(@CacheModeType value: Int?) = this.apply { mCacheMode = value }

    /**
     * @see android.webkit.WebSettings.setCursiveFontFamily
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebSettings#setCursiveFontFamily">Android Developers</a>
     */
    fun setCursiveFontFamily(value: String?) = this.apply { mCursiveFontFamily = value }

    /**
     * @see android.webkit.WebSettings.setDatabaseEnabled
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebSettings#setDatabaseEnabled">Android Developers</a>
     */
    fun setDatabaseEnabled(value: Boolean?) = this.apply { mDatabaseEnabled = value }

    /**
     * @see android.webkit.WebSettings.setDefaultFixedFontSize
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebSettings#setDefaultFixedFontSize">Android Developers</a>
     */
    fun setDefaultFixedFontSize(value: Int?) = this.apply { mDefaultFixedFontSize = value }

    /**
     * @see android.webkit.WebSettings.setDefaultFontSize
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebSettings#setDefaultFontSize">Android Developers</a>
     */
    fun setDefaultFontSize(value: Int?) = this.apply { mDefaultFontSize = value }

    /**
     * @see android.webkit.WebSettings.setDefaultTextEncodingName
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebSettings#setDefaultTextEncodingName">Android Developers</a>
     */
    fun setDefaultTextEncodingName(value: String?) = this.apply { mDefaultTextEncodingName = value }

    /**
     * @see android.webkit.WebSettings.setDisabledActionModeMenuItems
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebSettings#setDisabledActionModeMenuItems">Android Developers</a>
     */
    @RequiresApi(24)
    fun setDisabledActionModeMenuItems(@MenuItemsType value: Int?) = this.apply { mDisabledActionModeMenuItems = value }

    /**
     * @see android.webkit.WebSettings.setDisplayZoomControls
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebSettings#setDisplayZoomControls">Android Developers</a>
     */
    fun setDisplayZoomControls(value: Boolean?) = this.apply { mDisplayZoomControls = value }

    /**
     * @see android.webkit.WebSettings.setDomStorageEnabled
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebSettings#setDomStorageEnabled">Android Developers</a>
     */
    fun setDomStorageEnabled(value: Boolean?) = this.apply { mDomStorageEnabled = value }

    /**
     * @see android.webkit.WebSettings.setFantasyFontFamily
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebSettings#setFantasyFontFamily">Android Developers</a>
     */
    fun setFantasyFontFamily(value: String?) = this.apply { mFantasyFontFamily = value }

    /**
     * @see android.webkit.WebSettings.setFixedFontFamily
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebSettings#setFixedFontFamily">Android Developers</a>
     */
    fun setFixedFontFamily(value: String?) = this.apply { mFixedFontFamily = value }

    /**
     * @see android.webkit.WebSettings.setForceDark
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebSettings#setForceDark">Android Developers</a>
     */
    @RequiresApi(29)
    fun setForceDark(@ForceDarkType value: Int?) = this.apply { mForceDark = value }

    /**
     * @see android.webkit.WebSettings.setGeolocationEnabled
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebSettings#setGeolocationEnabled">Android Developers</a>
     */
    fun setGeolocationEnabled(value: Boolean?) = this.apply { mGeolocationEnabled = value }

    /**
     * @see android.webkit.WebSettings.setJavaScriptCanOpenWindowsAutomatically
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebSettings#setJavaScriptCanOpenWindowsAutomatically">Android Developers</a>
     */
    fun setJavaScriptCanOpenWindowsAutomatically(value: Boolean?) = this.apply { mJavaScriptCanOpenWindowsAutomatically = value }

    /**
     * @see android.webkit.WebSettings.setJavaScriptEnabled
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebSettings#setJavaScriptEnabled">Android Developers</a>
     */
    fun setJavaScriptEnabled(value: Boolean?) = this.apply { mJavaScriptEnabled = value }

    /**
     * @see android.webkit.WebSettings.setLayoutAlgorithm
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebSettings#setLayoutAlgorithm">Android Developers</a>
     */
    fun setLayoutAlgorithm(value: LayoutAlgorithm?) = this.apply { mLayoutAlgorithm = value }

    /**
     * @see android.webkit.WebSettings.setLoadWithOverviewMode
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebSettings#setLoadWithOverviewMode">Android Developers</a>
     */
    fun setLoadWithOverviewMode(value: Boolean?) = this.apply { mLoadWithOverviewMode = value }

    /**
     * @see android.webkit.WebSettings.setLoadsImagesAutomatically
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebSettings#setLoadsImagesAutomatically">Android Developers</a>
     */
    fun setLoadsImagesAutomatically(value: Boolean?) = this.apply { mLoadsImagesAutomatically = value }

    /**
     * @see android.webkit.WebSettings.setMediaPlaybackRequiresUserGesture
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebSettings#setMediaPlaybackRequiresUserGesture">Android Developers</a>
     */
    fun setMediaPlaybackRequiresUserGesture(value: Boolean?) = this.apply { mMediaPlaybackRequiresUserGesture = value }

    /**
     * @see android.webkit.WebSettings.setMinimumFontSize
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebSettings#setMinimumFontSize">Android Developers</a>
     */
    fun setMinimumFontSize(value: Int?) = this.apply { mMinimumFontSize = value }

    /**
     * @see android.webkit.WebSettings.setMinimumLogicalFontSize
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebSettings#setMinimumLogicalFontSize">Android Developers</a>
     */
    fun setMinimumLogicalFontSize(value: Int?) = this.apply { mMinimumLogicalFontSize = value }

    /**
     * @see android.webkit.WebSettings.setMixedContentMode
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebSettings#setMixedContentMode">Android Developers</a>
     */
    fun setMixedContentMode(@MixedContentModeType value: Int?) = this.apply { mMixedContentMode = value }

    /**
     * @see android.webkit.WebSettings.setNeedInitialFocus
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebSettings#setNeedInitialFocus">Android Developers</a>
     */
    fun setNeedInitialFocus(value: Boolean?) = this.apply { mNeedInitialFocus = value }

    /**
     * @see android.webkit.WebSettings.setOffscreenPreRaster
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebSettings#setOffscreenPreRaster">Android Developers</a>
     */
    @RequiresApi(23)
    fun setOffscreenPreRaster(value: Boolean?) = this.apply { mOffscreenPreRaster = value }

    /**
     * @see android.webkit.WebSettings.setSafeBrowsingEnabled
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebSettings#setSafeBrowsingEnabled">Android Developers</a>
     */
    @RequiresApi(26)
    fun setSafeBrowsingEnabled(value: Boolean?) = this.apply { mSafeBrowsingEnabled = value }

    /**
     * @see android.webkit.WebSettings.setSansSerifFontFamily
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebSettings#setSansSerifFontFamily">Android Developers</a>
     */
    fun setSansSerifFontFamily(value: String?) = this.apply { mSansSerifFontFamily = value }

    /**
     * @see android.webkit.WebSettings.setSerifFontFamily
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebSettings#setSerifFontFamily">Android Developers</a>
     */
    fun setSerifFontFamily(value: String?) = this.apply { mSerifFontFamily = value }

    /**
     * @see android.webkit.WebSettings.setStandardFontFamily
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebSettings#setStandardFontFamily">Android Developers</a>
     */
    fun setStandardFontFamily(value: String?) = this.apply { mStandardFontFamily = value }

    /**
     * @see android.webkit.WebSettings.setSupportMultipleWindows
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebSettings#setSupportMultipleWindows">Android Developers</a>
     */
    fun setSupportMultipleWindows(value: Boolean?) = this.apply { mSupportMultipleWindows = value }

    /**
     * @see android.webkit.WebSettings.setSupportZoom
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebSettings#setSupportZoom">Android Developers</a>
     */
    fun setSupportZoom(value: Boolean?) = this.apply { mSupportZoom = value }

    /**
     * @see android.webkit.WebSettings.setTextZoom
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebSettings#setTextZoom">Android Developers</a>
     */
    fun setTextZoom(value: Int?) = this.apply { mTextZoom = value }

    /**
     * @see android.webkit.WebSettings.setUserAgentString
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebSettings#setUserAgentString">Android Developers</a>
     */
    fun setUserAgentString(value: String?) = this.apply { mUserAgentString = value }

    /**
     * @see android.webkit.WebSettings.setUseWideViewPort
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebSettings#setUseWideViewPort">Android Developers</a>
     */
    fun setUseWideViewPort(value: Boolean?) = this.apply { mUseWideViewPort = value }

    /**
     * @see android.webkit.WebView.setWebChromeClient
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebView#setWebChromeClient">Android Developers</a>
     */
    fun setWebChromeClient(client: WebChromeClient?) = this.apply { mWebChromeClient = client }

    /**
     * @see android.webkit.WebView.setWebViewClient
     * @see <a href="https://developer.android.com/reference/kotlin/android/webkit/WebView#setWebViewClient">Android Developers</a>
     */
    fun setWebViewClient(client: WebViewClientCompat?) = this.apply { mWebViewClient = client }
}
