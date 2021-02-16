package work.shion.androidpreparation.intentbuilder

import android.os.Bundle
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        LinearLayout(this)
            .apply { orientation = LinearLayout.VERTICAL }
            .let { setupUI(it) }
            .also { setContentView(it) }
    }


    protected abstract fun setupUI(root: ViewGroup): ViewGroup
}
