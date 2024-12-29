package com.abdulkadirkara.module4.data.datasource

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.abdulkadirkara.module4.data.entitiy.Kisiler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KisilerDataSource {
    suspend fun kaydet(kisi_ad: String, kisi_tel: String){
        Log.e("Kişi Kaydet", "$kisi_ad - $kisi_tel")
    }

    suspend fun guncelle(kisi_id:Int, kisi_ad: String, kisi_tel: String){
        Log.e("Kişi Güncelle", "$kisi_id - $kisi_ad - $kisi_tel")
    }

    suspend fun ara(aramaKelimesi: String){
        Log.e("Kisi Ara", aramaKelimesi)
    }
    suspend fun sil(kisi_id: Int){
        Log.e("Kişi Sil", kisi_id.toString())
    }
    suspend fun kisiYukle() : List<Kisiler> = withContext(Dispatchers.IO){
        val kisilerListesi = ArrayList<Kisiler>()
        kisilerListesi.add(Kisiler(1, "Ahmet", "123"))
        kisilerListesi.add(Kisiler(2, "Mehmet", "987"))
        kisilerListesi.add(Kisiler(3, "Ali", "111"))
        kisilerListesi.add(Kisiler(4, "Veli", "222"))
        return@withContext kisilerListesi
    }
}