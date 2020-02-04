package work.shion.androidpreparation.intentbuilder

import android.app.Activity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams
import android.widget.Button
import android.widget.LinearLayout
import java.util.*

class CalendarEventSample : Activity() {

    companion object {
        const val paramEmpty = "empty"
        const val paramFull = "full"
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

        root.addView(Button(this).apply {
            setOnClickListener {
                val (start, finish) = Calendar.getInstance().apply {
                    time = Date()
                }.let {
                    Pair(it.time, it.apply { add(Calendar.DAY_OF_MONTH, 1) }.time)
                }

                CalendarEventIntentBuilder().apply {
                    setBeginTime(start)
                    description = "テスト用の説明"
                    emailList.add("1234@intent.test")
                    emailList.add("1234@intent.test")
                    emailList.add("5678@intent.test")
                    setEndTime(finish)
                    isAllDay = true
                    location = "テスト用の場所"
                    title = "テスト用のタイトル"
                }.build().launch(this@CalendarEventSample)
            }
            text = paramFull
        }, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)

        setContentView(root)
    }
}
