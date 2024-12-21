package com.abdulkadirkara.module6

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MatematikDataSource {
    suspend fun toplamaYap(alinanSayi1: String, alinanSayi2: String): String = withContext(Dispatchers.IO) {
        val sayi1 = alinanSayi1.toInt()
        val sayi2 = alinanSayi2.toInt()
        return@withContext (sayi1 + sayi2).toString()
    }

    suspend fun cikarmaYap(alinanSayi1: String, alinanSayi2: String): String = withContext(Dispatchers.IO) {
        val sayi1 = alinanSayi1.toInt()
        val sayi2 = alinanSayi2.toInt()
        return@withContext (sayi1 - sayi2).toString()
    }
    suspend fun carpmaYap(alinanSayi1: String, alinanSayi2: String): String = withContext(Dispatchers.IO) {
        val sayi1 = alinanSayi1.toInt()
        val sayi2 = alinanSayi2.toInt()
        return@withContext (sayi1 * sayi2).toString()
    }
    suspend fun bolmeYap(alinanSayi1: String, alinanSayi2: String): String = withContext(Dispatchers.IO) {
        if (alinanSayi2 != "0") {
            return@withContext (alinanSayi1.toInt() / alinanSayi2.toInt()).toString()
        } else {
            return@withContext "Hata 0'a bölünmez!"
        }
    }
}