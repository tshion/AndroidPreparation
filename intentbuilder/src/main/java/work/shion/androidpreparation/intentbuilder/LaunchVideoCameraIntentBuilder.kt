package work.shion.androidpreparation.intentbuilder

import android.provider.MediaStore
import work.shion.androidpreparation.intentbuilder.basis.ConsumerIntent
import work.shion.androidpreparation.intentbuilder.basis.IntentBuilder

/**
 * Start a camera app in video mode
 *
 * ### Example
 * ``` kotlin
 * LaunchVideoCameraIntentBuilder()
 *     .build()
 *     .start(from)
 * ```
 *
 * ### References
 * * [Common Intents | Android Developers](https://developer.android.com/guide/components/intents-common#CameraVideo)
 */
class LaunchVideoCameraIntentBuilder : IntentBuilder<ConsumerIntent>() {

    /**
     * Generate an intent by builder's settings.
     */
    override fun build() = ConsumerIntent().apply {
        action = MediaStore.INTENT_ACTION_VIDEO_CAMERA
    }
}
