package work.shion.androidpreparation.intentbuilder

import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import android.widget.Button

class OpenMailerSample : BaseActivity() {

    companion object {
        val testData = mapOf(
                "Empty" to OpenMailerIntentBuilder(),
                "Success1" to OpenMailerIntentBuilder().apply {
                    bcc.add("bcc1@example.test")
                    bcc.add("bcc2@example.test")
                    cc.add("cc1@example.test")
                    cc.add("cc2@example.test")
                    cc.add("cc2@example.test")
                    subject = "subject"
                    text = "mail body text"
                    to.add("to1@example.test")
                    to.add("to2@example.test")
                }
        )
    }


    override fun setupUI(root: ViewGroup): ViewGroup {
        testData.forEach { (key, value) ->
            val from = this@OpenMailerSample
            root.addView(Button(from).apply {
                setOnClickListener { value.build().start(from) }
                text = key
            }, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        }

        return root
    }
}
