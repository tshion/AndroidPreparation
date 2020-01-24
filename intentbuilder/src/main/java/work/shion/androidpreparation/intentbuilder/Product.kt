package work.shion.androidpreparation.intentbuilder

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import androidx.fragment.app.Fragment


abstract class ExecutableIntent : Intent()

/** 起動できるかどうか */
fun ExecutableIntent.canLaunch(packageManager: PackageManager) = resolveActivity(packageManager) != null


/**
 * 実行結果を受け取れないIntent
 */
class ConsumerIntent : ExecutableIntent()

/** @throws Exception */
fun ConsumerIntent.launch(activity: Activity) = activity.startActivity(this)

/** @throws Exception */
fun ConsumerIntent.launch(fragment: Fragment) = fragment.startActivity(this)


/** 実行結果を受け取ることができるIntent */
class SupplierIntent : ExecutableIntent()

/** @throws Exception */
fun SupplierIntent.launch(activity: Activity, requestCode: Int) = activity.startActivityForResult(this, requestCode)

/** @throws Exception */
fun SupplierIntent.launch(fragment: Fragment, requestCode: Int) = fragment.startActivityForResult(this, requestCode)
