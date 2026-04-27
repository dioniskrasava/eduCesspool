package edu.cesspool.metanit.chapter6_additionalOOPfeatures.less48_001

import kotlin.reflect.KProperty


class SimpleDelegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        println("Кто-то хочет прочитать значение свойства '${property.name}'!")
        return "Tom"
    }
}


class Person {
    val name: String by SimpleDelegate()
}

fun main() {
    val person = Person()
    println(person.name)
}