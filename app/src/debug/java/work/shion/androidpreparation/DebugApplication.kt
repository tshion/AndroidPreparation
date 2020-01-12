package work.shion.androidpreparation

import work.shion.androidpreparation.debugger.IStethoAttacher
import work.shion.androidpreparation.debugger.IStrictModeAttacher

class DebugApplication : MainApplication(),
    IStethoAttacher, IStrictModeAttacher {

    override fun onCreate() {
        super.onCreate()

        // StrictMode の設定
        setupThreadPolicy()
        setupVmPolicy()

        // Stetho の設定
        super<IStethoAttacher>.setup(applicationContext)
    }
}
