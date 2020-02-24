package work.shion.androidpreparation.intentbuilder

import android.app.SearchManager
import android.content.Intent
import work.shion.androidpreparation.intentbuilder.basis.ConsumerIntent
import work.shion.androidpreparation.intentbuilder.basis.IntentBuilder

/**
 * ウェブ検索の設定ビルダー
 *
 * ### 実装例
 * ``` kotlin
 * SearchWebIntentBuilder().apply {
 *     query = "Android"
 * }.build().launch(this)
 * ```
 *
 * ### 参考文献
 * [一般的なインテント | Android デベロッパー](https://developer.android.com/guide/components/intents-common?hl=ja#SearchWeb)
 */
@Deprecated("In development")
class SearchWebIntentBuilder : IntentBuilder<ConsumerIntent>() {

    /** 検索文字列 */
    var query: String? = null


    /**
     * 与えられた設定からIntent を生成する
     */
    override fun build() = ConsumerIntent().apply {
        action = Intent.ACTION_WEB_SEARCH
        putExtra(SearchManager.QUERY, query)
    }
}
