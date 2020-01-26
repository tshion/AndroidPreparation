package work.shion.androidpreparation.intentbuilder

import android.net.Uri
import android.provider.MediaStore

/**
 * 動画を撮影して返す設定ビルダー
 *
 * ### 実装例
 * ``` kotlin
 * TakeVideoIntentBuilder().apply {
 *     setDestination(uri)
 * }.build()?.launch(activity!!)
 * ```
 *
 * ### 参考文献
 * [一般的なインテント | Android デベロッパー](https://developer.android.com/guide/components/intents-common#ImageCapture)
 */
class TakeVideoIntentBuilder : IntentBuilder<SupplierIntent>() {

    private var uri: Uri? = null


    fun setDestination(uri: Uri) {
        this.uri = uri
    }


    /**
     * 与えられた設定からIntent を生成する
     */
    override fun build(): SupplierIntent? {
        val intent = SupplierIntent().apply {
            action = MediaStore.ACTION_VIDEO_CAPTURE
        }
        uri?.also { intent.putExtra(MediaStore.EXTRA_OUTPUT, it) }
        return intent
    }
}
