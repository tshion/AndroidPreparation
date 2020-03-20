package work.shion.androidpreparation.intentbuilder.basis

import android.app.Activity
import androidx.fragment.app.Fragment

open class ConsumerIntent : ExecutableIntent() {

    /**
     * Start an intent from an activity.
     */
    open fun start(from: Activity, onNotFound: (() -> Unit)? = null) {
        if (resolveActivity(from.packageManager) != null) {
            from.startActivity(this)
        } else {
            onNotFound?.invoke()
        }
    }

    /**
     * Start an intent from a fragment.
     */
    open fun start(from: Fragment, onNotFound: (() -> Unit)? = null) {
        if (from.activity?.let { resolveActivity(it.packageManager) } != null) {
            from.startActivity(this)
        } else {
            onNotFound?.invoke()
        }
    }
}
