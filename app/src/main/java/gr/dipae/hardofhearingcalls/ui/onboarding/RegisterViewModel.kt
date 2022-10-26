package gr.dipae.hardofhearingcalls.ui.onboarding

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.navigation.NavDirections
import dagger.hilt.android.lifecycle.HiltViewModel
import gr.dipae.hardofhearingcalls.R
import gr.dipae.hardofhearingcalls.data.user.register.RegistrationRequest
import gr.dipae.hardofhearingcalls.domain.onboarding.entity.RegisterUserResult
import gr.dipae.hardofhearingcalls.ui.base.BaseViewModel
import gr.dipae.hardofhearingcalls.ui.livedata.SingleLiveEvent
import gr.dipae.hardofhearingcalls.usecase.user.RegisterUserUseCase
import gr.dipae.hardofhearingcalls.usecase.user.UpdateUuidUseCase
import gr.dipae.hardofhearingcalls.utils.ext.uuid
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val prefs: SharedPreferences,
    private val registerUserUseCase: RegisterUserUseCase
): BaseViewModel() {

    private val _navigate = SingleLiveEvent<NavDirections>()
    val navigateUi: LiveData<NavDirections> = _navigate

    private val _navigateBack = SingleLiveEvent<Unit>()
    val navigateBack: LiveData<Unit> = _navigateBack

    private val _registrationError = SingleLiveEvent<Int>()
    val registrationError: LiveData<Int> = _registrationError

    fun initRegister() {

    }

    fun handleLoginClicked() {
        _navigateBack.value = Unit
    }

    fun handleRegisterClicked(firstName: String, lastName: String, email: String, password: String, confirmPassword: String) {
        if(confirmPassword != password) {
            _registrationError.value = R.string.register_error_confirm_password
        }
        val registrationRequest = RegistrationRequest(
            firstName = firstName,
            lastName = lastName,
            username = email,
            password = password,
            uuid = prefs.uuid
        )
        launchWithProgress {
            registerUserUseCase(registrationRequest)
        }
    }
}