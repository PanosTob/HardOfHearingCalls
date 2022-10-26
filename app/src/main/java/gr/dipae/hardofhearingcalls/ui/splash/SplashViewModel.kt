package gr.dipae.hardofhearingcalls.ui.splash

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.navigation.NavDirections
import dagger.hilt.android.lifecycle.HiltViewModel
import gr.dipae.hardofhearingcalls.ui.base.BaseViewModel
import gr.dipae.hardofhearingcalls.ui.livedata.SingleLiveEvent
import gr.dipae.hardofhearingcalls.usecase.user.UpdateUuidUseCase
import gr.dipae.hardofhearingcalls.utils.UUID
import gr.dipae.hardofhearingcalls.utils.ext.get
import gr.dipae.hardofhearingcalls.utils.ext.isNullOrEmptyOrBlank
import gr.dipae.hardofhearingcalls.utils.ext.set
import gr.dipae.hardofhearingcalls.utils.ext.uuid
import kotlinx.coroutines.delay
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val sharedPrefs: SharedPreferences
) : BaseViewModel() {

    private val _navigateUI = SingleLiveEvent<NavDirections>()
    val navigateUI: LiveData<NavDirections> = _navigateUI

    private val isNewDevice: Boolean
        get() = sharedPrefs[UUID, ""].isNullOrEmptyOrBlank

    fun initSplash() {
        launch {
            delay(1500)
            if (isNewDevice) {
                _navigateUI.value = SplashFragmentDirections.actionSplashToLogin()
                return@launch
            }
            _navigateUI.value = SplashFragmentDirections.actionSplashToLobby()
        }
    }
}