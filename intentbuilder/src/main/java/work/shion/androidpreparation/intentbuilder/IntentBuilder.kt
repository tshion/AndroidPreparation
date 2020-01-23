package work.shion.androidpreparation.intentbuilder


/**
 * Intent 設定ビルダー
 */
abstract class IntentBuilder<T : ExecutableIntent> {

    /**
     * 与えられた設定からIntent を生成する
     */
    abstract fun build(): T?
}
