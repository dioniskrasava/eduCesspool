package edu.cesspool.metanit.chapter6_additionalOOPfeatures.less44_01


// Преобразование типов


// ограничение умных преобразований


fun ex1(){

    val tom = Person("Tom")

    if(tom.phone is SmartPhone){
        println("SmartPhone: ${tom.phone.name}, os: ${tom.phone.os} ") // err!
    }

}

open class Phone(val name: String)
class SmartPhone(name: String, val os: String) : Phone(name)

open class Person(val name: String){
    var phone: Phone = SmartPhone("Pixel 5", "Android")
}


fun main(){
    ex1()
}
