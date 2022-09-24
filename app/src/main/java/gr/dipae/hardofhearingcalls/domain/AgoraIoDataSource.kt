package gr.dipae.hardofhearingcalls.domain

import android.view.SurfaceView

interface AgoraIoDataSource {
    fun initializeAndJoinChannel(userJoinCallBack: (Int) -> Unit, userJoinErrorCallBack: () -> Unit, onSetupLocalFrame: (SurfaceView) -> Unit)

    fun setupRemoteVideo(uid: Int, onSetupRemoteVideo: (SurfaceView) -> Unit)

    fun stopRemoteVideo()
}