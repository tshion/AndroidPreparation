package work.shion.androidpreparation.debugger.hyperion

import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.google.auto.service.AutoService
import com.willowtreeapps.hyperion.plugin.v1.Plugin
import com.willowtreeapps.hyperion.plugin.v1.PluginModule
import kotlinx.android.synthetic.main.dialog_deeplink.*
import work.shion.androidpreparation.debugger.R

@AutoService(Plugin::class)
class DeepLinkPlugin : Plugin() {
    override fun createPluginModule() = DeepLinkPluginModule()
}

class DeepLinkPluginModule : PluginModule() {
    override fun createPluginView(layoutInflater: LayoutInflater, parent: ViewGroup): View? = layoutInflater
            .inflate(R.layout.plugin_deeplink, parent, false)
            .apply {
                setOnClickListener {
                    (extension.activity as? AppCompatActivity)?.supportFragmentManager?.also {
                        DeepLinkDialog().show(it, DeepLinkDialog.TAG)
                    }
                }
            }
}

class DeepLinkDialog : DialogFragment() {

    companion object {
        val TAG = DeepLinkDialog::class.java.simpleName
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = inflater
            .inflate(R.layout.dialog_deeplink, container, false)

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater;
            builder.setView(inflater.inflate(R.layout.dialog_deeplink, null))
                    .setPositiveButton("実行") { _, _ ->
                        runCatching {
                            val uri = dialog?.dialog_deeplink_uri?.text?.toString() ?: ""
                            Intent(Intent.ACTION_VIEW, Uri.parse(uri)).also { activity?.startActivity(it) }
                        }
                    }
                    .setNegativeButton("閉じる") { _, _ ->
                        dialog?.dismiss()
                    }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    override fun onPause() {
        dismiss()
        super.onPause()
    }
}
