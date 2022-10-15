package gr.dipae.hardofhearingcalls.data.agora

import android.view.SurfaceView
import gr.dipae.hardofhearingcalls.data.agora.AgoraIoDataSource
import gr.dipae.hardofhearingcalls.domain.AgoraIoRepository
import javax.inject.Inject

class AgoraIoRepositoryImpl @Inject constructor(
    private val dataSource: AgoraIoDataSource
): AgoraIoRepository {
    override fun initializeAndJoinChannel(userJoinCallBack: (Int) -> Unit, userJoinErrorCallBack: () -> Unit, onSetupLocalFrame: (SurfaceView) -> Unit) {
        dataSource.initializeAndJoinChannel(userJoinCallBack, userJoinErrorCallBack, onSetupLocalFrame)
    }

    override fun setupRemoteVideo(uid: Int, onSetupRemoteVideo: (SurfaceView) -> Unit) {
        dataSource.setupRemoteVideo(uid, onSetupRemoteVideo)
    }

    override fun stopRemoteVideo() {
        dataSource.stopRemoteVideo()
    }
}