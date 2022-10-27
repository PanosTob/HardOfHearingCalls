package gr.dipae.hardofhearingcalls.domain

import android.view.SurfaceView

interface AgoraIoRepository {

    fun initializeAndJoinChannel(
        userJoinCallBack: (Int) -> Unit,
        userJoinErrorCallBack: () -> Unit,
        onSetupLocalFrame: (SurfaceView) -> Unit,
        onJoinedSuccessChannel: () -> Unit,
        onUserOffline: () -> Unit
    )

    fun setupRemoteVideo(uid: Int, onSetupRemoteVideo: (SurfaceView) -> Unit)

    fun stopRemoteVideo()
}