package com.abdulkadirkara.bootcamp.nesne_tabanli.interface_kullanimi

class MyClass: MyInterface {
    override val degisken: Int
        get() = 10

    override fun metod1() {
        println("Metod1 çalıştı")
    }

    override fun metod2(): String {
        return "metod2 çalıştı"
    }
}