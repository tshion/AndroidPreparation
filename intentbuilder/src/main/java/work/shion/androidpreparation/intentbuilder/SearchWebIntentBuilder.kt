package work.shion.androidpreparation.intentbuilder

import android.app.SearchManager
import android.content.Intent
import work.shion.androidpreparation.intentbuilder.basis.ConsumerIntent
import work.shion.androidpreparation.intentbuilder.basis.IntentBuilder

/**
 * To initiate a web search
 *
 * ### Example1
 * ``` kotlin
 * SearchWebIntentBuilder().apply {
 *     query = "Android"
 * }.build().start(from)
 * ```
 *
 * ### Example2
 * ``` kotlin
 * SearchWebIntentBuilder()
 *     .query("Android")
 *     .build()
 *     .start(from)
 * ```
 *
 * ### References
 * * [Common Intents | Android Developers](https://developer.android.com/guide/components/intents-common#SearchWeb)
 */
class SearchWebIntentBuilder : IntentBuilder<ConsumerIntent>() {

    var query: String? = null


    fun query(input: String?) = apply { query = input }


    /**
     * Generate an intent by builder's settings.
     */
    override fun build() = ConsumerIntent().apply {
        action = Intent.ACTION_WEB_SEARCH
        putExtra(SearchManager.QUERY, query)
    }
}
