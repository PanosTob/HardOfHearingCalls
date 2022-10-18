package gr.dipae.hardofhearingcalls.ui.base

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import gr.dipae.hardofhearingcalls.R
import gr.dipae.hardofhearingcalls.utils.*
import gr.dipae.hardofhearingcalls.utils.ext.BaseException
import gr.dipae.hardofhearingcalls.utils.misc.ConnectivityStatus

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    protected lateinit var binding: VB

    abstract fun getViewBinding(): VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding()
        setContentView(binding.root)
    }

    override fun applyOverrideConfiguration(overrideConfiguration: Configuration?) {
        if (overrideConfiguration != null) {
            val uiMode = overrideConfiguration.uiMode
            overrideConfiguration.setTo(baseContext.resources.configuration)
            overrideConfiguration.uiMode = uiMode
        }
        super.applyOverrideConfiguration(overrideConfiguration)
    }

    fun showErrorView(exception: BaseException, hideAfter: Boolean = true) {
        exception.code.let {
//            return@showErrorView when {
//                exception.code > 400 || exception.code == APPLICATION_ERROR_CODE ->
////                    customizeErrorView(message = getString(R.string.error_generic_server), hideAfter = hideAfter)
//
//                exception.code == AUTHENTICATION_ERROR_CODE ->
////                    customizeErrorView(message = getString(R.string.error_authentication), hideAfter = hideAfter)
//
//                exception.code == PAYMENT_ERROR -> {
////                    customizeErrorView(message = getString(R.string.error_payment), hideAfter = hideAfter)
//                }
//                exception.code == API_CANT_BE_REACHED -> {
////                    customizeErrorView(message = getString(R.string.api_cant_be_reached), hideAfter = hideAfter)
//                }
//                exception.code == NETWORK_ERROR_CODE -> {
//                    /*customizeErrorView(
//                        message = getString(R.string.error_internet_connection),
//                        colorRes = R.color.colorSecond,
//                        drawableRes = R.drawable.ic_no_connection,
//                        title = R.string.warning_label,
//                        hideAfter = hideAfter
//                    )*/
//                }
//
//                exception.code == TEMPORAL_BLOCKED_ERROR_CODE -> {
//                    /*customizeErrorView(
//                        message = getString(R.string.error_temporarilly_blocked),
//                        hideAfter = hideAfter
//                    )*/
//                }
//                exception.code == USER_ALREADY_EXISTS_CODE -> {
//                    /*customizeErrorView(
//                        message = getString(R.string.user_already_exists_error),
//                        hideAfter = hideAfter
//                    )*/
//                }
//                exception.code == INVALID_TOKEN_ERROR -> {
////                    customizeErrorView(message = exception.message, hideAfter = hideAfter)
//                }
//                exception.code == INVALID_PAYLOAD -> {
//                    /*customizeErrorView(
//                        message = getString(R.string.error_invalid_payload),
//                        hideAfter = hideAfter
//                    )*/
//                }
//                exception.code == INVALID_LOGIN_CREDENTIALS -> {
//                    /*customizeErrorView(
//                        message = getString(R.string.login_wrong_credentials),
//                        hideAfter = hideAfter
//                    )*/
//                }
//                exception.code == USER_CURRENTLY_UNAVAILABLE -> {
//                    /*customizeErrorView(
//                        message = getString(R.string.user_currently_unavailable_error),
//                        hideAfter = hideAfter
//                    )*/
//                }
//                exception.code == PAYMENT_NOT_INITIALIZED -> {
//                    /*customizeErrorView(
//                        message = getString(R.string.error_payment_not_initialized),
//                        hideAfter = hideAfter
//                    )*/
//                }
//                else -> /*customizeErrorView(message = exception.message, hideAfter = hideAfter)*/
//            }
        }
    }

    /*
     * connectivity
     */
    protected fun connectivityChange(connectivityState: ConnectivityStatus) {
        /*when (connectivityState) {
            ConnectivityStatus.Disconnected -> showErrorView(BaseException(NETWORK_ERROR_CODE))
            ConnectivityStatus.Connected -> hideErrorView()
        }*/
    }
}


