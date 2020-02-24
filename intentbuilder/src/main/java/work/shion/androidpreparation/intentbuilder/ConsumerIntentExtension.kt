package work.shion.androidpreparation.intentbuilder

import android.app.Activity
import androidx.fragment.app.Fragment
import work.shion.androidpreparation.intentbuilder.basis.ConsumerIntent

/**
 * Start an intent from an activity.
 */
fun ConsumerIntent.start(from: Activity, onNotFound: (() -> Unit)? = null) {
    if (resolveActivity(from.packageManager) != null) {
        from.startActivity(this)
    } else {
        onNotFound?.invoke()
    }
}

/**
 * Start an intent from a fragment.
 */
fun ConsumerIntent.start(from: Fragment, onNotFound: (() -> Unit)? = null) {
    if (from.activity?.let { resolveActivity(it.packageManager) } != null) {
        from.startActivity(this)
    } else {
        onNotFound?.invoke()
    }
}
