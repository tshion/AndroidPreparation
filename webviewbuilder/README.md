# AndroidPreparation.WebViewBuilder
Helper for setting parameters of webview.

## Quick Start
### How to get
You write like this at build.gradle of a module.

``` gradle
dependencies {
    ......
    implementation "work.shion.androidpreparation:webviewbuilder:x.x.x"
}
```

If you want to get by maven, please add like this at build.gradle of a project.

``` gradle
repositories {
    ......
    maven {
        url 'https://dl.bintray.com/shion/maven'
    }
}
```

If you want to know a library version, please check [Bintray site][maven_webviewbuilder] or [CHANGELOG](./CHANGELOG.md).

### How to use
Now, you wrote like this at layout xml file.

``` xml
<FrameLayout ......>
    <WebView
        android:id="@+id/webview_target"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:focusable="true"
        android:focusableInTouchMode="true">

        <requestFocus />
    </WebView>
</FrameLayout>
```

If you set these properties, you can write like this.

* running javascript
* using geolocation(if permitted)

``` kotlin
WebViewBuilder()
        .geolocationEnabled(true)
        .javaScriptEnabled(true)
        .onGeolocationPermissionsShowPrompt { origin, callback ->
            withPermissionsCheck(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    onNeverAskAgain = { callback?.invoke(origin, false, false) },
                    onPermissionDenied = { callback?.invoke(origin, false, false) },
                    onShowRationale = { it.proceed() }
            ) {
                callback?.invoke(origin, true, false)
            }
        }
        .into(findViewById<WebView>(R.id.webview_target))
        .loadUrl("https://www.google.co.jp/maps")
```

Note: This sample code use [permissionsdispatcher-ktx](https://github.com/permissions-dispatcher/PermissionsDispatcher/tree/master/ktx).



## Links
### Blogs
* [WebViewBuilder 1.0.x のリリースノート](https://mokumokulog.netlify.com/tech/20200418040026)

### Products
* [GitHub][gh_webviewbuilder]
* [Maven][maven_webviewbuilder]

### References
* [WebChromeClient | Android Developers](https://developer.android.com/reference/kotlin/android/webkit/WebChromeClient)
* [WebSettings | Android Developers](https://developer.android.com/reference/kotlin/android/webkit/WebSettings)
* [WebSettingsCompat | Android Developers](https://developer.android.com/reference/androidx/webkit/WebSettingsCompat)
* [WebView | Android Developers](https://developer.android.com/reference/kotlin/android/webkit/WebView)
* [WebViewClient | Android Developers](https://developer.android.com/reference/kotlin/android/webkit/WebViewClient)
* [WebViewClientCompat | Android Developers](https://developer.android.com/reference/androidx/webkit/WebViewClientCompat)
* [WebViewFeature | Android Developers](https://developer.android.com/reference/androidx/webkit/WebViewFeature)



[gh_webviewbuilder]: https://github.com/TentaShion/AndroidPreparation/blob/released/webviewbuilder
[maven_webviewbuilder]: https://bintray.com/shion/maven/work.shion.androidpreparation.webviewbuilder
