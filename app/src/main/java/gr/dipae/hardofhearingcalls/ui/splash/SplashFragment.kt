package gr.dipae.hardofhearingcalls.ui.splash

import android.os.Bundle
import android.view.View
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.navigation.NavDirections
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.navigation.navArgument
import androidx.navigation.navGraphViewModels
import dagger.hilt.android.AndroidEntryPoint
import gr.dipae.hardofhearingcalls.R
import gr.dipae.hardofhearingcalls.databinding.FragmentSplashBinding
import gr.dipae.hardofhearingcalls.ui.base.BaseFragment
import gr.dipae.hardofhearingcalls.ui.base.StatusBarType
import gr.dipae.hardofhearingcalls.utils.ext.safeNavigate

@AndroidEntryPoint
class SplashFragment : BaseFragment<FragmentSplashBinding>() {

    private val viewModel: SplashViewModel by navGraphViewModels(R.id.nav_splash_graph) { defaultViewModelProviderFactory }

    override fun getViewBinding(): FragmentSplashBinding = FragmentSplashBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*setFragmentResultListener(AutoUpdateFragment.AUTO_UPDATE_OPTIONAL_RESULT) { _, _ ->
            viewModel.navigateToNextScreen()
        }*/
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setupObservers()
    }

    private fun setupViews() {
        with(binding) {
        }
    }

    private fun setupObservers() {
        with(viewModel) {
            navigateUI.observe(viewLifecycleOwner, Observer(::navigate))

            initSplash()
        }
    }

    private fun showSecurityDialog(@StringRes message: Int) {
        val dialog = AlertDialog.Builder(requireContext())
            .setMessage(message)
            .setCancelable(false)
            .setPositiveButton(R.string.dialog_action_ok, null)
            .show()

        // use to prevent auto dismiss
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener {
            activity?.finish()
        }
    }

    private fun navigate(directions: NavDirections) {
        findNavController().safeNavigate(directions, R.id.splashFragment)
    }
}