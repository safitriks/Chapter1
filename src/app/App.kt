package app

import app.model.ComputerSpec

/*class app.App(var creatorName : String = "Hai") { //Default Value Constructor*/
class App(var creatorName: String?) { //Deaf value Constructor

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
    private var selectedComputer: ComputerSpec? = null

    fun run() {
        printHeader()
        getSelectedComputer()
    }
    private fun printHeader() {
        /*        //let
        creatorName?.let {*/
        /*} ?: run {
            println("This program is Open Source")
        }*/

        /* equals
        if(creatorName != null) {
            println("Created by : $creatorName")
        }else{
            println("This program is Open Source")
        }*/

        println("==============================")
        println("Created by : $creatorName")
        println("        Order PC app.App")
        println("==============================")
        computerData.forEachIndexed { index, data ->
            println("${index + 1}.${data.processorName} : ${data.EGPUName}")
        } //lambda function
        println("==============================")
    }

    private fun getSelectedComputer(){
        println("Masukkan Pilihan Anda : ")
        try {
            val selectedIndex = readln().toInt()
            if (selectedIndex in 1 .. computerData.size){
                selectedComputer = computerData[selectedIndex-1]
                println("Menu Pilihan Anda = $selectedComputer")
            }
        }catch (e : NumberFormatException){
            println("Menu Ga Ada")
            getSelectedComputer()
        }
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val app = App("Safit",) // Object of app.App
            app.run()
        }
    }
}

