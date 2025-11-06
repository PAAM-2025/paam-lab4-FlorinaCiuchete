package com.example.lab_4.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.example.lab_4.domain.Chiuit
import com.example.lab_4.domain.ChiuitRepository

class HomeViewModel(private val chiuitRepository: ChiuitRepository) : ViewModel() {

    private val _chiuitListState = MutableStateFlow(chiuitRepository.getAll())
    val chiuitListState: StateFlow<List<Chiuit>> = _chiuitListState.asStateFlow()

    private fun retrieveChiuits() {
        _chiuitListState.value = chiuitRepository.getAll()
        Log.d("myTag1", _chiuitListState.value.toString())
    }
    fun addChiuit(chiuit: Chiuit) {
        val response = chiuitRepository.addChiuit(chiuit)
        Log.d("myTag1", response.toString())
        retrieveChiuits()
    }

    fun removeChiuit(chiuit: Chiuit) {
        chiuitRepository.removeChiuit(chiuit)
        retrieveChiuits()
    }

}