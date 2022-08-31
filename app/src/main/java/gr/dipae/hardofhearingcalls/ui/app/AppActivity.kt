package gr.dipae.hardofhearingcalls.ui.app

import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import gr.dipae.hardofhearingcalls.databinding.ActivityAppBinding
import gr.dipae.hardofhearingcalls.ui.base.BaseActivity

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
            val view = org.
        }
    }

    private fun setupObservers() {
    }

    /*fun setupJitsiMeetOptions() {
        val defaultOptions = JitsiMeetConf
    }*/
}