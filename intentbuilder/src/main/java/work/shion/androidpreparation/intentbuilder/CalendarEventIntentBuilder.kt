package work.shion.androidpreparation.intentbuilder

import android.content.Intent
import android.provider.CalendarContract


/**
 * カレンダーイベントの設定ビルダー
 *
 * ### 実装例
 * ``` kotlin
 * CalendarEventIntentBuilder().apply {
 *     setBeginTime(begin)
 *     setEndTime(end)
 *     setLocation(location)
 *     setTitle(title)
 * }.build()?.launch(activity!!)
 * ```
 *
 * ### 参考文献
 * [一般的なインテント | Android デベロッパー](https://developer.android.com/guide/components/intents-common?hl=ja#Clock)
 */
class CalendarEventIntentBuilder : IntentBuilder<ConsumerIntent>() {

    private var beginTime: Long? = null
    private var description: String? = null
    private var email: String? = null
    private var endTime: Long? = null
    private var isAllDay: Boolean? = null
    private var location: String? = null
    private var title: String? = null


    /**
     * 終日のイベントかどうかを示すブール値。
     */
    fun setAllDay(input: Boolean) {
        isAllDay = input
    }

    /**
     * イベントの開始時間（エポックからのミリ秒単位）。
     */
    fun setBeginTime(input: Long) {
        beginTime = input
    }

    /**
     * イベントの説明。
     */
    fun setDescription(input: String) {
        description = input
    }

    /**
     * 参加者のメールアドレスのコンマ区切りリスト。
     */
    fun setEmail(input: String) {
        email = input
    }

    /**
     * イベントの終了時間（エポックからのミリ秒単位）。
     */
    fun setEndTime(input: Long) {
        endTime = input
    }

    /**
     * イベントの場所。
     */
    fun setLocation(input: String) {
        location = input
    }

    /**
     * イベントのタイトル。
     */
    fun setTitle(input: String) {
        title = input
    }


    /**
     * 与えられた設定からIntent を生成する
     */
    override fun build(): ConsumerIntent? {
        beginTime ?: endTime ?: return null

        val intent = ConsumerIntent().apply {
            action = Intent.ACTION_INSERT
            data = CalendarContract.Events.CONTENT_URI
        }
        beginTime?.also { intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, it) }
        description?.also { intent.putExtra(CalendarContract.Events.DESCRIPTION, it) }
        email?.also { intent.putExtra(Intent.EXTRA_EMAIL, it) }
        endTime?.also { intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, it) }
        isAllDay?.also { intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, it) }
        title?.also { intent.putExtra(CalendarContract.Events.TITLE, it) }
        return intent
    }
}
