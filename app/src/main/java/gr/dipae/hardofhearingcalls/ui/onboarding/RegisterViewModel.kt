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

    private val _navigateUi = SingleLiveEvent<NavDirections>()
    val navigateUi: LiveData<NavDirections> = _navigateUi

    fun initRegister() {

    }
}