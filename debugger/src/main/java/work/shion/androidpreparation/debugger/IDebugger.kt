package work.shion.androidpreparation.debugger

import android.content.Context
import work.shion.androidpreparation.debugger.android.IStrictModeAttacher
import work.shion.androidpreparation.debugger.android.IWebViewAttacher
import work.shion.androidpreparation.debugger.stetho.IStethoAttacher

interface IDebugger : IStethoAttacher, IStrictModeAttacher, IWebViewAttacher {

    /**
     * Setup debugging tools
     *
     * **Don't use in production.**
     *
     * ### Example
     * ``` kotlin
     * class DebugApplication : Application(), IDebugger {
     *      override fun onCreate() {
     *          super.onCreate()
     *          setup(applicationContext)
     *      }
     * }
     * ```
     *
     * @see IStethoAttacher
     * @see IStrictModeAttacher
     * @see IWebViewAttacher
     */
    fun setup(appContext: Context) {
        setupThreadPolicy()
        setupVmPolicy()
        setupStetho(appContext)
        setupWebDebugger()
    }
}
