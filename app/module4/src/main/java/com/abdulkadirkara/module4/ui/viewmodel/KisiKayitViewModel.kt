package com.abdulkadirkara.module4.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.abdulkadirkara.module4.data.repo.KisilerRepository

class KisiKayitViewModel : ViewModel(){
    var kisilerRepository = KisilerRepository()
}