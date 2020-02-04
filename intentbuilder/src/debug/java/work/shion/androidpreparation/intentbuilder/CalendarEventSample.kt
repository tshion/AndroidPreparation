package work.shion.androidpreparation.intentbuilder

import android.app.Activity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams
import android.widget.Button
import android.widget.LinearLayout

class CalendarEventSample : Activity() {

    companion object {
        const val paramEmpty = "empty"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
        }

        root.addView(Button(this).apply {
            setOnClickListener {
                CalendarEventIntentBuilder().build()
                        .launch(this@CalendarEventSample)
            }
            text = paramEmpty
        }, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)

        setContentView(root)
    }
}
