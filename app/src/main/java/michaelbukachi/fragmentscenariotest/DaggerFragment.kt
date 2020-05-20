package michaelbukachi.fragmentscenariotest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_dagger.*
import javax.inject.Inject


class DaggerFragment @Inject constructor(private val viewModelFactory: ViewModelProvider.Factory) : Fragment() {

    private val viewModel by viewModels<MainViewModel2>({ requireActivity() }) { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dagger, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        message.text = viewModel.displayText
    }

}
