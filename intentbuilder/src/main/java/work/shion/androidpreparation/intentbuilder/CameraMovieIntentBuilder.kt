package work.shion.androidpreparation.intentbuilder

import android.provider.MediaStore

/**
 * 動画モードでカメラアプリ起動の設定ビルダー
 *
 * ### 実装例
 * ``` kotlin
 * CameraMovieIntentBuilder().apply {
 * }.build()?.launch(activity!!, REQUEST_CODE)
 * ```
 *
 * ### 参考文献
 * [一般的なインテント | Android デベロッパー](https://developer.android.com/guide/components/intents-common?hl=ja#CameraVideo)
 */
class CameraMovieIntentBuilder : IntentBuilder<SupplierIntent>() {

    /**
     * 与えられた設定からIntent を生成する
     */
    override fun build(): SupplierIntent? {
        return SupplierIntent().apply {
            action = MediaStore.INTENT_ACTION_VIDEO_CAMERA
        }
    }
}
