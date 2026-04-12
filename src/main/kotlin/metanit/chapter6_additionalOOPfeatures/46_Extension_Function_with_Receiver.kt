package edu.cesspool.metanit.chapter6_additionalOOPfeatures

// Extension function with receiver
// Функции расширения с получателем

class Person{
    var name: String = ""
    var age: Int = 0
    var company: String = ""

    fun display(){
        println("Name: $name. Age: $age. Company: $company")
    }
}


/**
 * - такого типа функции используются для создания DSL
 * - позволяют писать понятный код
 * - в данном примере наша ф-я расширяния имеет один параметр - лямбду, к-я
 *   ничего не принимает и ничего не возвращает, НО в теле данной лямбды мы
 *   имеем прекрасную возможность обращаться к полям объекта без ключевого слова this
 * */
fun Person.configure(block: Person.() -> Unit): Person{
    block()
    return this
}


fun main(){

    val person1 = Person().configure {
        name = "Tom"
        age = 41
        company = "MyCorp"
    }

    person1.display()

    //-----------------------------------------
    val person2 = Person()
    person2.display()

    // можно вызвать для существующего объекта
    person2.configure {
        this.name = "Bob"         // можно использовать this
        age = 411                 // а можно не использовать this
        company = "LolCorporations"
    }
    person2.display()
}