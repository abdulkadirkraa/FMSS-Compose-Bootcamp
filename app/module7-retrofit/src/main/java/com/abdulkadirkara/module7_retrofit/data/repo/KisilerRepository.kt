package com.abdulkadirkara.module7_retrofit.data.repo

import com.abdulkadirkara.module7_retrofit.data.datasource.KisilerDataSource
import com.abdulkadirkara.module7_retrofit.data.entity.Kisiler

class KisilerRepository(var kisilerDataSource: KisilerDataSource) {

    suspend fun kaydet(kisi_ad:String,kisi_tel:String) = kisilerDataSource.kaydet(kisi_ad, kisi_tel)

    suspend fun guncelle(kisi_id:Int,kisi_ad:String,kisi_tel:String) = kisilerDataSource.guncelle(kisi_id, kisi_ad, kisi_tel)

    suspend fun sil(kisi_id:Int) = kisilerDataSource.sil(kisi_id)

    suspend fun kisileriYukle() : List<Kisiler> = kisilerDataSource.kisileriYukle()

    suspend fun ara(aramaKelimesi:String) : List<Kisiler> = kisilerDataSource.ara(aramaKelimesi)
}