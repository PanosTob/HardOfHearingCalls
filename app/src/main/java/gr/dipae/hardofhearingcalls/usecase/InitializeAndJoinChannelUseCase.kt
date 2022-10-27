package gr.dipae.hardofhearingcalls.usecase

import android.view.SurfaceView
import gr.dipae.hardofhearingcalls.domain.AgoraIoRepository
import javax.inject.Inject

class InitializeAndJoinChannelUseCase @Inject constructor(
    private val repository: AgoraIoRepository
) {

    operator fun invoke(
        userJoinCallBack: (Int) -> Unit,
        userJoinErrorCallBack: () -> Unit,
        onSetupLocalFrame: (SurfaceView) -> Unit,
        onJoinedSuccessChannel: () -> Unit,
        onUserOffline: () -> Unit
    ) {
        repository.initializeAndJoinChannel(
            userJoinCallBack,
            userJoinErrorCallBack,
            onSetupLocalFrame,
            onJoinedSuccessChannel,
            onUserOffline
        )
    }
}