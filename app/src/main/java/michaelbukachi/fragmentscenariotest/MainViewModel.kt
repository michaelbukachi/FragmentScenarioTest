package michaelbukachi.fragmentscenariotest

import androidx.lifecycle.ViewModel

class MainViewModel(private val _text: String): ViewModel() {
    val displayText: String by lazy {
        _text
    }
}