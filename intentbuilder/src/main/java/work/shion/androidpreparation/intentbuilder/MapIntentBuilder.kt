package work.shion.androidpreparation.intentbuilder

import android.content.Intent
import android.net.Uri
import work.shion.androidpreparation.intentbuilder.basis.ConsumerIntent
import work.shion.androidpreparation.intentbuilder.basis.IntentBuilder

/**
 * 地図上の場所を表示する設定ビルダー
 *
 * ### 実装例
 * ``` kotlin
 * MapIntentBuilder().apply {
 *     setLocation(47.6,-122.3)
 * }.build()?.launch(activity!!)
 * ```
 *
 * ### 参考文献
 * [一般的なインテント | Android デベロッパー](https://developer.android.com/guide/components/intents-common?hl=ja#ViewMap)
 */
@Deprecated("In development")
class MapIntentBuilder : IntentBuilder<ConsumerIntent>() {

    private val label: MutableSet<String> = mutableSetOf()
    private var latitude: Double? = null
    private var longitude: Double? = null
    private var zoom: Int? = null


    /**
     * （特定の住所や位置クエリ）の場所を追加
     * @param title 表示タイトル
     */
    fun appendLabel(title: String) {
        label.add(title)
    }

    /**
     * 指定された経度と緯度の地図を文字列ラベル付きの追加
     * @param latitude 緯度
     * @param longitude 経度
     * @param title 表示タイトル
     */
    fun appendLabel(latitude: Double, longitude: Double, title: String) {
        label.add("${latitude},${longitude}(${title})")
    }

    fun clearLabel() {
        label.clear()
    }

    /**
     * （特定の住所や位置クエリ）の場所を削除
     * @param title 表示タイトル
     */
    fun removeLabel(title: String) {
        label.add(title)
    }

    /**
     * 指定された経度と緯度の地図を文字列ラベル付きの削除
     * @param latitude 緯度
     * @param longitude 経度
     * @param title 表示タイトル
     */
    fun removeLabel(latitude: Double, longitude: Double, title: String) {
        label.add("${latitude},${longitude}(${title})")
    }

    /**
     * 指定された経度と緯度の地図を表示します。
     * @param latitude 緯度
     * @param longitude 経度
     */
    fun setLocation(latitude: Double, longitude: Double) {
        this.latitude = latitude
        this.longitude = longitude
    }

    /**
     * 指定された経度と緯度の地図を一定の縮尺レベルで表示します。
     * 縮尺レベル 1 では、指定された経度と緯度を中心として地球全体を表示します。
     * 最高の（もっとも詳細な）縮尺レベルは 23 です。
     */
    fun trySetZoom(input: Int): Boolean {
        val isValid = input in 1..23
        if (isValid) zoom = input
        return isValid
    }


    /**
     * 与えられた設定からIntent を生成する
     */
    override fun build(): ConsumerIntent? {
        latitude ?: longitude ?: return null

        val builder = Uri.Builder()
            .scheme("geo")
            .authority("${latitude},${longitude}")
        label.forEach { builder.appendQueryParameter("q", it) }
        zoom?.also { builder.appendQueryParameter("z", "$it") }

        return ConsumerIntent().apply {
            action = Intent.ACTION_VIEW
            data = builder.build()
        }
    }
}
