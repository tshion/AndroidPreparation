package work.shion.androidpreparation.baser

import android.app.Application

open class MainApplication : Application(),
        ITimberAttacher {

    override fun onCreate() {
        super.onCreate()

        // Timber の設定
        setupTimber()
    }
}
