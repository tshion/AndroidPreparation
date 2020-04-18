package work.shion.androidpreparation.webviewbuilder

import android.Manifest
import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import permissions.dispatcher.ktx.withPermissionsCheck

class GeoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.geo)

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
    }
}
