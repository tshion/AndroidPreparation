package work.shion.androidpreparation.intentbuilder

import android.content.Intent
import android.net.Uri

/**
 * メールの設定ビルダー
 *
 * ### 実装例
 * ``` kotlin
 * MailIntentBuilder().apply {
 * }.build()?.launch(activity!!)
 * ```
 *
 * ### 参考文献
 * [一般的なインテント | Android デベロッパー](https://developer.android.com/guide/components/intents-common?hl=ja#Email)
 */
class MailIntentBuilder : IntentBuilder<ConsumerIntent>() {

    private var bcc: MutableSet<String> = mutableSetOf()
    private var cc: MutableSet<String> = mutableSetOf()
    private var subject: String? = null
    private var text: String? = null
    private var to: MutableSet<String> = mutableSetOf()
    private val uris: MutableSet<Uri> = mutableSetOf()


    fun appendAttachment(input: Uri) {
        uris.add(input)
    }

    fun appendBCC(input: String) {
        bcc.add(input)
    }

    fun appendCC(input: String) {
        cc.add(input)
    }

    fun appendTo(input: String) {
        to.add(input)
    }

    fun clearAttachment() {
        uris.clear()
    }

    fun clearBCC() {
        bcc.clear()
    }

    fun clearCC() {
        cc.clear()
    }

    fun clearTo() {
        to.clear()
    }

    fun removeAttachment(input: Uri) {
        uris.remove(input)
    }

    fun removeBCC(input: String) {
        bcc.remove(input)
    }

    fun removeCC(input: String) {
        cc.remove(input)
    }

    fun removeTo(input: String) {
        to.remove(input)
    }

    /**
     * 電子メールの件名となる文字列です。
     */
    fun setSubject(input: String) {
        subject = input
    }

    /**
     * 電子メールの本文となる文字列です。
     */
    fun setText(input: String) {
        text = input
    }


    /**
     * 与えられた設定からIntent を生成する
     */
    override fun build(): ConsumerIntent? {
        val intent = ConsumerIntent().apply {
            type = "*/*"
        }
        when (uris.count()) {
            0 -> intent.action = Intent.ACTION_SENDTO
            1 -> intent.apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_STREAM, uris.first())
            }
            else -> intent.apply {
                action = Intent.ACTION_SEND_MULTIPLE
                putExtra(Intent.EXTRA_STREAM, ArrayList(uris))
            }
        }
        if (bcc.isNotEmpty()) intent.putExtra(Intent.EXTRA_BCC, bcc.toTypedArray())
        if (cc.isNotEmpty()) intent.putExtra(Intent.EXTRA_CC, cc.toTypedArray())
        subject?.also { intent.putExtra(Intent.EXTRA_SUBJECT, it) }
        text?.also { intent.putExtra(Intent.EXTRA_TEXT, it) }
        if (to.isNotEmpty()) intent.putExtra(Intent.EXTRA_EMAIL, to.toTypedArray())
        return intent
    }
}
