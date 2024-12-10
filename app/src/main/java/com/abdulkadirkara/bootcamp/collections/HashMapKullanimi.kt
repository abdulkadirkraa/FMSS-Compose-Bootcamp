package com.abdulkadirkara.bootcamp.collections

fun main() {
    val iller = HashMap<Int, String>()
    iller.put(16, "Bursa")
    iller.put(34, "İstanbul")
    iller.put(6, "Ankara")
    iller.put(35, "Zonguldak")
    iller[44] = "Malatya"

    println(iller)

    for ((key, value) in iller) {
        println("Key: $key, Value: $value")
    }

    println(iller.get(6))

    iller.put(44, "Yeni Malatya")
    println(iller)

    println("Boyut: ${iller.size}")

    iller.remove(6)
    println(iller)

    iller.clear()
    println(iller)

}