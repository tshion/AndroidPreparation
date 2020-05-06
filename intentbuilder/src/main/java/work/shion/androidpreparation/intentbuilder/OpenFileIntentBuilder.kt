package work.shion.androidpreparation.intentbuilder

import android.content.Intent.EXTRA_ALLOW_MULTIPLE
import android.content.Intent.EXTRA_MIME_TYPES
import androidx.collection.ArraySet
import androidx.collection.arraySetOf
import work.shion.androidpreparation.intentbuilder.basis.IntentBuilder
import work.shion.androidpreparation.intentbuilder.basis.OpenFileIntent

/**
 * Open a specific type of file
 *
 * ### Example1
 * ``` kotlin
 * override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
 *     OpenFileIntent.parseImage(contentResolver, data)
 *         ?.also { findViewById<ImageView>(ID_FOR_THUMBNAIL).setImageBitmap(it) }
 * }
 *
 * fun launch() {
 *     OpenFileIntentBuilder()
 *         .apply {
 *             isMultiple = true
 *             mimeTypes.add("image/\*")
 *         }
 *         .build()
 *         ?.start(from, REQUEST_CODE)
 * ```
 *
 * ### Example2
 * ``` kotlin
 * override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
 *     OpenFileIntent.parseImage(contentResolver, data)
 *         ?.also { findViewById<ImageView>(ID_FOR_THUMBNAIL).setImageBitmap(it) }
 * }
 *
 * fun launch() {
 *     OpenFileIntentBuilder()
 *         .appendMimeType("image/\*")
 *         .isMultiple(true)
 *         .build()
 *         ?.start(from, REQUEST_CODE)
 * ```
 *
 * ### References
 * * [Common Intents | Android Developers](https://developer.android.com/guide/components/intents-common#OpenFile)
 */
class OpenFileIntentBuilder : IntentBuilder<OpenFileIntent>() {

    var isMultiple = false
    val mimeTypes: ArraySet<String> = arraySetOf()


    fun appendMimeType(input: String) = apply { mimeTypes.add(input) }
    fun isMultiple(input: Boolean?) = apply { isMultiple = input ?: false }
    fun removeMimeType(input: String) = apply { mimeTypes.remove(input) }


    /**
     * Generate an intent by builder's settings.
     */
    override fun build(): OpenFileIntent? {
        if (mimeTypes.isNullOrEmpty()) {
            return null
        }

        return OpenFileIntent().apply {
            putExtra(EXTRA_ALLOW_MULTIPLE, isMultiple)

            if (mimeTypes.size == 1) {
                type = mimeTypes.elementAt(0)
            } else {
                putExtra(EXTRA_MIME_TYPES, mimeTypes.toArray())
                type = "*/*"
            }
        }
    }
}
