package com.abdulkadirkara.bootcamp.nesne_tabanli

fun main() {
    //Nullable - Null Safety - Optional(Swift)

    var yazi: String? = null

    //Yöntem 1 -> uygulama null varsa içinde çökmeyecek
    println("Yöntem 1: ${yazi?.uppercase()}")

    //Yöntem 2 -> uygulama null ise hata verecek, kodumuza güvenme iddasında bulunuyoruz
    //println("Yöntem 2: ${yazi!!.uppercase()}")

    //Yöntem 3
    if (yazi != null) {
        println("Yöntem 3: ${yazi.uppercase()}")
    } else {
        println("Yöntem 3: yazi null")
    }

    //Yöntem 4
    yazi?.let {
        println("Yöntem 4: ${yazi.uppercase()}")
    } ?: println("Yöntem 4: yazi null")


}