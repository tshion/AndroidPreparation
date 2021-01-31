package work.shion.androidpreparation.intentbuilder

import android.content.Intent
import android.graphics.Color
import android.os.Environment
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.FileProvider
import work.shion.androidpreparation.intentbuilder.basis.TakePictureIntent
import java.io.File

class TakePictureSample : BaseActivity() {

    companion object {
        private val IMAGE_ID_MAIN = 1000
        private val IMAGE_ID_THUMBNAIL = 2000
        private val REQUEST_CODE = 1000
        val testData = mapOf(
                "Empty" to ""
        )
    }


    var publishedIntent: TakePictureIntent? = null


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            REQUEST_CODE -> {
                if (resultCode != RESULT_OK) {
                    return
                }

                TakePictureIntent.parseThumbnail(data)?.also {
                    findViewById<ImageView>(IMAGE_ID_THUMBNAIL).setImageBitmap(it)
                }
                publishedIntent?.parseImage(contentResolver)
                        ?.also { findViewById<ImageView>(IMAGE_ID_MAIN).setImageBitmap(it) }
            }
            else -> super.onActivityResult(requestCode, resultCode, data)
        }
    }


    override fun setupUI(root: ViewGroup): ViewGroup {
        val from = this@TakePictureSample

        testData.forEach { (key, _) ->
            root.addView(Button(from).apply {
                setOnClickListener {
                    File.createTempFile(
                            "${System.currentTimeMillis()}",
                            ".jpg",
                            getExternalFilesDir(Environment.DIRECTORY_PICTURES)
                    ).let {
                        FileProvider.getUriForFile(
                                from,
                                "${BuildConfig.LIBRARY_PACKAGE_NAME}.test.fileprovider",
                                it
                        )
                    }.let {
                        TakePictureIntentBuilder()
                                .outputUri(it)
                                .build()
                    }?.also {
                        publishedIntent = it
                    }?.start(from, REQUEST_CODE)
                }
                text = key
            }, MATCH_PARENT, WRAP_CONTENT)
        }

        LinearLayout(from).apply {
            layoutParams = LayoutParams(MATCH_PARENT, WRAP_CONTENT)
            minimumHeight = 100
            orientation = LinearLayout.HORIZONTAL
        }.also { subroot ->
            ImageView(from).apply {
                adjustViewBounds = true
                setBackgroundColor(Color.LTGRAY)
                id = IMAGE_ID_THUMBNAIL
                layoutParams = LinearLayout.LayoutParams(0, MATCH_PARENT, 1f)
            }.also { subroot.addView(it) }

            ImageView(from).apply {
                adjustViewBounds = true
                setBackgroundColor(Color.MAGENTA)
                id = IMAGE_ID_MAIN
                layoutParams = LinearLayout.LayoutParams(0, MATCH_PARENT, 1f)
            }.also { subroot.addView(it) }
        }.also { root.addView(it) }

        return root
    }
}
