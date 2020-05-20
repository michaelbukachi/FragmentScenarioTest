package michaelbukachi.fragmentscenariotest

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MainViewModel2 @Inject constructor(private val _text: String): ViewModel() {
    val displayText: String by lazy {
        _text
    }
}