package gr.dipae.hardofhearingcalls.ui.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavDirections
import dagger.hilt.android.lifecycle.HiltViewModel
import gr.dipae.hardofhearingcalls.ui.base.BaseViewModel
import gr.dipae.hardofhearingcalls.ui.livedata.SingleLiveEvent
import kotlinx.coroutines.delay
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
) : BaseViewModel() {

    private val _navigateUI = SingleLiveEvent<NavDirections>()
    val navigateUI: LiveData<NavDirections> = _navigateUI

    fun initSplash() {
    }
}