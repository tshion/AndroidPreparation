package work.shion.androidpreparation.intentbuilder

import android.content.Intent
import android.net.Uri

/**
 * 添付ファイル付きの SMS / MMS メッセージを作成する設定ビルダー
 *
 * ### 実装例
 * ``` kotlin
 * MessageIntentBuilder().apply {
 * }.build()?.launch(activity!!)
 * ```
 *
 * ### 参考文献
 * [一般的なインテント | Android デベロッパー](https://developer.android.com/guide/components/intents-common?hl=ja#SendMessage)
 */
class MessageIntentBuilder : IntentBuilder<ConsumerIntent>() {

    private var subject: String? = null
    private var text: String? = null
    private val uris: MutableSet<Uri> = mutableSetOf()
    private var to: Uri? = null


    fun appendAttachment(input: Uri) {
        uris.add(input)
    }

    fun clearAttachment() {
        uris.clear()
    }

    fun removeAttachment(input: Uri) {
        uris.remove(input)
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

    fun setTo(input: Uri) {
        to = input
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
        subject?.also { intent.putExtra("subject", it) }
        text?.also { intent.putExtra("sms_body", it) }
        to?.also { intent.data = it }
        return intent
    }
}
