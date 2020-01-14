package work.shion.androidpreparation.baser

import timber.log.Timber

/**
 * Timber の機能付与
 * [JakeWharton/timber](https://github.com/JakeWharton/timber)
 */
interface ITimberAttacher {

    /**
     * デバッグ用ログ設定
     */
    fun getTreeForDebug() = Timber.DebugTree()

    /**
     * 本番用ログ設定
     */
    fun getTreeForProduct() = object : Timber.Tree() {
        override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {}
    }

    /**
     * セットアップ
     */
    fun setupTimber(isDebug: Boolean = BuildConfig.DEBUG) {
        if (isDebug) {
            getTreeForDebug()
        } else {
            getTreeForProduct()
        }.also {
            Timber.plant(it)
        }
    }
}
