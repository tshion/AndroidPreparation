package work.shion.androidpreparation.intentbuilder

import android.Manifest
import android.app.Activity
import androidx.annotation.RequiresPermission
import androidx.fragment.app.Fragment
import work.shion.androidpreparation.intentbuilder.basis.CallIntent
import work.shion.androidpreparation.intentbuilder.basis.ConsumerIntent

/**
 * Start an intent from an activity.
 */
@RequiresPermission(Manifest.permission.CALL_PHONE)
fun CallIntent.start(from: Activity, onNotFound: (() -> Unit)? = null) {
    (this as ConsumerIntent).start(from, onNotFound)
}

/**
 * Start an intent from a fragment.
 */
@RequiresPermission(Manifest.permission.CALL_PHONE)
fun CallIntent.start(from: Fragment, onNotFound: (() -> Unit)? = null) {
    (this as ConsumerIntent).start(from, onNotFound)
}
