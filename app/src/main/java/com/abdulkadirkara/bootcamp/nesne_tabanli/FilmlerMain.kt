package com.abdulkadirkara.bootcamp.nesne_tabanli

fun main() {
    //Nesne Oluşturma
    val film1 = Filmler(1,"Django",78.99)
    val film2 = Filmler(2,"Avatar",100.45)

    //Değer okuma
    film1.filmBilgileri()
    film2.filmBilgileri()

    //Değer atama
    film1.fiyat = 99.99
    film1.filmBilgileri()


}