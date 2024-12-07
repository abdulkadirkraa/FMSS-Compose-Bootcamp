package com.abdulkadirkara.bootcamp.nesne_tabanli.kalitim

fun main() {
    val saray = Saray(10,300)
    val villa = Villa(true,20)
    saray.pencereSayisi = 400

    val ev2= Ev(2)
    val saray1 = ev2 as Saray //as? ile mull atayabilir
    //downcasting

}