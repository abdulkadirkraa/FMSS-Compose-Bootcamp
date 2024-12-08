package com.abdulkadirkara.bootcamp.odevler

/* Soru 1: Parametre olarak girilen kenar sayısına göre her bir iç açıyı hesaplayıp sonucu geri gönderen metod
           İç açılar toplamı = (kenar sayısı -2 ) * 180 / kenar sayısı
 */
fun Int.kenarSayisinaGoreIcAciHesapla() {
    if (this >= 3) {
        val sonuc = (this - 2) * 180.0 / this
        println("$this kenarlı çokgenin iç açısı : $sonuc")
    } else {
        println("Hatalı! Bir çokgenin en az 3 kenarı olmalıdır.")
    }
}

/* Soru 2: Parametre olarak girilen gün sayısına göre maaş hesabı yapan ve elde edilen değeri döndüren metod
           1 günde 8 saat çalışılabilir
           Çalışma saati ücreti: 40 tl
           Mesai saat ücreti: 80 tl
           150 saat üzeri mesai sayılır
 */
fun Int.gunSayisinaGoreMaasHesapla(){
    val saatlikUcret = 40
    val mesaiSaati = 150
    val mesaiUcret = 80
    val gunlukSaat = 8



    val toplamSaat = this * gunlukSaat

    val sonuc: Int
    if (this <= 0) {
        println("Geçersiz gün sayısı! Gün sayısı 0 veya negatif olamaz.")
    }else if (toplamSaat <= mesaiSaati) {
        sonuc = toplamSaat * saatlikUcret
        println("Mesai saat'ini geçmeyen birinin $this gün için maaşı: $sonuc ₺")
    } else {
        val mesaiSaat = toplamSaat - mesaiSaati
        sonuc = (mesaiSaati * saatlikUcret) + (mesaiSaat * mesaiUcret)
        println("Mesai saat'ini geçen birinin $this gün için maaşı: $sonuc ₺")
    }
}

/* Soru 3: Parametre olarak girilen otopark süresine göre otopark ücreti hesaplayarak geri döndüren metod
           1 saat = 50 tl
           1 saat aşımından sonra her 1 saat, 10 tl'dir
 */
fun otoparkUcretiHesapla(saat: Int): Int {
    return when {
        saat <= 0 -> {
            println("Hata: Park süresi 0 veya negatif olamaz.")
            -1 // Hatalı - geçersiz durumu göstermek için olmayacak bir değer döndürdüm.
        }
        saat <= 1 -> {
            50
        }
        else -> {
            50 + (saat - 1) * 10
        }
    }
}

/* Soru 4: Parametre olarak girilen kilometreyi mile dönüştürdükten sonra geri döndüren metod
           Mile = Km * 0.621
 */
fun Double.toMil(): Double {
    return if (this >= 0) {
        this * 0.621
    } else {
        println("Kilometre negatif olamaz.")
        -1.0 // Hatalı - geçersiz durumu göstermek için olmayacak bir değer döndürdüm.
    }
}

/* Soru 5: Kenarları parametre olarak girilen ve dikdörtgenin alanını hesaplayan bir metod
 */
infix fun Int.dikdortgenAlan(kenar2: Int) {
    if (this > 0 && kenar2 > 0) {
        println("Kenarları $this ve $kenar2 olan dikdörtgenin alanı: ${this * kenar2} m²")
    } else {
        println("Kenar uzunlukları pozitif olmalıdır.")
    }
}

/* Soru 6: Parametre olarak girilen sayının faktoriyel değerini hesaplayıp geri döndüren metod
 */
fun Int.faktoriyel(): Int {
    if (this < 0) {
        println("Hatalı! Negatif sayılar için faktöriyel hesaplanamaz.")
        return -1 // Hatalı - geçersiz durumu göstermek için olmayacak bir değer döndürdüm.
    }
    return if (this <= 1) 1 else this * (this - 1).faktoriyel()
}

