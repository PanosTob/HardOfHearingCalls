package gr.dipae.hardofhearingcalls.usecase

import android.view.SurfaceView
import gr.dipae.hardofhearingcalls.data.AgoraIoRepository
import javax.inject.Inject

class SetupRemoteVideoUseCase @Inject constructor(
    private val repository: AgoraIoRepository
) {
    operator fun invoke(uid: Int, onSetupRemoteVideo: (SurfaceView) -> Unit) {
        repository.setupRemoteVideo(uid, onSetupRemoteVideo)
    }
}