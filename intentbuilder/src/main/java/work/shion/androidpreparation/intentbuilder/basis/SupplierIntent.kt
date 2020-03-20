package work.shion.androidpreparation.intentbuilder.basis

import android.app.Activity
import androidx.fragment.app.Fragment

class SupplierIntent : ExecutableIntent() {

    /**
     * Start an intent with getting a result from an activity.
     */
    fun start(from: Activity, requestCode: Int, onNotFound: (() -> Unit)? = null) {
        if (resolveActivity(from.packageManager) != null) {
            from.startActivityForResult(this, requestCode)
        } else {
            onNotFound?.invoke()
        }
    }

    /**
     * Start an intent with getting a result from an fragment.
     */
    fun start(from: Fragment, requestCode: Int, onNotFound: (() -> Unit)? = null) {
        if (from.activity?.let { resolveActivity(it.packageManager) } != null) {
            from.startActivityForResult(this, requestCode)
        } else {
            onNotFound?.invoke()
        }
    }
}
