package edu.cesspool.metanit.chapter4_objectOrientedProgramming.less37_02

/**
 * Н А С Л Е Д О В А Н И Е    А Н О Н И М Н Ы Х     О Б Ъ Е К Т О В
 * */

open class Person(val name: String){
    open fun sayHello(){
        println("Hi. My name is $name")
    }
}


fun main(){
    // НЕПОСРЕДСТВЕННО НАСЛЕДУЕМ :
    val tom = object :  Person("Tom"){
        val company = "JetBrain"

        override fun sayHello() {
            super.sayHello()
            println("Company = $company")
        }
    }

    tom.sayHello()

}