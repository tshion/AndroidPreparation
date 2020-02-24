package work.shion.androidpreparation.intentbuilder

import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import android.widget.Button

@Deprecated("In development")
class SearchWebSample : BaseActivity() {

    companion object {
        const val queryEmpty = ""
        const val queryEnglish = "Android"
        const val queryJapanese = "アンドロイド"
        val queryNull = null
        const val queryNullTitle = "Null"
    }


    override fun setupUI(root: ViewGroup): ViewGroup {
        root.addView(Button(this).apply {
            setOnClickListener {
                SearchWebIntentBuilder().apply {
                    query = queryEmpty
                }.build().start(this@SearchWebSample)
            }
            text = queryEmpty
        }, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)

        root.addView(Button(this).apply {
            setOnClickListener {
                SearchWebIntentBuilder().apply {
                    query = queryEnglish
                }.build().start(this@SearchWebSample)
            }
            text = queryEnglish
        }, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)

        root.addView(Button(this).apply {
            setOnClickListener {
                SearchWebIntentBuilder().apply {
                    query = queryJapanese
                }.build().start(this@SearchWebSample)
            }
            text = queryJapanese
        }, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)

        root.addView(Button(this).apply {
            setOnClickListener {
                SearchWebIntentBuilder().apply {
                    query = queryNull
                }.build().start(this@SearchWebSample)
            }
            text = queryNullTitle
        }, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)

        return root
    }
}
