package work.shion.androidpreparation.intentbuilder

import android.net.Uri
import android.webkit.URLUtil
import work.shion.androidpreparation.intentbuilder.basis.IntentBuilder
import work.shion.androidpreparation.intentbuilder.basis.TakePictureIntent

/**
 * Capture a picture
 *
 * ### Example1
 * ``` kotlin
 * private var publishedIntent: TakePictureIntent? = null
 *
 * override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
 *     TakePictureIntent.parseThumbnail(data)
 *         ?.also { findViewById<ImageView>(ID_FOR_THUMBNAIL).setImageBitmap(it) }
 *     publishedIntent?.parseImage(contentResolver)
 *         ?.also { findViewById<ImageView>(ID_FOR_MAIN).setImageBitmap(it) }
 * }
 *
 * fun launch() {
 *     TakePictureIntentBuilder()
 *         .apply { outputUri = FileProvider.getUriForFile(context, authority, file)}
 *         .build()
 *         ?.also { publishedIntent = it }
 *         ?.start(from, REQUEST_CODE)
 * ```
 *
 * ### Example2
 * ``` kotlin
 * private var publishedIntent: TakePictureIntent? = null
 *
 * override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
 *     TakePictureIntent.parseThumbnail(data)
 *         ?.also { findViewById<ImageView>(ID_FOR_THUMBNAIL).setImageBitmap(it) }
 *     publishedIntent?.parseImage(contentResolver)
 *         ?.also { findViewById<ImageView>(ID_FOR_MAIN).setImageBitmap(it) }
 * }
 *
 * fun launch() {
 *     TakePictureIntentBuilder()
 *         .outputUri(FileProvider.getUriForFile(context, authority, file))
 *         .build()
 *         ?.also { publishedIntent = it }
 *         ?.start(from, REQUEST_CODE)
 * ```
 *
 * ### References
 * * [Common Intents | Android Developers](https://developer.android.com/guide/components/intents-common#ImageCapture)
 */
class TakePictureIntentBuilder : IntentBuilder<TakePictureIntent>() {

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
    override fun build() = outputUri?.let { TakePictureIntent(it) }
}
