package edu.cesspool.metanit.chapter4_objectOrientedProgramming.less38_03

open class Person(val name: String){
    init {
        counter++
    }

    companion object {
       private var counter = 0
        fun printCounter() = println("Counter = $counter")
    }

}


class Employee(name: String) : Person(name)

fun main(){
    Person.printCounter()
    val tom = Employee("Tom")
    Person.printCounter()
    //Employee.printCounter()    // так нельзя!!!!
}