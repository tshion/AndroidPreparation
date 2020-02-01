package work.shion.androidpreparation.intentbuilder

import android.app.Activity
import android.content.Intent
import androidx.fragment.app.Fragment


abstract class ExecutableIntent : Intent()


/**
 * Intent(実行結果なし)
 */
class ConsumerIntent : ExecutableIntent()

/**
 * Intent の実行
 * @param activity 起動元
 * @param onNotFound 起動先が見つからない場合
 */
fun ConsumerIntent.launch(activity: Activity, onNotFound: (() -> Unit)? = null) {
    if (resolveActivity(activity.packageManager) != null) {
        activity.startActivity(this)
    } else {
        onNotFound?.invoke()
    }
}

/**
 * Intent の実行
 * @param  fragment 起動元
 * @param onNotFound 起動先が見つからない場合
 */
fun ConsumerIntent.launch(fragment: Fragment, onNotFound: (() -> Unit)? = null) {
    if (fragment.activity?.let { resolveActivity(it.packageManager) } != null) {
        fragment.startActivity(this)
    } else {
        onNotFound?.invoke()
    }
}


/**
 * Intent(実行結果あり)
 */
class SupplierIntent : ExecutableIntent()

/**
 * Intent(実行結果あり) の実行
 * @param activity 起動元
 * @param requestCode 起動要求コード
 * @param onNotFound 起動先が見つからない場合
 */
fun SupplierIntent.launch(activity: Activity, requestCode: Int, onNotFound: (() -> Unit)? = null) {
    if (resolveActivity(activity.packageManager) != null) {
        activity.startActivityForResult(this, requestCode)
    } else {
        onNotFound?.invoke()
    }
}

/**
 * Intent(実行結果あり) の実行
 * @param fragment 起動元
 * @param requestCode 起動要求コード
 * @param onNotFound 起動先が見つからない場合
 */
fun SupplierIntent.launch(fragment: Fragment, requestCode: Int, onNotFound: (() -> Unit)? = null) {
    if (fragment.activity?.let { resolveActivity(it.packageManager) } != null) {
        fragment.startActivityForResult(this, requestCode)
    } else {
        onNotFound?.invoke()
    }
}
