package com.abdulkadirkara.bootcamp.nesne_tabanli

fun main() {
    ucret(43,Konserve.BUYUK)
}

fun ucret(adet:Int, boyut:Konserve ){
    when(boyut){
        Konserve.KUCUK -> println("Ücret : ${adet*22}")
        Konserve.ORTA -> println("Ücret : ${adet*56}")
        Konserve.BUYUK -> println("Ücret : ${adet*78}")
    }
}