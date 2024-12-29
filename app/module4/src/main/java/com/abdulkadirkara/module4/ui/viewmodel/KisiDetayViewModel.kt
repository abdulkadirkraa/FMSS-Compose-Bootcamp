package com.abdulkadirkara.module4.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdulkadirkara.module4.data.repo.KisilerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KisiDetayViewModel @Inject constructor (var kisilerRepository : KisilerRepository) : ViewModel() {

    fun guncelle(kisi_id:Int, kisi_ad: String, kisi_tel: String) {
        viewModelScope.launch {
            kisilerRepository.guncelle(kisi_id, kisi_ad, kisi_tel)
        }
    }
}