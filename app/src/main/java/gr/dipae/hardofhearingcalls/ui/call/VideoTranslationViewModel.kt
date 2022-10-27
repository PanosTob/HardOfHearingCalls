package gr.dipae.hardofhearingcalls.ui.call

import android.view.SurfaceView
import androidx.lifecycle.LiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import gr.dipae.hardofhearingcalls.R
import gr.dipae.hardofhearingcalls.ui.base.BaseViewModel
import gr.dipae.hardofhearingcalls.ui.livedata.SingleLiveEvent
import gr.dipae.hardofhearingcalls.usecase.InitializeAndJoinChannelUseCase
import gr.dipae.hardofhearingcalls.usecase.SetupRemoteVideoUseCase
import gr.dipae.hardofhearingcalls.usecase.StopRemoteVideoUseCase
import javax.inject.Inject

@HiltViewModel
class VideoTranslationViewModel @Inject constructor(
    private val initializeAndJoinChannelUseCase: InitializeAndJoinChannelUseCase,
    private val setupRemoteVideoUseCase: SetupRemoteVideoUseCase,
    private val stopRemoteVideoUseCase: StopRemoteVideoUseCase
) : BaseViewModel() {

    private val _navigateBack = SingleLiveEvent<Unit>()
    val navigateBack: LiveData<Unit> = _navigateBack

    private val _localFrameVisibilityUI = SingleLiveEvent<Boolean>()
    val localFrameVisibilityUI: LiveData<Boolean> = _localFrameVisibilityUI

    private val _remoteFrameVisibilityUI = SingleLiveEvent<Boolean>()
    val remoteFrameVisibilityUI: LiveData<Boolean> = _remoteFrameVisibilityUI

    private val _userJoinedUI = SingleLiveEvent<Int>()
    val userJoinedUI: LiveData<Int> = _userJoinedUI

    private val _showMessageUI = SingleLiveEvent<Int>()
    val showMessageUI: LiveData<Int> = _showMessageUI

    private val _userJoinedErrorUI = SingleLiveEvent<Unit>()
    val userJoinedErrorUI: LiveData<Unit> = _userJoinedErrorUI

    private val _remoteContainerUI = SingleLiveEvent<SurfaceView>()
    val remoteContainerUI: LiveData<SurfaceView> = _remoteContainerUI

    private val _localFrameUI = SingleLiveEvent<SurfaceView>()
    val localFrameUI: LiveData<SurfaceView> = _localFrameUI

    private var isJoined = false

    fun initVideoTranslation() {
        initializeAndJoinChannelUseCase(
            {
                _userJoinedUI.value = it
            },
            {
                _userJoinedErrorUI.value = Unit
            },
            {
                _localFrameUI.value = it
            },
            {

            }, {

            }
        )
    }

    fun setupRemoteVideo(uid: Int) {
        setupRemoteVideoUseCase(uid) {
            _remoteContainerUI.value = it
        }
    }

    fun leaveChannel() {
        if (!isJoined) {

        } else {
            stopRemoteVideoUseCase()
            _showMessageUI.value = R.string.video_translation_left_channel
            // Stop remote video rendering.
            _remoteFrameVisibilityUI.value = false
            // Stop local video rendering.
            _localFrameVisibilityUI.value = false
            isJoined = false
        }
    }
}