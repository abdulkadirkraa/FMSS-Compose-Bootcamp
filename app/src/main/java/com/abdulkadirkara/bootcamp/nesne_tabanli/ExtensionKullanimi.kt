package com.abdulkadirkara.bootcamp.nesne_tabanli

fun main() {
    val sonuc = 5.carp(2)
    println("Sonuç: $sonuc")

    val sonuc2 = 5 topla 3
    println("Sonuç2: $sonuc2")
}

fun Int.carp(sayi: Int): Int {
    return this * sayi
}

infix fun Int.topla(sayi: Int): Int {
    return this + sayi
}