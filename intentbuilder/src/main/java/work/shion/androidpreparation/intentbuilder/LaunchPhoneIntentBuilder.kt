package work.shion.androidpreparation.intentbuilder

import android.content.Intent
import android.net.Uri
import work.shion.androidpreparation.intentbuilder.basis.ConsumerIntent
import work.shion.androidpreparation.intentbuilder.basis.IntentBuilder
import work.shion.androidpreparation.intentbuilder.basis.PhoneNumberContract

/**
 * Launch a phone app
 *
 * ### Example1
 * ``` kotlin
 * LaunchPhoneIntentBuilder().apply {
 *     phoneNumber = "phone number"
 * }.build().start(from)
 * ```
 *
 * ### Example2
 * ``` kotlin
 * LaunchPhoneIntentBuilder()
 *     .phoneNumber("phone number")
 *     .build()
 *     .start(from)
 * ```
 *
 * ### References
 * * [Common Intents | Android Developers](https://developer.android.com/guide/components/intents-common#DialPhone)
 */
class LaunchPhoneIntentBuilder : IntentBuilder<ConsumerIntent>(), PhoneNumberContract {

    override var phoneNumber: String? = null
        set(value) {
            phoneUri = if (!value.isNullOrBlank()) Uri.parse("tel:$value") else null
            field = value
        }

    override var phoneUri: Uri? = null
        private set


    fun phoneNumber(input: String?) = apply { phoneNumber = input }


    /**
     * Generate an intent by builder's settings.
     */
    override fun build() = ConsumerIntent().apply {
        action = Intent.ACTION_DIAL
        phoneUri?.also { data = it }
    }
}
