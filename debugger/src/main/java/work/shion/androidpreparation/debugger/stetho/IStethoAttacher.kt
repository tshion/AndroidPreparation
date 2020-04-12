package work.shion.androidpreparation.debugger.stetho

import android.content.Context
import com.facebook.stetho.Stetho

interface IStethoAttacher {

    /**
     * Setup "[Stetho](https://github.com/facebook/stetho)"
     *
     * **Don't use in production.**
     *
     * ### Example
     * ``` kotlin
     * class DebugApplication : Application(), IStethoAttacher {
     *      override fun onCreate() {
     *          super.onCreate()
     *          setupStetho(applicationContext)
     *      }
     * }
     * ```
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
