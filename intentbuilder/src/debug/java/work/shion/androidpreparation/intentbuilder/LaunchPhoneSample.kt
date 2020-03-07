package work.shion.androidpreparation.intentbuilder

import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import android.widget.Button

class LaunchPhoneSample : BaseActivity() {

    companion object {
        val testData = mapOf(
                "Empty" to "",
                "Success1" to "2125551212",
                "Success2" to "(212) 555 1212",
                "Unknown1" to "abcdef",
                "Unknown2" to "あいうえお"
        )
    }


    override fun setupUI(root: ViewGroup): ViewGroup {
        testData.forEach { (key, value) ->
            val from = this@LaunchPhoneSample
            root.addView(Button(from).apply {
                setOnClickListener {
                    val intent = LaunchPhoneIntentBuilder().apply {
                        phoneNumber = value
                    }.build()
                    intent.start(from)
                }
                text = key
            }, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        }

        return root
    }
}
