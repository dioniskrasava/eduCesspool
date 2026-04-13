package edu.cesspool.metanit.chapter6_additionalOOPfeatures.less46_03

// Extension function with receiver
// Функции расширения с получателем


class Person {
    var name = ""
    var age = 0
}


// Функция расширения с получателем Person
//
// Получатель (receiver) - это конкретный объект, для которого вызывается лямбда
fun person(block: Person.() -> Unit): Person{
    val p = Person()
    p.block()
    return p
}

fun main(){
    // Использование (это и есть DSL!)
    val alice = person {
        name = "Alice"        // можно написать `this.name`, но this можно опустить
        age = 30              // т.е мы просто пишем name=... как будто находимся внутри объекта Person
    }

    println(alice.name)
    println(alice.age)
}