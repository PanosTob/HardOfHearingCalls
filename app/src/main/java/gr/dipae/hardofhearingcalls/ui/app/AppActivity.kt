package gr.dipae.hardofhearingcalls.ui.app

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
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
        // If all the permissions are granted, initialize the RtcEngine object and join a channel.
        checkSelfPermission(Manifest.permission.RECORD_AUDIO, PERMISSION_REQ_ID_RECORD_AUDIO)
        checkSelfPermission(Manifest.permission.CAMERA, PERMISSION_REQ_ID_CAMERA)
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
}