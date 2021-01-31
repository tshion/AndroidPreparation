package work.shion.androidpreparation.intentbuilder

import android.provider.Settings
import work.shion.androidpreparation.intentbuilder.basis.ConsumerIntent
import work.shion.androidpreparation.intentbuilder.basis.IntentBuilder

/**
 * To open a settings app
 *
 * ### Example
 * ``` kotlin
 * OpenSettingsIntentBuilder()
 *     .build()
 *     .start(from)
 * ```
 *
 * ### References
 * * [Common Intents | Android Developers](https://developer.android.com/guide/components/intents-common#OpenSettings)
 */
class OpenSettingsIntentBuilder : IntentBuilder<ConsumerIntent>() {

    /**
     * Generate an intent by builder's settings.
     */
    override fun build() = ConsumerIntent().apply {
        action = Settings.ACTION_SETTINGS
    }
}
