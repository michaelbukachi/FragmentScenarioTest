package michaelbukachi.fragmentscenariotest

import androidx.lifecycle.ViewModel


class MainViewModel3(private val _text: String): ViewModel() {
    val displayText: String by lazy {
        _text
    }
}