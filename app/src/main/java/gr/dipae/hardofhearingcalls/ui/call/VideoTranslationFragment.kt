package gr.dipae.hardofhearingcalls.ui.call

import android.os.Bundle
import android.view.SurfaceView
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import gr.dipae.hardofhearingcalls.R
import gr.dipae.hardofhearingcalls.databinding.FragmentVideoCallBinding
import gr.dipae.hardofhearingcalls.ui.base.BaseFragment

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
            remoteFrameVisibilityUI.observe(viewLifecycleOwner, Observer(::remoteFrameVisibility))
            localFrameVisibilityUI.observe(viewLifecycleOwner, Observer(::localFrameVisibility))
            showMessageUI.observe(viewLifecycleOwner, Observer(::showMessage))

            initVideoTranslation()
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

    private fun remoteFrameVisibility(visibility: Boolean) {
        binding.remoteVideoViewContainer.isVisible = visibility
    }

    private fun localFrameVisibility(visibility: Boolean) {
        binding.localVideoViewContainer.isVisible = visibility
    }

    private fun showMessage(stringRes: Int) {
        Toast.makeText(activity, getString(stringRes), Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.leaveChannel()
    }
}