package edu.cesspool.metanit.chapter7_collectionsAndSequences

/*
* List - последновательный список элементов. Неизменяем (immutable).
* */

fun main(){
    example()
}

fun example(){
    val numbers = listOf(1,2,3,4)
    val names = listOf("Tom", "Bob", "Sam")

    println("===========ВЫВОД ПРОСТО=============")
    println(numbers)
    println(names)

    println("=========ВЫВОД ЧЕРЕЗ ЦИКЛ===========")
    for (person in names) println(person)

    println("=====ВЫВОД ЧЕРЕЗ toString()=========")
    println(names.toString())
}