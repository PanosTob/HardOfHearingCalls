package gr.dipae.hardofhearingcalls.data

import android.view.SurfaceView

interface AgoraIoRepository {

    fun initializeAndJoinChannel(userJoinCallBack: (Int) -> Unit, userJoinErrorCallBack: () -> Unit, onSetupLocalFrame: (SurfaceView) -> Unit)

    fun setupRemoteVideo(uid: Int, onSetupRemoteVideo: (SurfaceView) -> Unit)

    fun stopRemoteVideo()
}