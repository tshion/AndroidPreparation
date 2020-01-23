package work.shion.androidpreparation.debugger

import android.content.Context
import work.shion.androidpreparation.debugger.android.IStrictModeAttacher
import work.shion.androidpreparation.debugger.android.IWebViewAttacher
import work.shion.androidpreparation.debugger.stetho.IStethoAttacher

interface IDebugger : IStethoAttacher, IStrictModeAttacher, IWebViewAttacher {

    /**
     * Debug 関連ツールのセットアップ
     *
     * **本番環境では使わないこと**
     * ### 実装例
     * ``` kotlin
     * class DebugApplication : Application(), IDebugger {
     *      override fun onCreate() {
     *          super.onCreate()
     *          setup(applicationContext)
     *      }
     * }
     * ```
     *
     * @param appContext アプリケーションコンテキスト
     */
    fun setup(appContext: Context) {
        setupThreadPolicy()
        setupVmPolicy()
        setupStetho(appContext)
        setupWebDebugger()
    }
}
