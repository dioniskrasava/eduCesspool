package edu.cesspool.metanit.chapter5_generics.less39_02

/**
 * Дженерики (обобщения) позволяют писать классы, функции, интерфейсы,
 * работающие с разными типами данных.
 *
 * Вместо того чтобы писать разные реализации для каждого типа, мы используем параметры типа.
 * */

// Принято вроде как писать <T>, но на самом деле можно написать любое имя для переменного параметра

class Box<Type>(val value: Type)

fun main(){
    val intBox    = Box(42)              // или    Box<Int>(42)
    val stringBox = Box("Привет")        // или    Box<String>("Привет")

    println(intBox.value)
    println(stringBox.value)

    // О Б О Б Щ Е Н Н Ы Е   Ф У Н К Ц И И  ( з а п у с к )
    println("---------------------------------------")
    printContent(302)
    printContent("Kotlin")
    printContent(3.14159264)


}


/* О Б О Б Щ Е Н Н А Я   Ф У Н К Ц И Я */
fun <T> printContent(item: T){
    println("Содержимое : $item")
}

