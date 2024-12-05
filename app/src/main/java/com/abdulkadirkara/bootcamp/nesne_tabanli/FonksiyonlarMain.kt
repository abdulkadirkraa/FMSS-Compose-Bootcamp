package com.abdulkadirkara.bootcamp.nesne_tabanli

fun main() {
    val f = Fonksiyonlar()

    f.selamla1()

    val gelenSonuc = f.selamla2()
    println("Gelen Sonuç : $gelenSonuc")

    f.selamla3("Kadir")

    f.topla(10,20)
    f.topla(10,20,30)
    f.topla(10.7,20.0)
}