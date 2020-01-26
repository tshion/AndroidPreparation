package work.shion.androidpreparation.intentbuilder

import android.content.Intent
import android.provider.ContactsContract

/**
 * 連絡先を選択する設定ビルダー
 *
 * ### 実装例
 * ``` kotlin
 * SelectContactIntentBuilder().apply {
 * }.build()?.launch(activity!!, REQUEST_CODE)
 * ```
 *
 * ### 参考文献
 * [一般的なインテント | Android デベロッパー](https://developer.android.com/guide/components/intents-common?hl=ja#PickContact)
 */
class SelectContactIntentBuilder : IntentBuilder<SupplierIntent>() {

    /**
     * 与えられた設定からIntent を生成する
     */
    override fun build(): SupplierIntent? {
        return SupplierIntent().apply {
            action = Intent.ACTION_PICK
            type = ContactsContract.Contacts.CONTENT_TYPE
        }
    }
}
