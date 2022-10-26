package gr.dipae.hardofhearingcalls.ui.login

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.navigation.NavDirections
import dagger.hilt.android.lifecycle.HiltViewModel
import gr.dipae.hardofhearingcalls.data.user.login.LoginRequest
import gr.dipae.hardofhearingcalls.domain.onboarding.entity.LoginUserResult
import gr.dipae.hardofhearingcalls.ui.base.BaseViewModel
import gr.dipae.hardofhearingcalls.ui.livedata.SingleLiveEvent
import gr.dipae.hardofhearingcalls.usecase.user.LoginUserUseCase
import gr.dipae.hardofhearingcalls.usecase.user.UpdateUuidUseCase
import gr.dipae.hardofhearingcalls.utils.ext.uuid
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val prefs: SharedPreferences,
    private val loginUserUseCase: LoginUserUseCase,
    private val updateUuidUseCase: UpdateUuidUseCase
): BaseViewModel() {

    private val _navigateUi = SingleLiveEvent<NavDirections>()
    val navigateUi: LiveData<NavDirections> = _navigateUi

    fun initLogin() {
    }

    fun handleLogin(email: String, password: String) {
        val loginRequest = LoginRequest(username = email, password = password)
        launchWithProgress {
            when(loginUserUseCase(loginRequest)) {
                LoginUserResult.SUCCESS -> {
                    updateUuidUseCase(prefs.uuid)
                }
                LoginUserResult.FAILURE -> {

                }
            }
        }
    }

    fun handleRegisterClicked() {
        _navigateUi.value = LoginFragmentDirections.actionLoginToOnboarding()
    }
}