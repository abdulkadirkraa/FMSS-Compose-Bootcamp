package com.abdulkadirkara.bootcamp.standart_programlama

fun main(){
    //for each literatürde
    for (i in 1..5){ // swiftte for i in 1...5
        println("Döngü 1 : $i")
    }

    var sayac = 1
    while (sayac < 5){
        println("Döngü 2 : $sayac")
        sayac++
    }

    //10 ile 20 arasında 5 er artsın
    //step : infix fonksiyon
    for (i in 10..20 step 5){
        println("Döngü 3 : $i")
    }

    //20 ile 10 arasında 5 er azalsın
    for (i in 20 downTo 10 step 5){
        println("Döngü 4 : $i")
    }

    for (i in 1..5){
        if (i == 3){
            break
        }
        println("Döngü 5 : $i")
    }

    for (i in 1..5){
        if (i == 3){
            continue
        }
        println("Döngü 6 : $i")
    }

}