package gr.dipae.hardofhearingcalls.data.agora

import android.view.SurfaceView
import gr.dipae.hardofhearingcalls.domain.AgoraIoRepository
import javax.inject.Inject

class AgoraIoRepositoryImpl @Inject constructor(
    private val dataSource: AgoraIoDataSource
): AgoraIoRepository {
    override fun initializeAndJoinChannel(
        userJoinCallBack: (Int) -> Unit,
        userJoinErrorCallBack: () -> Unit,
        onSetupLocalFrame: (SurfaceView) -> Unit,
        onJoinedSuccessChannel: () -> Unit,
        onUserOffline: () -> Unit
    ) {
        dataSource.initializeAndJoinChannel(
            userJoinCallBack,
            userJoinErrorCallBack,
            onSetupLocalFrame,
            onJoinedSuccessChannel,
            onUserOffline
        )
    }

    override fun setupRemoteVideo(uid: Int, onSetupRemoteVideo: (SurfaceView) -> Unit) {
        dataSource.setupRemoteVideo(uid, onSetupRemoteVideo)
    }

    override fun stopRemoteVideo() {
        dataSource.stopRemoteVideo()
    }
}