// define with data types
//nama variabel-tipe data-inisiasi
val index : Int = 0 //val-> immutable(tidak bisa diubah)
var aString : String = "100/10" //var-> mutable(bisa diubah)

// define without data types
val anotherString = "loren ipsum"
val anNumber = 4
val anNumber2 = 4.2
val anNumber4 = 16947589375
//konstanta
const val anNumber3 = 16.23456789098765

//array
val arrayData : Array<String> = arrayOf("abcd","abcde")
val arrData = arrayOf("0","2","3")

//list-> tdk bisa manipulate data
val listData : List<String> = listOf("1","2","3")
val lstData = listOf("1","2","3")
//muteable list-> bisa manipulate data(lebih dinamic)
val mutableList = mutableListOf<String>("12","13","14")

val menu = "Ayam Goreng"


fun main(args: Array<String>) {
    /*    println(index) // 0
    println(aString) // 100/10
    println(arrData)
    println(listData) // 1,2,3
    println(mutableList) // 12,13,14
    aString = "Kucing"
    println(aString) // Kucing*/
    /*try{
        println(mutableList) // 12,13,14
        mutableList.add("15")
        println(mutableList) // 12,13,14,15
        mutableList.removeAt(0)
        println(mutableList) // 13,14,15
        mutableList.remove("13")
        println(mutableList) // 14,15
    }catch (e : Exception){*//*
        println("Code Error")*//*
    }*/
    printHeader()
}

fun printHeader() {
    println(menu)
    println("==============================")
    println("        Order PC app.App")
    println("==============================")
    println("1. Bundle Ryzen 5 + RTX 3060")
    println("2. Bundle Ryzen 9 + RTX 4080")
    println("3. Bundle Ryzen 17 + RTX 3060")
    println("4. Bundle Ryzen 19 + RTX 4080")
    println("==============================")
    println("Masukkan pilihan Anda : ")
    try {
        val userPick = readln().toInt()
        print("Pilihan Anda adalah $userPick")
    }catch (e : Exception){
        println("Menu Anda Salah!")
    }
    printHeader()
}