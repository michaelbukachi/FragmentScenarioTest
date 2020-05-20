package michaelbukachi.fragmentscenariotest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    override fun getDefaultViewModelProviderFactory(): ViewModelProvider.Factory {
        return MainViewModelFactory("This is a message")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
