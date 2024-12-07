package com.abdulkadirkara.bootcamp.nesne_tabanli.kalitim.override_kullanimi

fun main() {
    val hayvan = Hayvan()
    hayvan.sesCikar()//Kalıtım yok, kendi sınıf metoduna erişti

    val memeli = Memeli()
    memeli.sesCikar()//Kalıtım var, üst sınıfın metoduna erişti

    val kedi = Kedi()
    kedi.sesCikar()//Kalıtım var, kendi metoduna erişti

    val kopke = Kopek()
    kopke.sesCikar()//Kalıtım var, kendi metoduna erişti
}