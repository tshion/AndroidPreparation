package work.shion.androidpreparation.baser

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * エントリーポイントとなるActivity
 *
 * * Layout を参照するには@id/entrypoint_host を利用する
 * * Navigation はres/navigation/entrypoint.xml で定義する
 * * Navigation を参照するには@id/nav_entrypoint を利用する
 */
abstract class EntryPointActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.entrypoint)
    }
}
