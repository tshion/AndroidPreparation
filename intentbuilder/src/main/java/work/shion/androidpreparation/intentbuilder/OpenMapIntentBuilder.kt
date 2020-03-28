package work.shion.androidpreparation.intentbuilder

import android.content.Intent
import android.net.Uri
import androidx.annotation.IntRange
import androidx.collection.ArraySet
import androidx.collection.arraySetOf
import work.shion.androidpreparation.intentbuilder.basis.ConsumerIntent
import work.shion.androidpreparation.intentbuilder.basis.IntentBuilder
import java.net.URLEncoder

/**
 * Launch a map app
 *
 * ### Example1
 * ``` kotlin
 * OpenMapIntentBuilder().apply {
 *     appendLabel(34.99, -106.61, "Treasure")
 *     latitude = 0.0
 *     longitude = 0.0
 *     zoom = 11
 * }.build().start(from)
 * ```
 *
 * ### Example2
 * ``` kotlin
 * OpenMapIntentBuilder()
 *     .appendLabel(34.99, -106.61, "Treasure")
 *     .latitude(0.0)
 *     .longitude(0.0)
 *     .zoom(11)
 *     .build()
 *     .start(from)
 * ```
 *
 * ### References
 * * [Common Intents | Android Developers](https://developer.android.com/guide/components/intents-common#ViewMap)
 */
class OpenMapIntentBuilder : IntentBuilder<ConsumerIntent>() {

    companion object {
        const val ZOOM_MAX = 23L
        const val ZOOM_MIN = 1L


        @JvmStatic
        private fun formatLabel(
                latitude: Double,
                longitude: Double,
                title: String
        ) = "${latitude},${longitude}(${title})"
    }


    val label: ArraySet<String> = arraySetOf()
    var latitude: Double? = null
    var longitude: Double? = null

    /**
     * ### Note
     * Show the map at the given longitude and latitude at a certain zoom level.
     * A zoom level of 1 shows the whole Earth, centered at the given lat,lng.
     * The highest (closest) zoom level is 23.
     */
    var zoom: Int? = null
        set(@IntRange(from = ZOOM_MIN, to = ZOOM_MAX) value) {
            if (value == null || value.toLong() in ZOOM_MIN..ZOOM_MAX) {
                field = value
            }
        }


    fun appendLabel(title: String) = apply { label.add(title) }

    /**
     * Append a string label by the latitude, longitude and title.
     */
    fun appendLabel(latitude: Double, longitude: Double, title: String) = appendLabel(formatLabel(latitude, longitude, title))

    fun latitude(input: Double?) = apply { latitude = input }

    fun longitude(input: Double?) = apply { longitude = input }

    fun removeLabel(title: String) = apply { label.remove(title) }

    /**
     * Remove a string label by the latitude, longitude and title.
     */
    fun removeLabel(latitude: Double, longitude: Double, title: String) = removeLabel(formatLabel(latitude, longitude, title))

    /**
     * Try set zoom level.
     *
     * ### Note
     * Show the map at the given longitude and latitude at a certain zoom level.
     * A zoom level of 1 shows the whole Earth, centered at the given lat,lng.
     * The highest (closest) zoom level is 23.
     */
    @Deprecated("Duplicate implementation")
    fun trySetZoom(input: Int): Boolean {
        val isValid = input in 1..23
        if (isValid) zoom = input
        return isValid
    }

    /**
     * ### Note
     * Show the map at the given longitude and latitude at a certain zoom level.
     * A zoom level of 1 shows the whole Earth, centered at the given lat,lng.
     * The highest (closest) zoom level is 23.
     */
    fun zoom(@IntRange(from = ZOOM_MIN, to = ZOOM_MAX) input: Int?) = apply { zoom = input }


    /**
     * Generate an intent by builder's settings.
     */
    override fun build() = ConsumerIntent().apply {
        val location = if (latitude != null && longitude != null) "${latitude},${longitude}" else ""
        val query = label.map { "q=${URLEncoder.encode(it, "UTF-8")}" }.toMutableList()
        zoom?.also { query.add("z=$it") }

        action = Intent.ACTION_VIEW
        data = Uri.parse("geo:$location${query.joinToString("&", "?")}")
    }
}
