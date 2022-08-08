package gr.dipae.hardofhearingcalls.ui.lobby

import androidx.lifecycle.LiveData
import androidx.navigation.NavDirections
import dagger.hilt.android.lifecycle.HiltViewModel
import gr.dipae.hardofhearingcalls.domain.lobby.entity.Contact
import gr.dipae.hardofhearingcalls.ui.base.BaseViewModel
import gr.dipae.hardofhearingcalls.ui.livedata.SingleLiveEvent
import javax.inject.Inject

@HiltViewModel
class LobbyViewModel @Inject constructor(

): BaseViewModel() {

    private val _contactItems = SingleLiveEvent<List<Contact>>()
    val contactItems: LiveData<List<Contact>> = _contactItems

    private val _navigate = SingleLiveEvent<NavDirections>()
    val navigate: LiveData<NavDirections> = _navigate

    fun initLobby() {

    }

    fun handleContactClicked(contact: Contact) {
    }
}