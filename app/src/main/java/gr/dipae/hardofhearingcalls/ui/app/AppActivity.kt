package gr.dipae.hardofhearingcalls.ui.app

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import dagger.hilt.android.AndroidEntryPoint
import gr.dipae.hardofhearingcalls.R
import gr.dipae.hardofhearingcalls.databinding.ActivityAppBinding
import gr.dipae.hardofhearingcalls.ui.base.BaseActivity
import gr.dipae.hardofhearingcalls.utils.PERMISSION_REQ_ID_CAMERA
import gr.dipae.hardofhearingcalls.utils.PERMISSION_REQ_ID_RECORD_AUDIO
import io.agora.rtc2.IRtcEngineEventHandler
import io.agora.rtc2.RtcEngine
import io.agora.rtc2.video.VideoCanvas


@AndroidEntryPoint
class AppActivity : BaseActivity<ActivityAppBinding>() {

    override fun getViewBinding(): ActivityAppBinding = ActivityAppBinding.inflate(layoutInflater)

    private val viewModel: AppViewModel by viewModels()

    private var APP_ID = ""
    private var CHANNEL = ""
    private var TOKEN = ""
    private var mRtcEngine: RtcEngine? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onNewIntent(intent)
        setupViews()
        setupObservers()
    }

    private val mRtcEventHandler = object : IRtcEngineEventHandler() {
        // Listen for the remote user joining the channel to get the uid of the user.
        override fun onUserJoined(uid: Int, elapsed: Int) {
            runOnUiThread {
                // Call setupRemoteVideo to set the remote video view after getting uid from the onUserJoined callback.
                viewModel.setupRemoteVideo(uid)
            }
        }
    }

    private fun setupViews() {
        with(binding) {

        }
    }

    private fun setupObservers() {
    }

    fun handleVideoPermissions() {
        checkSelfPermission(Manifest.permission.RECORD_AUDIO, PERMISSION_REQ_ID_RECORD_AUDIO)
        checkSelfPermission(Manifest.permission.CAMERA, PERMISSION_REQ_ID_CAMERA)
    }

    private fun checkSelfPermission(permission: String, requestCode: Int): Boolean {
        if (ContextCompat.checkSelfPermission(this, permission) !=
            PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                arrayOf(permission),
                requestCode)
            return false
        }
        return true
    }

    private fun initializeAndJoinChannel() {
        try {
            mRtcEngine = RtcEngine.create(baseContext, APP_ID, mRtcEventHandler)
        } catch (e: Exception) {
            Toast.makeText(this, getString(R.string.app_rtc_engine_error), Toast.LENGTH_LONG).show()
        }

        // By default, video is disabled, and you need to call enableVideo to start a video stream.
        mRtcEngine!!.enableVideo()

        val localContainer = findViewById<FrameLayout>(R.id.local_video_view_container)
        // Call CreateRendererView to create a SurfaceView object and add it as a child to the FrameLayout.
        val localFrame = RtcEngine.CreateRendererView(baseContext)
        localContainer.addView(localFrame)
        // Pass the SurfaceView object to Agora so that it renders the local video.
        mRtcEngine!!.setupLocalVideo(VideoCanvas(localFrame, VideoCanvas.RENDER_MODE_FIT, 0))

        // Join the channel with a token.
        mRtcEngine!!.joinChannel(TOKEN, CHANNEL, "", 0)
    }

    private fun setupRemoteVideo(uid: Int) {
        val remoteContainer = findViewById<FrameLayout>(R.id.remote_video_view_container)

        val remoteFrame = RtcEngine.CreateRendererView(baseContext)
        remoteFrame.setZOrderMediaOverlay(true)
        remoteContainer.addView(remoteFrame)
        mRtcEngine!!.setupRemoteVideo(VideoCanvas(remoteFrame, VideoCanvas.RENDER_MODE_FIT, uid))
    }
}