package work.shion.androidpreparation.intentbuilder

import android.content.Intent
import android.net.Uri
import android.os.Environment
import android.provider.MediaStore
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.core.content.FileProvider
import java.io.File

class TakePictureSample : BaseActivity() {

    companion object {
        private val IMAGE_ID = 1000
        private val REQUEST_CODE = 1000
        val testData = mapOf(
                "Empty" to ""
        )
    }

    var pictureUri: Uri? = null


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            REQUEST_CODE -> {
                if (resultCode != RESULT_OK) {
                    return
                }
                MediaStore.Images.Media.getBitmap(contentResolver, pictureUri).also {
                    findViewById<ImageView>(IMAGE_ID).setImageBitmap(it)
                }
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
                    ).also {
                        pictureUri = FileProvider.getUriForFile(
                                from,
                                "${BuildConfig.LIBRARY_PACKAGE_NAME}.test.fileprovider",
                                it
                        )
                    }

                    TakePictureIntentBuilder()
                            .outputUri(pictureUri)
                            .build()
                            ?.start(from, REQUEST_CODE)
                }
                text = key
            }, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        }

        root.addView(ImageView(from).apply {
            adjustViewBounds = true
            id = IMAGE_ID
        }, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)

        return root
    }
}
