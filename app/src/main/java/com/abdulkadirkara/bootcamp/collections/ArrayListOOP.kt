package com.abdulkadirkara.bootcamp.collections

fun main() {
    val urun1 = Urunler(1, "TV", 34000)
    val urun2 = Urunler(2, "Bilgisayar", 25000)
    val urun3 = Urunler(3, "Anahtar", 300)

    val urunlerListesi = ArrayList<Urunler>()
    urunlerListesi.add(urun1)
    urunlerListesi.add(urun2)
    urunlerListesi.add(urun3)

    for (urun in urunlerListesi) {
        println("-----------------------------------------")
        println("ID: ${urun.id}, Ad: ${urun.ad}, Fiyat: ${urun.fiyat}")
    }

    //Sort
    println("Fiyat: Artan")
    val siralama1 = urunlerListesi.sortedWith(compareBy { it.fiyat.inc() }) //veya it.fiyat da olur
    for (urun in siralama1) {
        println("-----------------------------------------")
        println("ID: ${urun.id}, Ad: ${urun.ad}, Fiyat: ${urun.fiyat}")
    }

    println("Fiyat: Azalan")
    val siralama2 = urunlerListesi.sortedWith(compareByDescending { it.fiyat })
    for (urun in siralama2) {
        println("-----------------------------------------")
        println("ID: ${urun.id}, Ad: ${urun.ad}, Fiyat: ${urun.fiyat}")
    }

    //Filtreleme
    println("Filtreleme 1")
    val filtreleme1 = urunlerListesi.filter { it.fiyat in 10001..29999 } // it.fiyat > 10000 && it.fiyat < 30000
    for (urun in filtreleme1) {
        println("-----------------------------------------")
        println("ID: ${urun.id}, Ad: ${urun.ad}, Fiyat: ${urun.fiyat}")
    }

    println("Filtreleme 2")
    val filtreleme2 = urunlerListesi.filter { it.ad.contains("y") }
    for (urun in filtreleme2) {
        println("-----------------------------------------")
        println("ID: ${urun.id}, Ad: ${urun.ad}, Fiyat: ${urun.fiyat}")
    }

}