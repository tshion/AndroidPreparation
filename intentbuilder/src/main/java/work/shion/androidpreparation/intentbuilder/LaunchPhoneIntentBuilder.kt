package work.shion.androidpreparation.intentbuilder

import android.content.Intent
import android.net.Uri
import work.shion.androidpreparation.intentbuilder.basis.ConsumerIntent
import work.shion.androidpreparation.intentbuilder.basis.IntentBuilder

/**
 * Launch a phone app
 *
 * ### Example
 * ``` kotlin
 * LaunchPhoneIntentBuilder().apply {
 *     setPhoneNumber("phone number")
 * }.build().start(from)
 * ```
 *
 * ### References
 * * [Common Intents | Android Developers](https://developer.android.com/guide/components/intents-common#DialPhone)
 */
class LaunchPhoneIntentBuilder : IntentBuilder<ConsumerIntent>() {

    private var phoneNumber: Uri? = null


    fun getPhoneNumber() = phoneNumber.toString()
            .replace(phoneNumber?.scheme ?: "", "")

    fun setPhoneNumber(phoneNumber: String) {
        this.phoneNumber = Uri.parse("tel:${phoneNumber}")
    }


    /**
     * Generate an intent by builder's settings.
     */
    override fun build() = ConsumerIntent().apply {
        action = Intent.ACTION_DIAL
        if (phoneNumber != null) {
            data = phoneNumber
        }
    }
}
