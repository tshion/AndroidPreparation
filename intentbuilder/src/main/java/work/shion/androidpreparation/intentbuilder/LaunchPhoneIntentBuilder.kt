package work.shion.androidpreparation.intentbuilder

import android.content.Intent
import android.net.Uri
import work.shion.androidpreparation.intentbuilder.basis.ConsumerIntent
import work.shion.androidpreparation.intentbuilder.basis.IntentBuilder
import work.shion.androidpreparation.intentbuilder.basis.PhoneNumberContract

/**
 * Launch a phone app
 *
 * ### Example
 * ``` kotlin
 * LaunchPhoneIntentBuilder().apply {
 *     phoneNumber = "phone number"
 * }.build().start(from)
 * ```
 *
 * ### References
 * * [Common Intents | Android Developers](https://developer.android.com/guide/components/intents-common#DialPhone)
 */
class LaunchPhoneIntentBuilder : IntentBuilder<ConsumerIntent>(), PhoneNumberContract {

    override var phoneNumber: String? = null
        get() = super.phoneNumber
        set(value) {
            phoneUri = Uri.parse("tel:${value}")
            field = value
        }

    override var phoneUri: Uri? = null
        private set


    /**
     * Generate an intent by builder's settings.
     */
    override fun build() = ConsumerIntent().apply {
        action = Intent.ACTION_DIAL
        if (phoneUri != null) {
            data = phoneUri
        }
    }
}
