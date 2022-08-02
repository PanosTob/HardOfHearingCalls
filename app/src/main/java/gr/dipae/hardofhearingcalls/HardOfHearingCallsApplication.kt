package gr.dipae.hardofhearingcalls

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HardOfHearingCallsApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        /*if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }*/

    }
}