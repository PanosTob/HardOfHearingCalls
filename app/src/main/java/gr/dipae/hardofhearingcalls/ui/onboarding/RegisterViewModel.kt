package gr.dipae.hardofhearingcalls.ui.onboarding

import androidx.lifecycle.LiveData
import androidx.navigation.NavDirections
import dagger.hilt.android.lifecycle.HiltViewModel
import gr.dipae.hardofhearingcalls.ui.base.BaseViewModel
import gr.dipae.hardofhearingcalls.ui.livedata.SingleLiveEvent
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(

): BaseViewModel() {

    private val _navigate = SingleLiveEvent<NavDirections>()
    val navigateUi: LiveData<NavDirections> = _navigate

    private val _navigateBack = SingleLiveEvent<Unit>()
    val navigateBack: LiveData<Unit> = _navigateBack

    fun initRegister() {

    }

    fun handleLoginClicked() {
        _navigateBack.value = Unit
    }

    fun handleRegisterClicked(firstName: String, lastName: String, email: String, password: String, confirmPassword: String) {

    }
}