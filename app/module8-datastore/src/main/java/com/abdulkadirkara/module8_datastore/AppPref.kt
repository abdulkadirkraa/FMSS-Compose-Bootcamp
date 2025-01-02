package com.abdulkadirkara.module8_datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.doublePreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

class AppPref(val context: Context) {
    val Context.ds : DataStore<Preferences> by preferencesDataStore("bilgiler")

    companion object {
        val AD_KEY = stringPreferencesKey("ad")
        val YAS_KEY = intPreferencesKey("yas")
        val BOY_KEY = doublePreferencesKey("boy")
        val BEKAR_KEY = booleanPreferencesKey("bekar")
        val LISTE_KEY = stringSetPreferencesKey("liste")
        val SAYAC_KEY = intPreferencesKey("sayac")
    }

    suspend fun kayitAd(ad:String) {
        context.ds.edit {
            it[AD_KEY] = ad
        }
    }

    suspend fun okuAd():String {
        val p = context.ds.data.first()
        return p[AD_KEY] ?: "isim yok"
    }

    suspend fun silAd() {
        context.ds.edit {
            it.remove(AD_KEY)
        }
    }

    suspend fun kayitYas(yas:Int) {
        context.ds.edit {
            it[YAS_KEY] = yas
        }
    }

    suspend fun okuYas():Int {
        val p = context.ds.data.first()
        return p[YAS_KEY] ?: -1
    }

    suspend fun kayitBoy(boy:Double) {
        context.ds.edit {
            it[BOY_KEY] = boy
        }
    }

    suspend fun okuBoy():Double {
        val p = context.ds.data.first()
        return p[BOY_KEY] ?: -1.0
    }

    suspend fun kayitBekar(bekar:Boolean) {
        context.ds.edit {
            it[BEKAR_KEY] = bekar
        }
    }

    suspend fun okuBekar():Boolean {
        val p = context.ds.data.first()
        return p[BEKAR_KEY] ?: true
    }

    suspend fun kayitListe(liste:Set<String>) {
        context.ds.edit {
            it[LISTE_KEY] = liste
        }
    }

    suspend fun okuListe():Set<String> {
        val p = context.ds.data.first()
        return p[LISTE_KEY] ?: emptySet()
    }

    suspend fun kayitSayac(sayac:Int) {
        context.ds.edit {
            it[SAYAC_KEY] = sayac
        }
    }

    suspend fun okuSayac():Int {
        val p = context.ds.data.first()
        return p[SAYAC_KEY] ?: 0
    }


}