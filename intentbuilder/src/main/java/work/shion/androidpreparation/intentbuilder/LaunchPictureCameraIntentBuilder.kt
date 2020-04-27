package work.shion.androidpreparation.intentbuilder

import android.provider.MediaStore
import work.shion.androidpreparation.intentbuilder.basis.ConsumerIntent
import work.shion.androidpreparation.intentbuilder.basis.IntentBuilder

/**
 * Start a camera app in still image mode
 *
 * ### Example
 * ``` kotlin
 * LaunchPictureCameraIntentBuilder()
 *     .build()
 *     .start(from)
 * ```
 *
 * ### References
 * * [Common Intents | Android Developers](https://developer.android.com/guide/components/intents-common#CameraStill)
 */
class LaunchPictureCameraIntentBuilder : IntentBuilder<ConsumerIntent>() {

    /**
     * Generate an intent by builder's settings.
     */
    override fun build() = ConsumerIntent().apply {
        action = MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA
    }
}
