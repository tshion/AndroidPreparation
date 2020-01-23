package work.shion.androidpreparation

import work.shion.androidpreparation.baser.MainApplication
import work.shion.androidpreparation.debugger.IDebugger

class DebugApplication : MainApplication(), IDebugger {

    override fun onCreate() {
        super.onCreate()
        setup(applicationContext)
    }
}
