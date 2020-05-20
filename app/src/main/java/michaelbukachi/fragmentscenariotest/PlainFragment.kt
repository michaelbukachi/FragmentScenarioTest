package michaelbukachi.fragmentscenariotest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_plain.*



class PlainFragment @JvmOverloads constructor(factoryProducer: (() -> ViewModelProvider.Factory)? = null) : Fragment() {

    private val viewModel: MainViewModel by activityViewModels(factoryProducer = factoryProducer)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_plain, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        message.text = viewModel.displayText
    }

}