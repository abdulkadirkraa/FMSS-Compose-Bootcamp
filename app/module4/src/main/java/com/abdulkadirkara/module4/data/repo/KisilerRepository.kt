package com.abdulkadirkara.module4.data.repo

import android.content.Context
import android.widget.Toast
import com.abdulkadirkara.module4.data.datasource.KisilerDataSource
import com.abdulkadirkara.module4.data.entitiy.Kisiler

class KisilerRepository (var kds : KisilerDataSource) {

    suspend fun kaydet(kisi_ad: String, kisi_tel: String) = kds.kaydet(kisi_ad, kisi_tel)

    suspend fun guncelle(kisi_id:Int, kisi_ad: String, kisi_tel: String) = kds.guncelle(kisi_id, kisi_ad, kisi_tel)

    suspend fun ara(aramaKelimesi: String) = kds.ara(aramaKelimesi)
    suspend fun sil(kisi_id: Int) = kds.sil(kisi_id)
    suspend fun kisiYukle() : List<Kisiler> = kds.kisiYukle()

}