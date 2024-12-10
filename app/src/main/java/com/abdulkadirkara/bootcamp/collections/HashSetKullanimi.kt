package com.abdulkadirkara.bootcamp.collections

fun main() {
    val meyveler = HashSet<String>()
    //Elemanları sırasız verir ve aynı verileri eklemez
    meyveler.add("Elma")
    meyveler.add("Muz")
    meyveler.add("Kiraz")

    println(meyveler)

    println(meyveler.elementAt(1))

    println(meyveler.size)

    for (meyve in meyveler){
        println("Sonuç: $meyve")
    }

    for ((index, meyve) in meyveler.withIndex()){
        println("Sonuç2: $index -> $meyve")
    }

    meyveler.remove("Kiraz")
    println(meyveler)

    meyveler.clear()
    println(meyveler)

}