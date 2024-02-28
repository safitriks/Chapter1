package practice

import app.model.ComputerSpec

class ControlFlowExample {
//    private var creatorName : String? = null
//    private var computerData : ComputerSpec? = null

    private val computerData = listOf(
        ComputerSpec(
            processorName = "Intel i9",
            processorTotalCore = 8,
            isHaveIGPU = true,
            totalRamInGb = 32,
            EGPUName = "RTX 4080"
        ), // computer 1
        ComputerSpec(
            processorName = "Intel i9",
            processorTotalCore = 8,
            isHaveIGPU = false,
            totalRamInGb = 32,
            EGPUName = "RTX 4080"
        ),//computer 2
        ComputerSpec(
            processorName = "Intel i3",
            processorTotalCore = 8,
            isHaveIGPU = false,
            totalRamInGb = 16,
            EGPUName = "RTX 2080"
        )//computer 3
    )

    fun run(){
        println(checkName("safit"))
        println(checkNameUsingWhen("agustin"))
        exampleWhen()
        printSomething()
    }

    fun checkName(name : String): String {
        return if(name == null){
            "Your name still Empty"
        }else if(name.contains("Safit", ignoreCase = true)){
            "Oh Safit anak Jogja ya?"
        }else if (name.contains("Kurnia", ignoreCase = true)){
            "Oh Kurnia anak Solo?"
        } else {
            "ihhh gatau kamu disana ..."
        }
    }
    private fun checkNameUsingWhen(name: String?): String {
        //when biasanya digunakan untuk nilai fix
        return when (name) {
            "agus" -> "Apakah kamu lahir di bulan Agustus?"
            "raya" -> "Apakah kamu lahir di Hari Raya?"
            else -> {
                "Data kamu tidak ada"
            }
        }
    }
    private fun exampleWhen() {
        val contentType = ContentType.REELS
        when (contentType) {
            ContentType.PHOTO -> {
                println("konten foto")
            }

            ContentType.VIDEO -> {
                println("konten video")
            }

            ContentType.REELS -> {
                println("konten reels")
            }
        }
    }

    private var name: String? = "Tony Stark"

    private fun checkName() { //void
        //escape condition (akn dieksekusi jika namanya tdk null)
        if (name == null) return
        println("Nama anda adalah $name")
        println("Anda adalah anak pemilik BCA")
    }

    fun printSomething() {
        //for - loop 1
        for(index in 1 .. 3){
            println("ini looping ke : $index")
        }
        //for loop step looping
        for(index in 1 .. 10){
            println("ini looping ke : $index")
        }
        //for loop downTo
        for (index in 10 downTo 1 step 2){
            println("ini looping ke : $index")
        }
        //for loop manual
        for (index in computerData.indices) {
            println("${index+1} ${computerData[index]}")
        }
        //equivalent
        computerData.forEach {
            println("$it")
        }
        //
        computerData.forEachIndexed { index, computerSpec ->
            println("${index + 1}$computerSpec")
        }
        //doWhile
        var index = 0
        do {
            println(index)
            index++
        } while (index < 5)

        index = 0
        while (index < 5) {
            println(index)
            index++
        }

        //escape, and continue
        for (index in 1 .. 10) {
            if(index == 5) continue
            println("Ini looping ke : $index")
        }
        //destroy the loop
        for (index in 1 .. 10) {
            if(index == 5) break
            println("Ini looping ke : $index")
        }
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            ControlFlowExample().run()
        }
    }
    // adalah suatu kelas yang digunakan untuk identify sesuatu yang sudah fix
    enum class ContentType {
        PHOTO,VIDEO,REELS
    }
}