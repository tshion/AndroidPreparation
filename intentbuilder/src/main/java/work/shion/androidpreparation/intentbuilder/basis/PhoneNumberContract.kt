package work.shion.androidpreparation.intentbuilder.basis

import android.net.Uri

interface PhoneNumberContract {

    val phoneNumber: String?
        get() = phoneUri.toString()
                .replace("${phoneUri?.scheme}:", "")

    val phoneUri: Uri?
}
