package work.shion.androidpreparation.intentbuilder

import android.content.Intent
import android.net.Uri
import work.shion.androidpreparation.intentbuilder.basis.ConsumerIntent
import work.shion.androidpreparation.intentbuilder.basis.IntentBuilder

/**
 * Launch a mail app
 *
 * ### Example
 * ``` kotlin
 * LaunchMailIntentBuilder().apply {
 *     attachmentUris.add(uri)
 *     bcc.add("test2@example.test")
 *     cc.add("test3@example.test")
 *     subject = "subject"
 *     text = "mail body text"
 *     to.add("test1@example.test")
 * }.build().start(from)
 * ```
 *
 * ### References
 * * [Common Intents | Android Developers](https://developer.android.com/guide/components/intents-common#Email)
 */
class LaunchMailIntentBuilder : IntentBuilder<ConsumerIntent>() {

    val attachmentUris: MutableSet<Uri> = mutableSetOf()
    val bcc: MutableSet<String> = mutableSetOf()
    val cc: MutableSet<String> = mutableSetOf()
    var subject: String? = null
    var text: String? = null
    val to: MutableSet<String> = mutableSetOf()


    /**
     * Generate an intent by builder's settings.
     */
    override fun build() = ConsumerIntent().apply {
        data = Uri.parse("mailto:")
        type = "*/*"

        when (attachmentUris.count()) {
            0 -> action = Intent.ACTION_SENDTO
            1 -> {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_STREAM, attachmentUris.first())
            }
            else -> {
                action = Intent.ACTION_SEND_MULTIPLE
                putExtra(Intent.EXTRA_STREAM, ArrayList(attachmentUris))
            }
        }
        if (bcc.isNotEmpty()) putExtra(Intent.EXTRA_BCC, bcc.toTypedArray())
        if (cc.isNotEmpty()) putExtra(Intent.EXTRA_CC, cc.toTypedArray())
        subject?.also { putExtra(Intent.EXTRA_SUBJECT, it) }
        text?.also { putExtra(Intent.EXTRA_TEXT, it) }
        if (to.isNotEmpty()) putExtra(Intent.EXTRA_EMAIL, to.toTypedArray())
    }
}
