package com.abdulkadirkara.module4.ui.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdulkadirkara.module4.data.repo.KisilerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KisiKayitViewModel @Inject constructor (var kisilerRepository : KisilerRepository) : ViewModel(){

    fun kaydet(kisi_ad: String, kisi_tel: String){
        viewModelScope.launch {
            kisilerRepository.kaydet(kisi_ad, kisi_tel)
        }
    }
}