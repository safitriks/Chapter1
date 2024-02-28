package practice
// Encapsulation
private class AClass() {
    private fun run() {
        println("This is from class A")
    }
    fun runPublic(){
        println("This is from class A in public")
    }
}

class BClass() {
    fun run() {
        //we can't call run bcs it's private
        //AClass().run()
        AClass().runPublic()
        println("This is from class B")
    }
}

// Abstraction
interface  Balloon{
    fun blow()
    fun pop()
}

abstract class HotAirBallon() : Balloon{
    override fun blow(){
        println("Blow the balloon using hot air")
    }

    override fun pop() {
        println("DANGER!!!")
    }
    //wajib untuk diimplement di turunan classnya
    abstract fun carryPassengers()
}

class RedHotAirBalloon() : HotAirBallon(){
    //wajib untuk diimplement di turunan classnya
    override fun carryPassengers() {
        println("Carrying 5 passenger")
    }

    override fun blow() {
        print("blowing the ballomn using doa")
    }
    // overloading
    fun blow(name: String){
    }
}
class BlueHotAirBalloon() : HotAirBallon(){
    //wajib untuk diimplement di turunan classnya
    override fun carryPassengers() {
        println("Carrying 5 passenger")
    }

    override fun blow() {
        print("blowing the ballomn using doa")
    }
    // overloading
    fun blow(name: String){
    }
}

class RedBalloon() : Balloon {
    override fun blow(){
        println("Meniup balon merah...")
    }
    override fun pop(){
        println("Balon merah meledak !!!...")
    }
}

class BlueBalloon() : Balloon {
    override fun blow(){
        println("Meniup balon biru...")
    }
    override fun pop(){
        println("Balon biru meledak !!!...")
    }
}
//inheritance using open class
open class Processor(val name: String){
    fun iniProcessor(){
        println("Initialize...$name")
    }
}

class AMDProcessor() : Processor("Ryzen 9")
class IntelProcessor() : Processor("i3")

fun main(args: Array<String>) {
    RedHotAirBalloon().let {
        // sifat kakek
        it.blow()
        it.pop()
        // sifat bapak
        it.carryPassengers()
    }
    AMDProcessor().iniProcessor()
    IntelProcessor().iniProcessor()
}