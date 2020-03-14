package work.shion.androidpreparation.intentbuilder

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import android.widget.Button
import permissions.dispatcher.NeedsPermission
import permissions.dispatcher.RuntimePermissions

@RuntimePermissions
class CallVoiceMailSample : BaseActivity() {

    companion object {
        val testData = mapOf(
                "Empty" to "",
                "Success1" to "2125551212",
                "Success2" to "(212) 555 1212",
                "Unknown1" to "abcdef",
                "Unknown2" to "あいうえお"
        )
    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        onRequestPermissionsResult(requestCode, grantResults)
    }


    override fun setupUI(root: ViewGroup): ViewGroup {
        testData.forEach { (key, value) ->
            val from = this@CallVoiceMailSample
            root.addView(Button(from).apply {
                setOnClickListener { launchWithPermissionCheck(from, value) }
                text = key
            }, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        }

        return root
    }


    @NeedsPermission(Manifest.permission.CALL_PHONE)
    @SuppressLint("MissingPermission")
    fun launch(from: Activity, value: String) {
        val intent = CallVoiceMailIntentBuilder().apply {
            phoneNumber = value
        }.build()
        intent.start(from)
    }
}
