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

If you want to know a library version, please check [Bintray site][maven_webviewbuilder].

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
val chromeClient = WebChromeClientBuilder()
    .setOnGeolocationPermissionsShowPrompt { origin, callback ->
        callback?.invoke(origin, true, false)
    }
    .build()
WebViewBuilder()
    .setGeolocationEnabled(true)
    .setJavaScriptEnabled(true)
    .setWebChromeClient(chromeClient)
    .into(webview_target)
    .loadUrl("https://mokumokulog.netlify.com/")
```



## Links
### Products
* [GitHub][gh_webviewbuilder]
* [Maven][maven_webviewbuilder]

### References
* [WebChromeClient | Android Developers](https://developer.android.com/reference/kotlin/android/webkit/WebChromeClient)
* [WebSettings | Android Developers](https://developer.android.com/reference/kotlin/android/webkit/WebSettings)
* [WebView | Android Developers](https://developer.android.com/reference/kotlin/android/webkit/WebView)
* [WebViewClient | Android Developers](https://developer.android.com/reference/kotlin/android/webkit/WebViewClient)



[gh_webviewbuilder]: https://github.com/TentaShion/AndroidPreparation/blob/master/webviewbuilder
[maven_webviewbuilder]: https://bintray.com/shion/maven/work.shion.androidpreparation.webviewbuilder
