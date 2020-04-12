package work.shion.androidpreparation.debugger.android

import android.os.StrictMode

interface IStrictModeAttacher {

    /**
     * Setup "[ThreadPolicy](https://developer.android.com/reference/android/os/StrictMode.ThreadPolicy)"
     *
     * **Don't use in production.**
     *
     * ### Example
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
            .build()
            .also { policy -> StrictMode.setThreadPolicy(policy) }
    }

    /**
     * Setup "[VmPolicy](https://developer.android.com/reference/android/os/StrictMode.VmPolicy)"
     *
     * **Don't use in production.**
     *
     * ### Example
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
