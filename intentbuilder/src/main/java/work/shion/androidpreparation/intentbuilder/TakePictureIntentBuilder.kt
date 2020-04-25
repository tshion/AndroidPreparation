package work.shion.androidpreparation.intentbuilder

import android.net.Uri
import android.provider.MediaStore
import android.webkit.URLUtil
import work.shion.androidpreparation.intentbuilder.basis.IntentBuilder
import work.shion.androidpreparation.intentbuilder.basis.SupplierIntent

/**
 * Capture a picture
 *
 * ### Example1
 * ``` kotlin
 * TakePictureIntentBuilder().apply {
 *     outputUri = FileProvider.getUriForFile(context, authority, file)
 * }.build()?.start(from, REQUEST_CODE)
 * ```
 *
 * ### Example2
 * ``` kotlin
 * TakePictureIntentBuilder()
 *     .outputUri(FileProvider.getUriForFile(context, authority, file))
 *     .build()
 *     ?.start(from, REQUEST_CODE)
 * ```
 *
 * ### References
 * * [Common Intents | Android Developers](https://developer.android.com/guide/components/intents-common#ImageCapture)
 */
class TakePictureIntentBuilder : IntentBuilder<SupplierIntent>() {

    var outputUri: Uri? = null
        set(value) {
            if (value == null || URLUtil.isContentUrl(value.toString())) {
                field = value
            }
        }


    fun outputUri(input: Uri?) = apply { outputUri = input }


    /**
     * Generate an intent by builder's settings.
     */
    override fun build() = outputUri?.let { uri ->
        SupplierIntent().apply {
            action = MediaStore.ACTION_IMAGE_CAPTURE
            putExtra(MediaStore.EXTRA_OUTPUT, uri)
        }
    }
}
