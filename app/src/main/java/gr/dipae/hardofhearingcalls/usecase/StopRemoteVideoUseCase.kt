package gr.dipae.hardofhearingcalls.usecase

import gr.dipae.hardofhearingcalls.domain.AgoraIoRepository
import javax.inject.Inject

class StopRemoteVideoUseCase @Inject constructor(
    private val repository: AgoraIoRepository
) {
    operator fun invoke() {
        repository.stopRemoteVideo()
    }
}