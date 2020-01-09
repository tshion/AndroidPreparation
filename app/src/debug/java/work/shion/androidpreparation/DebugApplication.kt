package work.shion.androidpreparation

import work.shion.androidpreparation.debugger.IStrictModeAttacher

class DebugApplication : MainApplication(),
    IStrictModeAttacher {

    override fun onCreate() {
        super.onCreate()

        // StrictMode の設定
        setupThreadPolicy()
        setupVmPolicy()
    }
}
