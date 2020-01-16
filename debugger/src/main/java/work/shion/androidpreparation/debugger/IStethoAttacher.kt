package work.shion.androidpreparation.debugger

import android.content.Context
import com.facebook.stetho.Stetho

/**
 * Stetho の機能付与
 * [Stetho](https://github.com/facebook/stetho)
 */
interface IStethoAttacher {

    /**
     * Stetho のセットアップ
     *
     * **本番環境では使わないこと**
     * ### 実装例
     * ``` kotlin
     * class DebugApplication : Application(), IStethoAttacher {
     *      override fun onCreate() {
     *          super.onCreate()
     *          setupStetho(applicationContext)
     *      }
     * }
     * ```
     *
     * @param appContext アプリケーションコンテキスト
     */
    fun setupStetho(appContext: Context) {
        Thread {
            Stetho.newInitializerBuilder(appContext)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(appContext))
                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(appContext))
                .build()
                .also { Stetho.initialize(it) }
        }.start()
    }
}
