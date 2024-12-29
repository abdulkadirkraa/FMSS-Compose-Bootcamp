package com.abdulkadirkara.module4.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdulkadirkara.module4.data.entitiy.Kisiler
import com.abdulkadirkara.module4.data.repo.KisilerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnaSayfaViewModel @Inject constructor (var kisilerRepository : KisilerRepository) : ViewModel() {
    var kisilerListesi = MutableLiveData<List<Kisiler>>()

    init {
        kisiYukle()
    }

    fun sil(kisi_id: Int){
        viewModelScope.launch {
            kisilerRepository.sil(kisi_id)
        }
    }

    fun ara(aramaKelimesi: String){
        viewModelScope.launch {
            kisilerRepository.ara(aramaKelimesi)
        }
    }

    fun kisiYukle(){
        viewModelScope.launch {
            kisilerListesi.value = kisilerRepository.kisiYukle()
        }
    }

}