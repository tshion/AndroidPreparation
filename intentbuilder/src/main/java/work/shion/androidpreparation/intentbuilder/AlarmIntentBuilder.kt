package work.shion.androidpreparation.intentbuilder

import android.provider.AlarmClock
import android.webkit.URLUtil
import work.shion.androidpreparation.intentbuilder.basis.ConsumerIntent
import work.shion.androidpreparation.intentbuilder.basis.IntentBuilder
import java.util.*

/**
 * アラームの設定ビルダー
 *
 * ### 実装例
 * ``` kotlin
 * AlarmIntentBuilder().apply {
 * }.build()?.launch(activity!!)
 * ```
 *
 * ### 注意点
 * * SET_ALARM パーミッションが必要
 *
 * ### 参考文献
 * [一般的なインテント | Android デベロッパー](https://developer.android.com/guide/components/intents-common?hl=ja#Clock)
 */
@Deprecated("In development")
class AlarmIntentBuilder : IntentBuilder<ConsumerIntent>() {

    private var canSkip: Boolean? = null
    private var days: Int? = null
    private var hour: Int? = null
    private var message: String? = null
    private var minutes: Int? = null
    private var ringtone: String? = null
    private var vibrate: Boolean? = null


    /**
     * アラームを識別するカスタム メッセージです。
     */
    fun setMessage(input: String) {
        message = input
    }

    /**
     * アラームを設定する際に応答アプリが UI をスキップするかどうかを示すブール値です。
     * true の場合、アプリは確認画面の UI をすべてスキップして指定されたアラームを設定します。
     */
    fun setSkipUi(input: Boolean) {
        canSkip = input
    }

    /**
     * アラームでバイブレーションを使用するかどうかを示すブール値です。
     */
    fun setVibrate(input: Boolean) {
        vibrate = input
    }

    /**
     * このアラームが繰り返される曜日を格納した ArrayList です。
     * 曜日は、たとえば MONDAY のように Calendar クラスの整数で指定します。
     * 1 回限りのアラームの場合は、このエクストラは設定しないでください。
     */
    fun trySetDays(input: Int): Boolean {
        val isValid = arrayOf(
                Calendar.SUNDAY,
                Calendar.MONDAY,
                Calendar.TUESDAY,
                Calendar.WEDNESDAY,
                Calendar.THURSDAY,
                Calendar.FRIDAY,
                Calendar.SATURDAY
        ).contains(input)
        if (isValid) days = input
        return isValid
    }

    /**
     * アラームの時間。
     */
    fun trySetHour(input: Int): Boolean {
        val isValid = input in 0..23
        if (isValid) hour = input
        return isValid
    }

    /**
     * アラームの分。
     */
    fun trySetMinutes(input: Int): Boolean {
        val isValid = input in 0..59
        if (isValid) minutes = input
        return isValid
    }

    /**
     * アラームで使用する着信音を指定する content: URI。
     * 着信音を使用しない場合は、VALUE_RINGTONE_SILENT を指定します。
     * デフォルトの着信音を使用する場合は、このエクストラは指定しないでください。
     */
    fun trySetRingtone(input: String): Boolean {
        val isValid = URLUtil.isContentUrl(input) || input == AlarmClock.VALUE_RINGTONE_SILENT
        if (isValid) ringtone = input
        return isValid
    }


    /**
     * 与えられた設定からIntent を生成する
     */
    override fun build(): ConsumerIntent? {
        val intent = ConsumerIntent().apply {
            action = AlarmClock.ACTION_SET_ALARM
        }
        canSkip?.also { intent.putExtra(AlarmClock.EXTRA_SKIP_UI, it) }
        days?.also { intent.putExtra(AlarmClock.EXTRA_DAYS, it) }
        hour?.also { intent.putExtra(AlarmClock.EXTRA_HOUR, it) }
        message?.also { intent.putExtra(AlarmClock.EXTRA_MESSAGE, it) }
        minutes?.also { intent.putExtra(AlarmClock.EXTRA_MINUTES, it) }
        ringtone?.also { intent.putExtra(AlarmClock.EXTRA_RINGTONE, it) }
        vibrate?.also { intent.putExtra(AlarmClock.EXTRA_VIBRATE, it) }
        return intent
    }
}
