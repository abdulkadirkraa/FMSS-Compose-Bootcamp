package com.abdulkadirkara.bootcamp

fun main() {
    //1.Compile Error:
    val x = 10
    //x = 30

    //2.Runtime Error (Exception)
    val a = 10
    val b = 0
    //println("Sonuç: ${a/b}")
    try {
        println("Sonuç: ${a / b}")
        println("İşlem bitti.")
    } catch (e: Exception) {
        println("Bir hata oluştu: ${e.message}")
    }

}