/* Soru 7: Parametre olarak girilen kelime içinde kaç adet e harfi olduğunu gösteren metod
 */
fun String.eHarfiSayisi(): Int {
    return this.count { it == 'e' }
}

fun main() {
    // İç açı hesaplama
    println("*****************************************")
    5.kenarSayisinaGoreIcAciHesapla() // 108.0
    println("-----------------------------------------")
    3.kenarSayisinaGoreIcAciHesapla() // 60.0
    println("-----------------------------------------")
    0.kenarSayisinaGoreIcAciHesapla() // Hatalı! Bir çokgenin en az 3 kenarı olmalıdır.
    println("-----------------------------------------")
    (-5).kenarSayisinaGoreIcAciHesapla() // Hatalı! Bir çokgenin en az 3 kenarı olmalıdır.
    println("*****************************************")

    // Maaş hesaplama
    println("*****************************************")
    15.gunSayisinaGoreMaasHesapla() // 4800
    println("-----------------------------------------")
    0.gunSayisinaGoreMaasHesapla() // Geçersiz gün sayısı! Gün sayısı 0 veya negatif olamaz
    println("-----------------------------------------")
    25.gunSayisinaGoreMaasHesapla() // 10000 TL
    println("-----------------------------------------")
    (-5).gunSayisinaGoreMaasHesapla() // Geçersiz gün sayısı! Gün sayısı 0 veya negatif olamaz
    println("*****************************************")

    // Otopark ücreti hesaplama
    println("*****************************************")
    println("Otopark Ücreti: ${otoparkUcretiHesapla(5)} TL") // 90
    println("-----------------------------------------")
    println("Otopark Ücreti: ${otoparkUcretiHesapla(0)} TL") // Hata: Park süresi 0 veya negatif olamaz.
    println("-----------------------------------------")
    println("Otopark Ücreti: ${otoparkUcretiHesapla(1)} TL") //50
    println("-----------------------------------------")
    println("Otopark Ücreti: ${otoparkUcretiHesapla(-5)} TL") // Hata: Park süresi 0 veya negatif olamaz.
    println("*****************************************")

    // Kilometreyi mile çevirme
    println("*****************************************")
    println("Mil: ${10.0.toMil()} mil") // 6.21
    println("-----------------------------------------")
    println("Mil: ${(-5.0).toMil()} mil") // Kilometre negatif olamaz.
    println("-----------------------------------------")
    println("Mil: ${0.0.toMil()} mil") // 0.0
    println("*****************************************")

    // Dikdörtgen alanı hesaplama
    println("*****************************************")
    4 dikdortgenAlan 5
    println("-----------------------------------------")
    0 dikdortgenAlan 0 // Kenar uzunlukları pozitif olmalıdır.
    println("-----------------------------------------")
    1 dikdortgenAlan 0
    println("-----------------------------------------")
    0 dikdortgenAlan(-2)
    println("-----------------------------------------")
    (-2) dikdortgenAlan 5
    println("-----------------------------------------")
    5 dikdortgenAlan -5
    println("*****************************************")

    // Faktöriyel hesaplama
    println("*****************************************")
    println("Faktöriyel: ${5.faktoriyel()}") // 120
    println("-----------------------------------------")
    println("Faktöriyel: ${0.faktoriyel()}") // 1
    println("-----------------------------------------")
    println("Faktöriyel: ${(-5).faktoriyel()}") // Hatalı! Negatif sayılar için faktöriyel hesaplanamaz.
    println("-----------------------------------------")
    println("Faktöriyel: ${1.faktoriyel()}") // 1
    println("*****************************************")

    // 'e' harfi sayma
    println("*****************************************")
    println("'e' Harfi Sayısı: ${"merhaba".eHarfiSayisi()}") // 1
    println("-----------------------------------------")
    println("'e' Harfi Sayısı: ${"".eHarfiSayisi()}") // 0
    println("-----------------------------------------")
    println("'e' Harfi Sayısı: ${"kotlin".eHarfiSayisi()}") // 0
    println("*****************************************")
}
