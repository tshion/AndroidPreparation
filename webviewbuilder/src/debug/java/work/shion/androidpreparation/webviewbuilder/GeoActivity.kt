package work.shion.androidpreparation.webviewbuilder

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import permissions.dispatcher.ktx.LocationPermission
import permissions.dispatcher.ktx.constructLocationPermissionRequest

class GeoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.geo)

        WebViewBuilder()
                .geolocationEnabled(true)
                .javaScriptEnabled(true)
                .onGeolocationPermissionsShowPrompt { origin, callback ->
                    constructLocationPermissionRequest(
                            LocationPermission.FINE,
                            onNeverAskAgain = { callback?.invoke(origin, false, false) },
                            onPermissionDenied = { callback?.invoke(origin, false, false) },
                            onShowRationale = { it.proceed() }
                    ) {
                        callback?.invoke(origin, true, false)
                    }.launch()
                }
                .into(findViewById<WebView>(R.id.webview_target))
                .loadUrl("https://www.google.co.jp/maps")
    }
}
