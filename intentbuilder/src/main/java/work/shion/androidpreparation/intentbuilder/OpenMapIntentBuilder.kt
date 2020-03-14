package work.shion.androidpreparation.intentbuilder

import android.content.Intent
import android.net.Uri
import work.shion.androidpreparation.intentbuilder.basis.ConsumerIntent
import work.shion.androidpreparation.intentbuilder.basis.IntentBuilder
import java.net.URLEncoder

/**
 * Launch a map app
 *
 * ### Example
 * ``` kotlin
 * OpenMapIntentBuilder().apply {
 *     appendLabel(34.99, -106.61, "Treasure")
 *     latitude = 0.0
 *     longitude = 0.0
 *     trySetZoom(11)
 * }.build().start(from)
 * ```
 *
 * ### References
 * * [Common Intents | Android Developers](https://developer.android.com/guide/components/intents-common#ViewMap)
 */
class OpenMapIntentBuilder : IntentBuilder<ConsumerIntent>() {

    val label: MutableSet<String> = mutableSetOf()
    var latitude: Double? = null
    var longitude: Double? = null
    var zoom: Int? = null
        private set


    /**
     * Append a string label by the latitude, longitude and title.
     */
    fun appendLabel(latitude: Double, longitude: Double, title: String) {
        label.add("${latitude},${longitude}(${title})")
    }

    /**
     * Remove a string label by the latitude, longitude and title.
     */
    fun removeLabel(latitude: Double, longitude: Double, title: String) {
        label.remove("${latitude},${longitude}(${title})")
    }

    /**
     * Try set zoom level.
     *
     * ### Note
     * Show the map at the given longitude and latitude at a certain zoom level.
     * A zoom level of 1 shows the whole Earth, centered at the given lat,lng.
     * The highest (closest) zoom level is 23.
     */
    fun trySetZoom(input: Int): Boolean {
        val isValid = input in 1..23
        if (isValid) zoom = input
        return isValid
    }


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
