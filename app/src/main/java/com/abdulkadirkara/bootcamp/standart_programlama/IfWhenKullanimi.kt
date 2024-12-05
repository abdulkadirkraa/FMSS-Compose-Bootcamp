package com.abdulkadirkara.bootcamp.standart_programlama

fun main(){
    val yas = 20
    val ad = "Kadir"
    val ka = "admin"
    val s = 123
    val sayi = 10

    println(yas >= 18)

    if (yas >= 18){
        println("Reşitsiniz")
    }else{
        println("Reşit değilsiniz")
    }

    if (ad == "Kadir"){
        println("Merhaba $ad")
    }else if (ad == "Admin"){
        println("Merhaba $ka")
    }else{
        println("Merhaba Yabancı")
    }

    if (ka == "admin" && s == 123){//&& = ve (and) : true && true = true olur, diğer durumlarda hep false
        println("Hoşgeldiniz")
    }else{
        println("Hatalı Giriş")
    }

    if(sayi == 10 || sayi == 20) {// || = veya (or) : false || false = false olur, diğer durumlarda hep true
        println("Sayı 10 veya 20")
    }else{
        println("Sayı 10 veya 20 değil")
    }

    //Switch case
    val x = 3
    when(x){
        1 -> println("x 1'dir")
        2 -> println("x 2'dir")
        else -> println("x 1 veya 2 değildir")
    }

}