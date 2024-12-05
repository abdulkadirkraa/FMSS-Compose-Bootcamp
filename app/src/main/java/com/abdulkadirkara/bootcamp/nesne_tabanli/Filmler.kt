package com.abdulkadirkara.bootcamp.nesne_tabanli

class Filmler(var id: Int, var ad: String, var fiyat: Double) {

    init {
        println("Filmler sınıfından nesnesi oluşturuldu")
    }

    fun filmBilgileri() {
        println("-----------------------------")
        println("Film Id    : $id")
        println("Film Ad    : $ad")
        println("Film Fiyat : ${this.fiyat}")//this bulunduğu sayfayı temsil eder
    }
    //side effect : bir metod ile sınıf değişkenlerini değiştirmek
}