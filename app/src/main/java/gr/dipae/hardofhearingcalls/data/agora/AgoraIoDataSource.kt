package gr.dipae.hardofhearingcalls.data.agora

import android.view.SurfaceView

interface AgoraIoDataSource {
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