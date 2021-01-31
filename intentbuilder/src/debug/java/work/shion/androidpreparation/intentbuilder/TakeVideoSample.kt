package work.shion.androidpreparation.intentbuilder

import android.content.Intent
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import android.widget.VideoView
import work.shion.androidpreparation.intentbuilder.basis.TakeVideoIntent

class TakeVideoSample : BaseActivity() {

    companion object {
        private const val MOVIE_ID = 1000
        private const val REQUEST_CODE = 1000
        val testData = mapOf(
                "Empty" to ""
        )
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            REQUEST_CODE -> {
                if (resultCode != RESULT_OK) {
                    return
                }

                TakeVideoIntent.parseVideoUri(data)?.also {
                    findViewById<VideoView>(MOVIE_ID).apply {
                        setVideoURI(it)
                        start()
                    }
                }
            }
            else -> super.onActivityResult(requestCode, resultCode, data)
        }
    }


    override fun setupUI(root: ViewGroup): ViewGroup {
        val from = this@TakeVideoSample

        testData.forEach { (key, _) ->
            root.addView(Button(from).apply {
                setOnClickListener {
                    TakeVideoIntentBuilder()
                            .build()
                            .start(from, REQUEST_CODE)
                }
                text = key
            }, MATCH_PARENT, WRAP_CONTENT)
        }

        root.addView(VideoView(from).apply {
            id = MOVIE_ID
        }, MATCH_PARENT, WRAP_CONTENT)

        return root
    }
}
