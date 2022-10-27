package gr.dipae.hardofhearingcalls.framework.agora

import android.content.Context
import android.view.SurfaceView
import dagger.hilt.android.qualifiers.ApplicationContext
import gr.dipae.hardofhearingcalls.data.agora.AgoraIoDataSource
import gr.dipae.hardofhearingcalls.utils.CHANNEL
import gr.dipae.hardofhearingcalls.utils.TOKEN
import io.agora.rtc2.IRtcEngineEventHandler
import io.agora.rtc2.RtcEngine
import io.agora.rtc2.video.VideoCanvas
import javax.inject.Inject

class AgoraIoDataSourceImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val mRtcEngine: RtcEngine
) : AgoraIoDataSource {

    override fun initializeAndJoinChannel(
        userJoinCallBack: (Int) -> Unit,
        userJoinErrorCallBack: () -> Unit,
        onSetupLocalFrame: (SurfaceView) -> Unit,
        onJoinedSuccessChannel: () -> Unit,
        onUserOffline: () -> Unit
    ) {
        try {
            mRtcEngine.addHandler(
                object : IRtcEngineEventHandler() {
                    // Listen for the remote user joining the channel to get the uid of the user.
                    override fun onUserJoined(uid: Int, elapsed: Int) {
                        userJoinCallBack(uid)
                    }

                    override fun onJoinChannelSuccess(channel: String?, uid: Int, elapsed: Int) {

                    }

                    override fun onUserOffline(uid: Int, reason: Int) {

                    }
                })
        } catch (e: Exception) {
            userJoinErrorCallBack()
        }

        // By default, video is disabled, and you need to call enableVideo to start a video stream.
        mRtcEngine.enableVideo()

        // Call CreateRendererView to create a SurfaceView object and add it as a child to the FrameLayout.
        val localFrame = RtcEngine.CreateRendererView(context)

        onSetupLocalFrame(localFrame)

        // Pass the SurfaceView object to Agora so that it renders the local video.
        mRtcEngine.setupLocalVideo(VideoCanvas(localFrame, VideoCanvas.RENDER_MODE_FIT, 0))

        // Join the channel with a token.
        mRtcEngine.joinChannel(TOKEN, CHANNEL, "", 0)
    }

    override fun setupRemoteVideo(uid: Int, onSetupRemoteVideo: (SurfaceView) -> Unit) {
        val remoteFrame = RtcEngine.CreateRendererView(context)
        remoteFrame.setZOrderMediaOverlay(true)
        onSetupRemoteVideo(remoteFrame)
        mRtcEngine.setupRemoteVideo(VideoCanvas(remoteFrame, VideoCanvas.RENDER_MODE_FIT, uid))
    }

    override fun stopRemoteVideo() {
        mRtcEngine.leaveChannel()
        RtcEngine.destroy()
    }
}