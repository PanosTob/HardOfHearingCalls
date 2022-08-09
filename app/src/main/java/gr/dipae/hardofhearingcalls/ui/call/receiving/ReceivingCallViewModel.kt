package gr.dipae.hardofhearingcalls.ui.call.receiving

import androidx.lifecycle.LiveData
import androidx.navigation.NavDirections
import dagger.hilt.android.lifecycle.HiltViewModel
import gr.dipae.hardofhearingcalls.ui.base.BaseViewModel
import gr.dipae.hardofhearingcalls.ui.livedata.SingleLiveEvent
import javax.inject.Inject

@HiltViewModel
class ReceivingCallViewModel @Inject constructor(

): BaseViewModel() {

    private val _navigate = SingleLiveEvent<NavDirections>()
    val navigate: LiveData<NavDirections> = _navigate

    fun initReceivingCall() {

    }
}