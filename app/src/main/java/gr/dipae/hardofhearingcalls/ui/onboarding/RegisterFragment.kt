package gr.dipae.hardofhearingcalls.ui.onboarding

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import gr.dipae.hardofhearingcalls.R
import gr.dipae.hardofhearingcalls.databinding.FragmentComposeBinding
import gr.dipae.hardofhearingcalls.ui.base.BaseFragment
import gr.dipae.hardofhearingcalls.ui.login.compose.LoginScreen
import gr.dipae.hardofhearingcalls.ui.theme.HardOfHearingCallsTheme
import gr.dipae.hardofhearingcalls.utils.ext.safeNavigate

class RegisterFragment : BaseFragment<FragmentComposeBinding>() {
    override fun getViewBinding(): FragmentComposeBinding = FragmentComposeBinding.inflate(layoutInflater)

    private val viewModel: RegisterViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        setupViews()
    }

    private fun setupViews() {
        binding.composeView.setContent {
            HardOfHearingCallsTheme {
                RegisterScreen(viewModel)
            }
        }
    }

    private fun setupObservers() {
        with(viewModel) {
            navigateUi.observe(viewLifecycleOwner, Observer(::navigate))
            navigateBack.observe(viewLifecycleOwner, Observer(::navigateBack))
        }
    }

    private fun navigate(navDirections: NavDirections) {
        findNavController().safeNavigate(navDirections, R.id.registerFragment)
    }

    private fun navigateBack(unit: Unit) {
        findNavController().navigateUp()
    }
}