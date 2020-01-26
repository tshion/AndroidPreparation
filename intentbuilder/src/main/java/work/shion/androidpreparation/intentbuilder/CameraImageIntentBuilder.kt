package work.shion.androidpreparation.intentbuilder

import android.provider.MediaStore

/**
 * 静止画モードでカメラアプリ起動の設定ビルダー
 *
 * ### 実装例
 * ``` kotlin
 * CameraImageIntentBuilder().apply {
 * }.build()?.launch(activity!!)
 * ```
 *
 * ### 参考文献
 * [一般的なインテント | Android デベロッパー](https://developer.android.com/guide/components/intents-common?hl=ja#CameraStill)
 */
class CameraImageIntentBuilder : IntentBuilder<SupplierIntent>() {

    /**
     * 与えられた設定からIntent を生成する
     */
    override fun build(): SupplierIntent? {
        return SupplierIntent().apply {
            action = MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA
        }
    }
}
