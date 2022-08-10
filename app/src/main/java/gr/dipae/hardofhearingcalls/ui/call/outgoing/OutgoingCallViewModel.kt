package gr.dipae.hardofhearingcalls.ui.call.outgoing

import androidx.lifecycle.LiveData
import androidx.navigation.NavDirections
import dagger.hilt.android.lifecycle.HiltViewModel
import gr.dipae.hardofhearingcalls.domain.lobby.entity.Contact
import gr.dipae.hardofhearingcalls.ui.base.BaseViewModel
import gr.dipae.hardofhearingcalls.ui.livedata.SingleLiveEvent
import javax.inject.Inject

@HiltViewModel
class OutgoingCallViewModel @Inject constructor(

): BaseViewModel() {

    private val _contact = SingleLiveEvent<Contact>()
    val contact: LiveData<Contact> = _contact

    private val _navigate = SingleLiveEvent<NavDirections>()
    val navigate: LiveData<NavDirections> = _navigate

    fun initOutgoingCall() {

    }
}