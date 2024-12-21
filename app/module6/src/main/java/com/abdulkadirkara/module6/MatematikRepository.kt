package com.abdulkadirkara.module6

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MatematikRepository() {
    var matematikDataSource = MatematikDataSource()

    suspend fun toplamaYap(alinanSayi1: String, alinanSayi2: String): String {
        return matematikDataSource.toplamaYap(alinanSayi1, alinanSayi2)
    }

    suspend fun cikarmaYap(alinanSayi1: String, alinanSayi2: String): String {
        return matematikDataSource.cikarmaYap(alinanSayi1, alinanSayi2)
    }

    suspend fun carpmaYap(alinanSayi1: String, alinanSayi2: String): String {
        return matematikDataSource.carpmaYap(alinanSayi1, alinanSayi2)
    }

    suspend fun bolmeYap(alinanSayi1: String, alinanSayi2: String): String{
        return matematikDataSource.bolmeYap(alinanSayi1, alinanSayi2)
    }
}