package gr.dipae.hardofhearingcalls.ui.livedata

import javax.inject.Inject

/*
class NetworkLiveData @Inject constructor(
    private val connectivityMonitor: ConnectivityMonitor
) : SingleLiveEvent<ConnectivityStatus>() {

    private val connectivityCallback = object : OnConnectivityChangeCallback {
        override fun onConnected() {
            postValue(ConnectivityStatus.CONNECTED)
        }

        override fun onDisconnected() {
            postValue(ConnectivityStatus.DISCONNECTED)
        }
    }

    override fun onActive() {
        super.onActive()
        connectivityMonitor.subscribeOnChanges(connectivityCallback)
    }

    override fun onInactive() {
        connectivityMonitor.unsubscribe()
        super.onInactive()
    }
}*/
