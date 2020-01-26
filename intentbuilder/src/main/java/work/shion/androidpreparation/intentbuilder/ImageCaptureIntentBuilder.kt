package work.shion.androidpreparation.intentbuilder

import android.net.Uri
import android.provider.MediaStore

/**
 * 写真を撮影して返す設定ビルダー
 *
 * ### 実装例
 * ``` kotlin
 * ImageCaptureIntentBuilder().apply {
 *     setDestination(uri)
 * }.build()?.launch(activity!!)
 * ```
 *
 * ### 参考文献
 * [一般的なインテント | Android デベロッパー](https://developer.android.com/guide/components/intents-common#ImageCapture)
 */
class ImageCaptureIntentBuilder : IntentBuilder<SupplierIntent>() {

    private var uri: Uri? = null


    fun setDestination(uri: Uri) {
        this.uri = uri
    }


    /**
     * 与えられた設定からIntent を生成する
     */
    override fun build(): SupplierIntent? {
        val intent = SupplierIntent().apply {
            action = MediaStore.ACTION_IMAGE_CAPTURE
        }
        uri?.also { intent.putExtra(MediaStore.EXTRA_OUTPUT, it) }
        return intent
    }
}
