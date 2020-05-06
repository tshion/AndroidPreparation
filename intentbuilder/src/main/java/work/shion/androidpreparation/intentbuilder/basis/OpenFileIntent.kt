package work.shion.androidpreparation.intentbuilder.basis

import android.content.ContentResolver
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore

class OpenFileIntent : SupplierIntent() {

    companion object {

        /**
         * Parse a image if exists
         *
         * ### Example
         * ``` kotlin
         * override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
         *     OpenFileIntent.parseImage(contentResolver, data)
         *         ?.also { findViewById<ImageView>(ID).setImageBitmap(it) }
         * }
         * ```
         */
        fun parseImage(resolver: ContentResolver, resultIntent: Intent?): Bitmap? = runCatching {
            val imageUri = parseUri(resultIntent) ?: return null
            if (Build.VERSION_CODES.P <= Build.VERSION.SDK_INT) {
                imageUri.let { ImageDecoder.createSource(resolver, it) }
                        .let { ImageDecoder.decodeBitmap(it) }
            } else {
                imageUri.let { MediaStore.Images.Media.getBitmap(resolver, it) }
            }
        }.getOrNull()

        /**
         * Parse a video uri if exists
         *
         * ### Example
         * ``` kotlin
         * override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
         *     val uri = OpenFileIntent.parseUri(data)
         * }
         * ```
         */
        fun parseUri(resultIntent: Intent?): Uri? = resultIntent?.data
    }


    init {
        action = ACTION_OPEN_DOCUMENT
        addCategory(CATEGORY_OPENABLE)
    }
}
