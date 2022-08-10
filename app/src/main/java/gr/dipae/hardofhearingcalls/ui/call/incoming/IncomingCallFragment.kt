package gr.dipae.hardofhearingcalls.ui.call.incoming

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import gr.dipae.hardofhearingcalls.R
import gr.dipae.hardofhearingcalls.databinding.FragmentComposeBinding
import gr.dipae.hardofhearingcalls.ui.base.BaseFragment
import gr.dipae.hardofhearingcalls.ui.call.incoming.compose.IncomingCallScreen
import gr.dipae.hardofhearingcalls.ui.theme.HardOfHearingCallsTheme
import gr.dipae.hardofhearingcalls.utils.ext.safeNavigate

class IncomingCallFragment: BaseFragment<FragmentComposeBinding>() {
    override fun getViewBinding(): FragmentComposeBinding = FragmentComposeBinding.inflate(layoutInflater)

    private val viewModel: IncomingCallViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        setupViews()
    }

    private fun setupViews() {
        binding.composeView.setContent {
            HardOfHearingCallsTheme {
                IncomingCallScreen(viewModel = viewModel)
            }
        }
    }

    private fun setupObservers() {
        with(viewModel) {
            navigate.observe(viewLifecycleOwner, Observer(::navigate))

            initIncomingCall()
        }
    }

    private fun navigate(navDirections: NavDirections) {
        findNavController().safeNavigate(navDirections, R.id.outgoingCallFragment)
    }
}