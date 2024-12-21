package com.abdulkadirkara.module6

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class AnaSayfaViewModel : ViewModel() {
    var sonuc = MutableLiveData("0")
    val matematikRepository = MatematikRepository()

    fun toplamaYap(alinanSayi1: String, alinanSayi2: String) {
        CoroutineScope(Dispatchers.Main).launch {
            sonuc.value = matematikRepository.toplamaYap(alinanSayi1, alinanSayi2)
        }
    }

    fun cikarmaYap(alinanSayi1: String, alinanSayi2: String) {
        viewModelScope.launch {
            sonuc.value = matematikRepository.cikarmaYap(alinanSayi1, alinanSayi2)
        }
    }

    fun carpmaYap(alinanSayi1: String, alinanSayi2: String) {
        viewModelScope.launch {
            sonuc.value = matematikRepository.carpmaYap(alinanSayi1, alinanSayi2)
        }
    }

    fun bolmeYap(alinanSayi1: String, alinanSayi2: String) {
        viewModelScope.launch {
            sonuc.value = matematikRepository.bolmeYap(alinanSayi1, alinanSayi2)
        }
    }

}