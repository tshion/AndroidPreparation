package work.shion.androidpreparation.intentbuilder

import android.content.Intent
import android.provider.ContactsContract

/**
 * 連絡先を選択する設定ビルダー
 *
 * ### 実装例
 * ``` kotlin
 * SelectContactIntentBuilder().apply {
 *     setContentType()
 * }.build()?.launch(activity!!, REQUEST_CODE)
 * ```
 *
 * ### 参考文献
 * [一般的なインテント | Android デベロッパー](https://developer.android.com/guide/components/intents-common?hl=ja#PickContact)
 */
class SelectContactIntentBuilder : IntentBuilder<SupplierIntent>() {

    private var mime: String? = null


    /**
     * 連絡先から住所を取得します。
     */
    fun setAddress() {
        mime = ContactsContract.CommonDataKinds.StructuredPostal.CONTENT_TYPE
    }

    /**
     * 連絡先を選択する
     */
    fun setContentType() {
        mime = ContactsContract.Contacts.CONTENT_TYPE
    }

    /**
     * 連絡先からメールアドレスを取得します。
     */
    fun setEmail() {
        mime = ContactsContract.CommonDataKinds.Email.CONTENT_TYPE
    }

    /**
     * 連絡先から電話番号を取得します。
     */
    fun setPhone() {
        mime = ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE
    }


    /**
     * 与えられた設定からIntent を生成する
     */
    override fun build(): SupplierIntent? {
        return mime?.let {
            SupplierIntent().apply {
                action = Intent.ACTION_PICK
                type = mime
            }
        }
    }
}
