package edu.cesspool.metanit.chapter4_objectOrientedProgramming.less38_01


/**
 * COMPANION OBJECT - объект который позволяет определить свойства и методы,
 *                    которые будут общими для всех объектов этого класса.
 *
 *
 *    т.е. companion object определяет свойства и методы КЛАССА В ЦЕЛОМ, а не объекта.
 *
 * */

// САМЫЙ ПРОСТОЙ ПРИМЕР COMPANION OBJECT

class Person (val name: String){

    init {
        println("Создано $counter объектов Person")
        counter ++
    }

    companion object {
        var counter = 0
    }
}


fun main(){
    Person("Вася")
    Person("Петя")
    Person("Маша")

    Person.counter = 15       // МОЖНО ОБРАТИТЬСЯ К СВОЙСТВУ ОБЪЕКТА КОМПАНЬОНА и изменить его
    println(Person.counter)

}