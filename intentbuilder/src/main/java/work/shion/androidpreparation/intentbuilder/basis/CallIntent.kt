package work.shion.androidpreparation.intentbuilder.basis

import android.Manifest
import android.app.Activity
import androidx.annotation.RequiresPermission
import androidx.fragment.app.Fragment

class CallIntent : ConsumerIntent() {

    /**
     * Start an intent from an activity.
     */
    @RequiresPermission(Manifest.permission.CALL_PHONE)
    override fun start(from: Activity, onNotFound: (() -> Unit)?) {
        super.start(from, onNotFound)
    }

    /**
     * Start an intent from a fragment.
     */
    @RequiresPermission(Manifest.permission.CALL_PHONE)
    override fun start(from: Fragment, onNotFound: (() -> Unit)?) {
        super.start(from, onNotFound)
    }
}
