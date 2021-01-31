package work.shion.androidpreparation.intentbuilder.basis

import android.content.Intent
import android.net.Uri
import android.provider.MediaStore

class TakeVideoIntent : SupplierIntent() {

    companion object {

        /**
         * Parse a video uri if exists
         *
         * ### Example
         * ``` kotlin
         * override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
         *     TakeVideoIntent.parseVideoUri(data)
         *         ?.also { findViewById<VideoView>(ID).setVideoURI(it) }
         * }
         * ```
         */
        fun parseVideoUri(resultIntent: Intent?): Uri? = resultIntent?.data
    }


    init {
        action = MediaStore.ACTION_VIDEO_CAPTURE
    }
}
