package gr.dipae.hardofhearingcalls.ui.app

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import dagger.hilt.android.AndroidEntryPoint
import gr.dipae.hardofhearingcalls.databinding.ActivityAppBinding
import gr.dipae.hardofhearingcalls.ui.base.BaseActivity
import gr.dipae.hardofhearingcalls.utils.PERMISSION_REQ_ID_CAMERA
import gr.dipae.hardofhearingcalls.utils.PERMISSION_REQ_ID_RECORD_AUDIO
import gr.dipae.hardofhearingcalls.utils.REQUESTED_VIDEO_PERMISSIONS


@AndroidEntryPoint
class AppActivity : BaseActivity<ActivityAppBinding>() {

    override fun getViewBinding(): ActivityAppBinding = ActivityAppBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onNewIntent(intent)
        setupViews()
        setupObservers()
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