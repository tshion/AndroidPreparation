package work.shion.androidpreparation.intentbuilder.basis

import android.content.ContentResolver
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore

class TakePictureIntent(
        val imageUri: Uri
) : SupplierIntent() {

    companion object {

        /**
         * Parse a thumbnail if exists
         *
         * ### Example
         * ``` kotlin
         * override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
         *     TakePictureIntent.parseThumbnail(data)
         *         ?.let{ findViewById<ImageView>(ID).setImageBitmap(it) }
         * }
         * ```
         */
        fun parseThumbnail(resultIntent: Intent?): Bitmap? = resultIntent
                ?.getParcelableExtra("data")
    }


    init {
        action = MediaStore.ACTION_IMAGE_CAPTURE
        addFlags(FLAG_GRANT_WRITE_URI_PERMISSION)
        putExtra(MediaStore.EXTRA_OUTPUT, imageUri)
    }


    /**
     * Parse a image if exists
     *
     * ### Example
     * ``` kotlin
     * private var publishedIntent: TakePictureIntent? = null
     *
     * override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
     *     publishedIntent?.parseImage(contentResolver)
     *         ?.also { findViewById<ImageView>(ID).setImageBitmap(it) }
     * }
     * ```
     */
    fun parseImage(resolver: ContentResolver): Bitmap? = if (Build.VERSION_CODES.P <= Build.VERSION.SDK_INT) {
        runCatching {
            imageUri.let { ImageDecoder.createSource(resolver, it) }
                    .let { ImageDecoder.decodeBitmap(it) }
        }.getOrNull()
    } else {
        imageUri.let { MediaStore.Images.Media.getBitmap(resolver, it) }
    }
}
