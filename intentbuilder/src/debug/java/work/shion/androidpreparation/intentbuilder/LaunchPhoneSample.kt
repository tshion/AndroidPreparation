package work.shion.androidpreparation.intentbuilder

import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import android.widget.Button

class LaunchPhoneSample : BaseActivity() {

    companion object {
        val testEmpty = Pair("Empty", "")
        val test1 = Pair("Test 1", "00011112222")
    }


    override fun setupUI(root: ViewGroup): ViewGroup {
        root.addView(Button(this).apply {
            setOnClickListener {
                LaunchPhoneIntentBuilder().apply {
                    setPhoneNumber(testEmpty.second)
                }.build().start(this@LaunchPhoneSample)
            }
            text = testEmpty.first
        }, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)

        root.addView(Button(this).apply {
            setOnClickListener {
                LaunchPhoneIntentBuilder().apply {
                    setPhoneNumber(test1.second)
                }.build().start(this@LaunchPhoneSample)
            }
            text = test1.first
        }, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)

        return root
    }
}
