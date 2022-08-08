package gr.dipae.hardofhearingcalls.ui.login

import androidx.lifecycle.LiveData
import androidx.navigation.NavDirections
import dagger.hilt.android.lifecycle.HiltViewModel
import gr.dipae.hardofhearingcalls.ui.base.BaseViewModel
import gr.dipae.hardofhearingcalls.ui.livedata.SingleLiveEvent
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(

): BaseViewModel() {

    private val _navigateUi = SingleLiveEvent<NavDirections>()
    val navigateUi: LiveData<NavDirections> = _navigateUi

    fun initLogin() {

    }

    fun handleRegisterClicked() {
        _navigateUi.value = LoginFragmentDirections.actionLoginToOnboarding()
    }
}