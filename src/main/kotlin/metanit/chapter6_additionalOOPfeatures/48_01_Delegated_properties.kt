package edu.cesspool.metanit.chapter6_additionalOOPfeatures.less48_01

import kotlin.reflect.KProperty

class SimpleDelegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        println("Кто-то хочет прочитать значение! '${property.name}'")
        return "Tom"
    }
}

class Person {
    // Теперь, когда кто-то читает name, вызывается getValue() из SimpleDelegate
    val name: String by SimpleDelegate()
}

fun main() {
    val tom = Person()
    println(tom.name) // Напечатает: Кто-то хочет прочитать значение! и затем Tom
}