package practice

import jdk.jfr.Event

class SolidPrinciplesExample {
}

class CalculatorWrong(){
    fun plus(a : Int, b : Int){
        val result = a + b
        println("Result = $result")
    }
}

class CalculatorRight(){
    fun plus(a : Int, b : Int): Int{
        return a+b
    }

    fun showResult(result : Number){
        println("The Result is $result")
    }
}

class RockPaperScissor(){
    private var playerOne = -1
    private var playerTwo = -1

    private fun printOption(){
        println(
            """
                ========================
                GUNTING BATU KERTAS
                ========================
                OPTION
                0. BATU
                1. GUNTING
                2. KERTAS
            """.trimIndent()
        )
    }

    private fun showResult(playerOne : Int, playerTwo : Int): String{
        return if (((playerOne + 1) % 3) == playerTwo){
            "Player 2 Menang"
        }else if(playerOne == playerTwo){
            "Seri"
        }else{
            "Player 1 Menang"
        }
    }

    private fun inputPlayerOne(){
        println("Masukkan pilihan 1 (0/1/2)")
        playerOne = readln().toInt()
    }

    private fun inputPlayerTwo(){
        println("Masukkan pilihan 2 (0/1/2)")
        playerTwo = readln().toInt()
    }

    fun run(){
        printOption()
        inputPlayerOne()
        inputPlayerTwo()
        showResult(playerOne, playerTwo)
    }
}

//fun main(args: Array<String>) {
//    RockPaperScissor().run()
//}

// Open - Close

open class IronManSuit(){
    open fun blast(){
        println("Blast using laser powered by Arc Reactor")
    }
    fun activateAI(){
        println("Jarvis is active")
    }
}

class WarMachineSuit() : IronManSuit() {
    override fun blast() {
//        super.blast()
        println("Blast from war machine suit")
    }
}

///Listkov Subtitution

class Capadocia(){
    private lateinit var balloon : RedHotAirBalloon

    fun run(){
        balloon= RedHotAirBalloon()
        balloon.apply {
            carryPassengers()
            blow()
            pop()
        }
    }
}

fun main(args: Array<String>) {
    Capadocia().run()
}

// Interface Segregation
interface Animal{
    fun eat()
    fun hunt()
    fun walking()
    fun jump()
    fun sleep()
    fun breath()

}
interface Aves : Animal {
    fun twit()
    fun fly()
}

interface Fish : Animal {
    fun swim()
}

class Bird(): Animal {
    override fun breath() {
        TODO("Not yet implemented")
    }

    override fun jump() {
        TODO("Not yet implemented")
    }

    override fun hunt() {
        TODO("Not yet implemented")
    }

    override fun eat() {
        TODO("Not yet implemented")
    }

    override fun sleep() {
        TODO("Not yet implemented")
    }

    override fun walking() {
        TODO("Not yet implemented")
    }

}

// Dependency Inversion
class FirebaseAnalytics(){
    fun log(event: String){
        println("Logging to firebase : Event Name : $event")
        Thread.sleep(2000)
        println("Logging success")
    }
}

class NewRelicAnalytics(){
    fun log(event: String){
        println("Logging to newrelic : Event Name : $event")
        Thread.sleep(2000)
        println("Logging success")
    }
}

interface Analytics {
    fun logEvent(event: String)
}

// Agnostic class
class AppAnalytics : Analytics {
    private var firebaseAnalytics = FirebaseAnalytics()
    private var newRelicAnalytics = NewRelicAnalytics()

    override fun logEvent(event: String) {
        firebaseAnalytics.log(event)
        newRelicAnalytics.log(event)
    }
}

class HomePage(private val analytics: Analytics){
    fun openPageLogin(){
        println("Open page home")
        analytics.logEvent("Homepage")
    }
}

class App(){
    private val analytics = AppAnalytics()
    fun run(){
        HomePage(analytics).openPageLogin()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            App().run()
        }
    }
}