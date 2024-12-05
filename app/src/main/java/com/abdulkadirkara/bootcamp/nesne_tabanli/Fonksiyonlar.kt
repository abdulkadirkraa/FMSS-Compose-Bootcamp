package com.abdulkadirkara.bootcamp.nesne_tabanli

class Fonksiyonlar {
    //IOS : protocol(Interface) tabanlıdır,
    //Android: fonksiyon(metod) tabanlıdır.
    var yazi = "Merhaba"
    var metin : String? = null
    lateinit var text: String

    //void
    fun selamla1(){//Swift(func)
        val sonuc = "Merhaba Ahmet"
        println(sonuc)

        text = "Merhaba Ahmet"
        text.uppercase()

    }

    //return
    fun selamla2() : String{
        val sonuc = "Merhaba Ahmet"
        return sonuc
    }

    //parametreli
    fun selamla3(isim: String){
        val sonuc = "Merhaba $isim"
        println(sonuc)
    }

    //overloading
    fun topla(sayi1: Int, sayi2: Int){
        println("İki sayının toplamı : ${sayi1 + sayi2}")
    }
    fun topla(sayi1: Int, sayi2: Int, sayi3: Int){
        println("İki sayının toplamı : ${sayi1 + sayi2 + sayi3}")
    }
    fun topla(sayi1: Double, sayi2: Double){
        println("İki sayının toplamı : ${sayi1 + sayi2}")
    }

}