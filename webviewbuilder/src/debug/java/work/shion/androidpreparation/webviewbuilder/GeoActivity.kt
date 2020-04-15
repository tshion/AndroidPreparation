package work.shion.androidpreparation.webviewbuilder

import android.Manifest
import android.os.Bundle
import android.webkit.GeolocationPermissions
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import permissions.dispatcher.NeedsPermission
import permissions.dispatcher.RuntimePermissions

@RuntimePermissions
class GeoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.geo)

        WebViewBuilder()
                .geolocationEnabled(true)
                .javaScriptEnabled(true)
                .onGeolocationPermissionsShowPrompt { origin, callback ->
                    invokeGeoWithPermissionCheck(origin, callback)
                }
                .into(findViewById<WebView>(R.id.webview_target))
                .loadUrl("https://www.google.co.jp/maps")
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        onRequestPermissionsResult(requestCode, grantResults)
    }


    @NeedsPermission(Manifest.permission.ACCESS_FINE_LOCATION)
    fun invokeGeo(origin: String?, callback: GeolocationPermissions.Callback?) {
        callback?.invoke(origin, true, false)
    }
}
