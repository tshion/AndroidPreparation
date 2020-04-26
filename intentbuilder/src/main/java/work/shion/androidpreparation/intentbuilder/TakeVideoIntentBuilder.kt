package work.shion.androidpreparation.intentbuilder

import work.shion.androidpreparation.intentbuilder.basis.IntentBuilder
import work.shion.androidpreparation.intentbuilder.basis.TakeVideoIntent

/**
 * Capture a video
 *
 * ### Example1
 * ``` kotlin
 * override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
 *     TakeVideoIntent.parseVideoUri(data)
 *         ?.also { findViewById<VideoView>(ID).setVideoURI(it) }
 * }
 *
 * fun launch() {
 *     TakeVideoIntentBuilder()
 *         .build()
 *         ?.start(from, REQUEST_CODE)
 * ```
 *
 * ### Example2
 * ``` kotlin
 * override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
 *     TakeVideoIntent.parseVideoUri(data)
 *         ?.also { findViewById<VideoView>(ID).setVideoURI(it) }
 * }
 *
 * fun launch() {
 *     TakeVideoIntentBuilder()
 *         .build()
 *         ?.start(from, REQUEST_CODE)
 * ```
 *
 * ### References
 * * [Common Intents | Android Developers](https://developer.android.com/guide/components/intents-common#ImageCapture)
 */
class TakeVideoIntentBuilder : IntentBuilder<TakeVideoIntent>() {

    /**
     * Generate an intent by builder's settings.
     */
    override fun build() = TakeVideoIntent()
}
