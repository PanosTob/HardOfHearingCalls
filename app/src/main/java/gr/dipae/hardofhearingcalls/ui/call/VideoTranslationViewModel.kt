package gr.dipae.hardofhearingcalls.ui.call

import android.view.SurfaceView
import androidx.lifecycle.LiveData
import dagger.hilt.android.lifecycle.HiltViewModel
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

    private val _userJoinedUI = SingleLiveEvent<Int>()
    val userJoinedUI: LiveData<Int> = _userJoinedUI

    private val _userJoinedErrorUI = SingleLiveEvent<Unit>()
    val userJoinedErrorUI: LiveData<Unit> = _userJoinedErrorUI

    private val _remoteContainerUI = SingleLiveEvent<SurfaceView>()
    val remoteContainerUI: LiveData<SurfaceView> = _remoteContainerUI

    private val _localFrameUI = SingleLiveEvent<SurfaceView>()
    val localFrameUI: LiveData<SurfaceView> = _localFrameUI

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
            }
        )
    }

    fun setupRemoteVideo(uid: Int) {
        setupRemoteVideoUseCase(uid) {
            _remoteContainerUI.value = it
        }
    }

    fun stopRemoteVideo() {
        stopRemoteVideoUseCase()
    }
}