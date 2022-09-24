package gr.dipae.hardofhearingcalls.ui.call

import android.os.Bundle
import android.view.SurfaceView
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import gr.dipae.hardofhearingcalls.R
import gr.dipae.hardofhearingcalls.databinding.FragmentComposeBinding
import gr.dipae.hardofhearingcalls.databinding.FragmentVideoCallBinding
import gr.dipae.hardofhearingcalls.ui.base.BaseFragment
import gr.dipae.hardofhearingcalls.ui.call.compose.VideoTranslationScreen
import gr.dipae.hardofhearingcalls.ui.theme.HardOfHearingCallsTheme

class VideoTranslationFragment: BaseFragment<FragmentVideoCallBinding>() {
    override fun getViewBinding(): FragmentVideoCallBinding = FragmentVideoCallBinding.inflate(layoutInflater)

    private val viewModel: VideoTranslationViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        setupViews()
    }

    private fun setupObservers() {
        with(viewModel) {
            navigateBack.observe(viewLifecycleOwner, Observer(::navigateBack))
            userJoinedUI.observe(viewLifecycleOwner, Observer(::userJoined))
            userJoinedErrorUI.observe(viewLifecycleOwner, Observer(::userJoinedError))
            remoteContainerUI.observe(viewLifecycleOwner, Observer(::setupRemoteContainer))
            localFrameUI.observe(viewLifecycleOwner, Observer(::setupLocalFrame))
        }
    }

    private fun setupViews() {
        with(binding) {

        }
    }

    private fun navigateBack(unit: Unit) {
        findNavController().navigateUp()
    }

    private fun userJoined(uid: Int) {
        activity?.runOnUiThread {
            // Call setupRemoteVideo to set the remote video view after getting uid from the onUserJoined callback.
            viewModel.setupRemoteVideo(uid)
        }
    }

    private fun userJoinedError(unit: Unit) {
        Toast.makeText(activity, getString(R.string.app_rtc_engine_error), Toast.LENGTH_LONG).show()
    }

    private fun setupRemoteContainer(remoteFrame: SurfaceView) {
        binding.remoteVideoViewContainer.addView(remoteFrame)
    }

    private fun setupLocalFrame(localFrame: SurfaceView) {
        binding.localVideoViewContainer.addView(localFrame)
    }
}