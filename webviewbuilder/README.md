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

If you want to get a beta-release, please add like this at build.gradle of a project.

``` gradle
repositories {
    ......
    maven {
        url 'https://dl.bintray.com/shion/maven'
    }
}
```

If you want to know a library version, please check [Bintray site][maven_webviewbuilder].

※Be careful, I publish a beta-release by Maven, a product-release by jCenter.



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
