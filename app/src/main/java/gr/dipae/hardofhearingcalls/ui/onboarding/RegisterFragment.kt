package gr.dipae.hardofhearingcalls.ui.onboarding

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import dagger.hilt.android.AndroidEntryPoint
import gr.dipae.hardofhearingcalls.R
import gr.dipae.hardofhearingcalls.databinding.FragmentComposeBinding
import gr.dipae.hardofhearingcalls.ui.base.BaseFragment
import gr.dipae.hardofhearingcalls.ui.onboarding.compose.RegisterScreen
import gr.dipae.hardofhearingcalls.ui.splash.SplashViewModel
import gr.dipae.hardofhearingcalls.ui.theme.HardOfHearingCallsTheme
import gr.dipae.hardofhearingcalls.utils.ext.safeNavigate

@AndroidEntryPoint
class RegisterFragment: BaseFragment<FragmentComposeBinding>() {
    override fun getViewBinding(): FragmentComposeBinding = FragmentComposeBinding.inflate(layoutInflater)

    private val viewModel: RegisterViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setupObservers()

        viewModel.initRegister()
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
        }
    }

    private fun navigate(directions: NavDirections) {
        findNavController().safeNavigate(directions, R.id.splashFragment)
    }
}