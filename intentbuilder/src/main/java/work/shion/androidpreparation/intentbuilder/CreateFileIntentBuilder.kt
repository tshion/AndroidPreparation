package work.shion.androidpreparation.intentbuilder

import android.content.Intent.*
import androidx.collection.ArraySet
import androidx.collection.arraySetOf
import work.shion.androidpreparation.intentbuilder.basis.CreateFileIntent
import work.shion.androidpreparation.intentbuilder.basis.IntentBuilder

/**
 * Create a specific type of file
 *
 * ### Example1
 * ``` kotlin
 * override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
 *     CreateFileIntent.parseImage(contentResolver, data)
 *         ?.also { findViewById<ImageView>(ID_FOR_THUMBNAIL).setImageBitmap(it) }
 * }
 *
 * fun launch() {
 *     CreateFileIntentBuilder()
 *         .apply {
 *             mimeTypes.add("image/png")
 *             title = "image"
 *         }
 *         .build()
 *         ?.start(from, REQUEST_CODE)
 * ```
 *
 * ### Example2
 * ``` kotlin
 * override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
 *     CreateFileIntent.parseImage(contentResolver, data)
 *         ?.also { findViewById<ImageView>(ID_FOR_THUMBNAIL).setImageBitmap(it) }
 * }
 *
 * fun launch() {
 *     CreateFileIntentBuilder()
 *         .appendMimeType("image/png")
 *         .title("image")
 *         .build()
 *         ?.start(from, REQUEST_CODE)
 * ```
 *
 * ### References
 * * [Common Intents | Android Developers](https://developer.android.com/guide/components/intents-common#OpenFile)
 */
class CreateFileIntentBuilder : IntentBuilder<CreateFileIntent>() {

    @Deprecated("In development")
    var isMultiple = false

    val mimeTypes: ArraySet<String> = arraySetOf()

    var title: String? = null


    fun appendMimeType(input: String) = apply { mimeTypes.add(input) }

    @Deprecated("In development")
    fun isMultiple(input: Boolean?) = apply { isMultiple = input ?: false }

    fun removeMimeType(input: String) = apply { mimeTypes.remove(input) }

    fun title(input: String?) = apply { title = input }


    /**
     * Generate an intent by builder's settings.
     */
    override fun build(): CreateFileIntent? {
        if (!mimeTypes.any()) {
            return null
        }

        return CreateFileIntent().apply {
            putExtra(EXTRA_ALLOW_MULTIPLE, isMultiple)
            putExtra(EXTRA_TITLE, title)

            val types = mimeTypes.map { normalizeMimeType(it) }
            if (types.size == 1) {
                type = types[0]
            } else {
                putExtra(EXTRA_MIME_TYPES, types.toTypedArray())
                type = "*/*"
            }
        }
    }
}
