package work.shion.androidpreparation.intentbuilder.basis

abstract class IntentBuilder<T : ExecutableIntent> {

    /**
     * Generate an intent by builder's settings.
     */
    abstract fun build(): T?
}
