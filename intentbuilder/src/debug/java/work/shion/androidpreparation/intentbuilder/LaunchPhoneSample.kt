package work.shion.androidpreparation.intentbuilder

import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import android.widget.Button

class LaunchPhoneSample : BaseActivity() {

    companion object {
        val testEmpty = Pair("Empty", "")
        val test1 = Pair("2125551212", "2125551212")
        val test2 = Pair("(212) 555 1212", "(212) 555 1212")
    }


    override fun setupUI(root: ViewGroup): ViewGroup {
        root.addView(Button(this).apply {
            setOnClickListener {
                LaunchPhoneIntentBuilder().apply {
                    phoneNumber = testEmpty.second
                }.build().start(this@LaunchPhoneSample)
            }
            text = testEmpty.first
        }, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)

        root.addView(Button(this).apply {
            setOnClickListener {
                LaunchPhoneIntentBuilder().apply {
                    phoneNumber = test1.second
                }.build().start(this@LaunchPhoneSample)
            }
            text = test1.first
        }, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)

        root.addView(Button(this).apply {
            setOnClickListener {
                LaunchPhoneIntentBuilder().apply {
                    phoneNumber = test2.second
                }.build().start(this@LaunchPhoneSample)
            }
            text = test2.first
        }, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)

        return root
    }
}
