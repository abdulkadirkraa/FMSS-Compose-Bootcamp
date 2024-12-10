package com.abdulkadirkara.bootcamp.collections

fun main() {
    // Tanımlama
    val meyveler = ArrayList<String>()
    meyveler.add("Elma") //0
    meyveler.add("Muz") //1
    meyveler.add("Kiraz")
    meyveler.add("Çilek")
    meyveler.add("Kivi")

    println(meyveler.toString())
    println(meyveler)

    //Update
    meyveler[1] = "Yeni Muz"
    println(meyveler)

    //Insert
    meyveler.add(1, "Portakal")
    println(meyveler)

    //Okuma
    println(meyveler.get(2))
    println(meyveler[2])

    println("Boyut: ${meyveler.count()}")
    println("Boyut: ${meyveler.size}")

    meyveler.reverse()
    println(meyveler)

    meyveler.sort()
    println(meyveler)

    for (meyve in meyveler) {
        println("Sonuç: $meyve")
    }

    for ((index, meyve) in meyveler.withIndex()) {//Swift enumerated()
        println("Sonuç2: $index -> $meyve")
    }

    meyveler.removeAt(3)
    println(meyveler)

    meyveler.clear()
    println(meyveler)

}