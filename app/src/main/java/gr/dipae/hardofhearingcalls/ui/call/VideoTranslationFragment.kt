package gr.dipae.hardofhearingcalls.ui.call

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import gr.dipae.hardofhearingcalls.databinding.FragmentComposeBinding
import gr.dipae.hardofhearingcalls.ui.base.BaseFragment
import gr.dipae.hardofhearingcalls.ui.call.compose.VideoTranslationScreen
import gr.dipae.hardofhearingcalls.ui.theme.HardOfHearingCallsTheme

class VideoTranslationFragment: BaseFragment<FragmentComposeBinding>() {
    override fun getViewBinding(): FragmentComposeBinding = FragmentComposeBinding.inflate(layoutInflater)

    private val viewModel: VideoTranslationViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        setupViews()
    }

    private fun setupObservers() {
        with(viewModel) {
            navigateBack.observe(viewLifecycleOwner, Observer(::navigateBack))
        }
    }

    private fun setupViews() {
        binding.composeView.setContent {
            HardOfHearingCallsTheme {
                VideoTranslationScreen(viewModel = viewModel)
            }
        }
    }

    private fun navigateBack(unit: Unit) {
        findNavController().navigateUp()
    }
}