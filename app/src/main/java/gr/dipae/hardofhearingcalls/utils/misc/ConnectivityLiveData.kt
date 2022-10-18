package gr.dipae.hardofhearingcalls.utils.misc

import android.app.Application
import android.net.ConnectivityManager
import gr.dipae.hardofhearingcalls.ui.livedata.SingleLiveEvent

class ConnectivityLiveData(application: Application, connectivityManager: ConnectivityManager) : SingleLiveEvent<ConnectivityStatus>() {

    private val connectionMonitor = ConnectivityMonitor.getInstance(application.applicationContext, connectivityManager)

    override fun onActive() {
        super.onActive()
        connectionMonitor.startListening(::setConnected)
    }

    override fun onInactive() {
        connectionMonitor.stopListening()
        super.onInactive()
    }

    private fun setConnected(isConnected: Boolean) =
        postValue(
            when {
                isConnected -> ConnectivityStatus.Connected
                else -> ConnectivityStatus.Disconnected
            }
        )
}

enum class ConnectivityStatus {
    Connected,
    Disconnected
}