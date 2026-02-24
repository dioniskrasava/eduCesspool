package edu.cesspool.metanit.chapter5_generics.less39_03

/**
 * Данный пример демонстрирует то, что параметр Т можно использовать в методах класса
 *
 * */

class Person<T>(val id: T, val name: String){
    fun checkId(_id: T){                               //   Тут используем Т
        if (_id == id){
            println("The same")
        } else {
            println("Different")
        }
    }
}


fun main(){
    val tom: Person<Int> = Person<Int>(0, "Tom")
    val bob = Person("Второй", "Bob")

    tom.checkId(5)
    tom.checkId(0)

    bob.checkId("lol")
    bob.checkId("Second")
    bob.checkId("Второй")
}
