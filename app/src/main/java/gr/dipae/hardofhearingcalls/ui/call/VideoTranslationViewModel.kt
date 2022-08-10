package gr.dipae.hardofhearingcalls.ui.call

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import gr.dipae.hardofhearingcalls.ui.base.BaseViewModel
import gr.dipae.hardofhearingcalls.ui.livedata.SingleLiveEvent
import javax.inject.Inject

@HiltViewModel
class VideoTranslationViewModel @Inject constructor(

): BaseViewModel() {

    private val _navigateBack = SingleLiveEvent<Unit>()
    val navigateBack: LiveData<Unit> = _navigateBack

    fun initVideoTranslation() {

    }
}