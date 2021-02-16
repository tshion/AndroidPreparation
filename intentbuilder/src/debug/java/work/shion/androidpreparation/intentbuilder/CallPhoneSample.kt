package work.shion.androidpreparation.intentbuilder

import android.Manifest
import android.annotation.SuppressLint
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import android.widget.Button
import permissions.dispatcher.ktx.constructPermissionsRequest

class CallPhoneSample : BaseActivity() {

    companion object {
        val testData = mapOf(
            "Empty" to "",
            "Success1" to "2125551212",
            "Success2" to "(212) 555 1212",
            "Unknown1" to "abcdef",
            "Unknown2" to "あいうえお"
        )
    }


    @SuppressLint("MissingPermission")
    override fun setupUI(root: ViewGroup): ViewGroup {
        testData.forEach { (key, value) ->
            val from = this@CallPhoneSample
            root.addView(Button(from).apply {
                setOnClickListener {
                    constructPermissionsRequest(
                        Manifest.permission.CALL_PHONE
                    ) {
                        val intent = CallPhoneIntentBuilder()
                            .phoneNumber(value)
                            .build()
                        intent.start(from)
                    }.launch()
                }
                text = key
            }, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        }

        return root
    }
}
