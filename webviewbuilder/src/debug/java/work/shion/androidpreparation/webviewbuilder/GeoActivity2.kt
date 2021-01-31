package work.shion.androidpreparation.webviewbuilder

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import permissions.dispatcher.ktx.LocationPermission
import permissions.dispatcher.ktx.constructLocationPermissionRequest

class GeoActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.geo2)

        val target = (supportFragmentManager.findFragmentById(R.id.webview_target2) as? WebViewWithAutoDiscard)
                ?.webView
                ?: return

        target.apply {
            requestFocus()
            requestFocusFromTouch()
        }

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
                .into(target)
                .loadUrl("https://www.google.co.jp/maps")
    }
}
