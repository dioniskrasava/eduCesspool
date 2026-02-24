package edu.cesspool.metanit.chapter5_generics.less40_01

//    G E N E R I C   C O N S T R A I N T S
//
//    О Г Р А Н И Ч Е Н И Е   О Б О Б Щ Е Н И Й


/*
fun <T> getBiggest(a: T, b: T): T{
    if (a > b) return a                // ERROR! (потому что есть типы которые нельзя сравнить)
    return b
}
*/

fun <T: Comparable<T>> getBiggest(a: T, b: T): T{
    if (a > b) return a
    return b
}

fun main(){
    val result1 = getBiggest(5,6)
    println(result1)

    val result2 = getBiggest("Sam", "Tom")
    println(result2)
}