package work.shion.androidpreparation

import work.shion.androidpreparation.baser.MainApplication
import work.shion.androidpreparation.debugger.IStethoAttacher
import work.shion.androidpreparation.debugger.IStrictModeAttacher
import work.shion.androidpreparation.debugger.IWebViewAttacher

class DebugApplication : MainApplication(),
    IStethoAttacher, IStrictModeAttacher, IWebViewAttacher {

    override fun onCreate() {
        super.onCreate()

        // StrictMode の設定
        setupThreadPolicy()
        setupVmPolicy()

        // Stetho の設定
        setupStetho(applicationContext)

        // WebView の設定
        setupWebDebugger()
    }
}
