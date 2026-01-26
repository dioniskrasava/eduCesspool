package edu.cesspool.metanit.chapter4_objectOrientedProgramming

/**
 * Бывает что класс нужен лишь для того, чтобы описать один объект в программе
 * */

// глобальный анонимный объект
object anotherPerson{
    val name = "Jerry"
    val age = 5
    fun sayHello(){
        println("Hello. My name is $name")
    }
}

fun main(){

    // локальный анонимный объект
    val person = object {
        val name = "Tom"
        val age = 37
        fun sayHello(){
            println("Hi, my name is $name")
        }
    }

    println("Name = ${person.name}. Age = ${person.age}")
    person.sayHello()

    println("Name = ${anotherPerson.name}. Age = ${anotherPerson.age}")
    anotherPerson.sayHello()
}