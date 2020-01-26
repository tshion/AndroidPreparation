package work.shion.androidpreparation.intentbuilder

import android.content.Intent
import android.net.Uri
import android.provider.ContactsContract
import android.webkit.URLUtil

/**
 * 既存の連絡先を編集する設定ビルダー
 *
 * ### 実装例
 * ``` kotlin
 * EditContactIntentBuilder().apply {
 *     trySetUri(uriText)
 * }.build()?.launch(activity!!)
 * ```
 *
 * ### 参考文献
 * [一般的なインテント | Android デベロッパー](https://developer.android.com/guide/components/intents-common?hl=ja#EditContact)
 */
class EditContactIntentBuilder : IntentBuilder<ConsumerIntent>() {

    private var company: String? = null
    private var email: String? = null
    private var name: String? = null
    private var phone: String? = null
    private var uri: Uri? = null


    fun setCompany(input: String) {
        company = input
    }

    fun setEmail(input: String) {
        email = input
    }

    fun setName(input: String) {
        name = input
    }

    fun setPhone(input: String) {
        phone = input
    }

    fun trySetUri(uri: String): Boolean {
        val isValid = URLUtil.isContentUrl(uri)
        if (isValid) this.uri = Uri.parse(uri)
        return isValid
    }


    /**
     * 与えられた設定からIntent を生成する
     */
    override fun build(): ConsumerIntent? {
        uri ?: return null
        val intent = ConsumerIntent().apply {
            action = Intent.ACTION_EDIT
            data = uri
        }
        company?.also { intent.putExtra(ContactsContract.Intents.Insert.COMPANY, it) }
        email?.also { intent.putExtra(ContactsContract.Intents.Insert.EMAIL, it) }
        name?.also { intent.putExtra(ContactsContract.Intents.Insert.NAME, it) }
        phone?.also { intent.putExtra(ContactsContract.Intents.Insert.PHONE, it) }
        return intent
    }
}
