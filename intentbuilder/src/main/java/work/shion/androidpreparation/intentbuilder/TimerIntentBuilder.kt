package work.shion.androidpreparation.intentbuilder

import android.provider.AlarmClock
import work.shion.androidpreparation.intentbuilder.basis.ConsumerIntent
import work.shion.androidpreparation.intentbuilder.basis.IntentBuilder

/**
 * タイマーの設定ビルダー
 *
 * ### 実装例
 * ``` kotlin
 * TimerIntentBuilder().apply {
 *     setLength(60)
 *     setMessage("message")
 *     setSkipUi(true)
 * }.build()?.launch(activity!!)
 * ```
 *
 * ### 注意点
 * * SET_ALARM パーミッションが必要
 *
 * ### 参考文献
 * [一般的なインテント | Android デベロッパー](https://developer.android.com/guide/components/intents-common#CreateTimer)
 */
@Deprecated("In development")
class TimerIntentBuilder : IntentBuilder<ConsumerIntent>() {

    private var canSkip: Boolean? = null
    private var length: Int? = null
    private var message: String? = null


    /**
     * 秒単位のタイマーの長さです。
     */
    fun setLength(second: Int) {
        length = second
    }

    /**
     * タイマーを識別するカスタム メッセージです。
     */
    fun setMessage(input: String) {
        message = input
    }

    /**
     * タイマーを設定する際にアプリが UI をスキップするかどうかを示すブール値です。
     * true の場合、アプリは確認画面の UI をすべてスキップして指定されたタイマーを開始します。
     */
    fun setSkipUi(input: Boolean) {
        canSkip = input
    }


    /**
     * 与えられた設定からIntent を生成する
     */
    override fun build(): ConsumerIntent? {
        val intent = ConsumerIntent().apply {
            action = AlarmClock.ACTION_SET_TIMER
        }
        canSkip?.also { intent.putExtra(AlarmClock.EXTRA_SKIP_UI, it) }
        length?.also { intent.putExtra(AlarmClock.EXTRA_LENGTH, it) }
        message?.also { intent.putExtra(AlarmClock.EXTRA_MESSAGE, it) }
        return intent
    }
}
