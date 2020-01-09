package work.shion.androidpreparation.debugger

import android.os.StrictMode

/**
 * StrictMode の機能付与
 * [StrictMode](https://developer.android.com/reference/android/os/StrictMode)
 */
interface IStrictModeAttacher {

    /**
     * ThreadPolicy のセットアップ
     *
     * **本番環境では使わないこと**
     * ### 実装例
     * ``` kotlin
     * class DebugApplication : Application(), IStrictModeAttacher {
     *     override fun onCreate() {
     *         super.onCreate()
     *         setupThreadPolicy()
     *     }
     * }
     * ```
     */
    fun setupThreadPolicy() {
        StrictMode.ThreadPolicy.Builder()
            .detectAll()
            .penaltyLog()
            .penaltyDialog()
            .build()
            .also { policy -> StrictMode.setThreadPolicy(policy) }
    }

    /**
     * VmPolicy のセットアップ<br />
     *
     * **本番環境では使わないこと**
     * ### 実装例
     * ``` kotlin
     * class DebugApplication : Application(), IStrictModeAttacher {
     *     override fun onCreate() {
     *         super.onCreate()
     *         setupVmPolicy()
     *     }
     * }
     * ```
     */
    fun setupVmPolicy() {
        StrictMode.VmPolicy.Builder()
            .detectAll()
            .penaltyLog()
            .build()
            .also { policy -> StrictMode.setVmPolicy(policy) }
    }
}
