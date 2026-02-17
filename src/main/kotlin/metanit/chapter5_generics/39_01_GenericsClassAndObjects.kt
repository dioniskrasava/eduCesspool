package edu.cesspool.metanit.chapter5_generics



/**
 * Один из вариантов использования дженериков (обобщений).
 *
 * Используем их когда не знаем какой тип будет использоваться для параметра
 *
 * */
class Person<T>(val id: T, val name: String)

fun main(){
    val tom = Person(1, "Tom")                 // тип объекта Person<Int>
    val bob = Person("второй объект", "Bob")   // тип объекта Person<String>


    // можно еще вот так создавать объекты
    val sam : Person<Int> = Person<Int>(2, "Sam")


    println("Person1 id = ${tom.id}, name = ${tom.name}")
    println("Person2 id = ${bob.id}, name = ${bob.name}")
}