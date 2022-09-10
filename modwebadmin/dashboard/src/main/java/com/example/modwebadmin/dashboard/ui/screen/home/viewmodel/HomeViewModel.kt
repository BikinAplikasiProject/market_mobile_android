package com.example.modwebadmin.dashboard.ui.screen.home.viewmodel

import androidx.lifecycle.viewModelScope
import com.google.android.gms.maps.model.LatLng
import com.iddevops.core.main.domain.model.NOTHING
import com.iddevops.core.main.util.viewmodel.BaseViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel : BaseViewModel() {

    private val _location = MutableStateFlow(LatLng(1.35, 103.87))
    val location get() = _location as StateFlow<LatLng>
    fun updateLocation(latLng: LatLng) {
        _location.value = latLng
        updateItem()
    }

    private val _items = MutableStateFlow(
        (1..20).map {
            NOTHING().copy(value = it.toString())
        }
    )
    val item get() = _items as StateFlow<List<NOTHING>>
    private var updateItemJobRequest: Job? = null

    private var _isItemLoading = MutableStateFlow(false)
    val isItemLoading get() = _isItemLoading as StateFlow<Boolean>

    private fun updateItem() {
        updateItemJobRequest?.cancel()
        _isItemLoading.value = true
        updateItemJobRequest = viewModelScope.launch {
            delay(500)
            _items.value = _items.value.shuffled()
            _isItemLoading.value = false
        }
    }

    override fun clear() {
        TODO("Not yet implemented")
    }
}