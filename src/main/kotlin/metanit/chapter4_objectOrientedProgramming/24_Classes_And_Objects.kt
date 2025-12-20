package edu.cesspool.metanit.chapter4_objectOrientedProgramming

import edu.cesspool.metanit.chapter2_basics.wrap




fun ex1() {
    class Person {
        // это СВОЙСТВА класса
        // они должны быть проинициализированы
        var name: String = "Noname"
        var age: Int = 0
    }

    /** Отформатированное отображение информации об объекте*/
    fun printPersonInfo(person: Person): Unit {
        println("----------------------------")
        println(" name = ${person.name}")
        println(" age  = ${person.age}")
        println(" experimental - ${person.hashCode()}")
        println("----------------------------\n")
    }

    fun printTomAndJerryInfo(tom: Person, jerry: Person) {
        printPersonInfo(tom)
        printPersonInfo(jerry)
    }

    {
        val tom: Person = Person()
        val jerry: Person = Person()

        printTomAndJerryInfo(tom, jerry)

        tom.name = "Tom"
        tom.age = 7

        jerry.name = "Jerry"
        jerry.age = 3

        printTomAndJerryInfo(tom, jerry)
    }()

}


fun ex2(){
    class Person{
        var name: String = "Noname"
        var age: Int = 0

        fun sayHello(){
            println("$name say HELLLLLLLO!")
        }

        fun go(location: String){
            println("$name go to $location!")
        }

        fun personToString() : String{
            return "Name $name. Age $age"
        }
    }

    val tom = Person()

    tom.name = "Tom"
    tom.age = 25

    tom.sayHello()
    tom.go("Amsterdam")
    println(tom.personToString())
}



////////////////////////////////////////////////////////////////////////////
fun main(){
    wrap("EX 1"){ex1()}
    wrap("EX 2"){ex2()}
}
////////////////////////////////////////////////////////////////////////////
