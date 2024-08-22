package com.plavsic.skytrace.features.map.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plavsic.skytrace.features.map.repository.FlightTrackerRepository
import com.plavsic.skytrace.features.map.model.FlightResponse
import com.plavsic.skytrace.utils.resource.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FlightTrackerViewModel @Inject constructor(
    private val repository: FlightTrackerRepository
):ViewModel() {


    private val _state:MutableState<UIState<List<FlightResponse>>> = mutableStateOf((UIState.Loading))
    val flights: State<UIState<List<FlightResponse>>> = _state


//    init {
//        fetchFlights()
//    }

    fun fetchFlights(){
        viewModelScope.launch {
            _state.value = UIState.Loading
            delay(1000)
            val response = repository.getFlights(limit = 5)
            _state.value = response
        }
    }


}