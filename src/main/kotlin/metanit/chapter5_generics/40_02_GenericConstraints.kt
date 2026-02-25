package edu.cesspool.metanit.chapter5_generics.less40_02

//    G E N E R I C   C O N S T R A I N T S
//
//    О Г Р А Н И Ч Е Н И Е   О Б О Б Щ Е Н И Й


/**
 * Ф-я печатающая самую длинную из двух строк
 *
 *       принимает два аргумента типа Т, где Т объект,
 *                   который принадлежит классу, реализующего интерфейсы:
 *
 *                      CharSequence - последовательность символов (с методом который считает длину строки)
 *                      Comparable   - сравниваемый
 *
 * */
fun <T> printLongerString(a: T, b: T) where T : CharSequence, T : Comparable<T> {
    val longer = if (a.compareTo(b) > 0) a else b
    println("Более длинная строка: $longer (длина: ${longer.length})")
}

fun main() {
    printLongerString("кот", "котёнок")      // Более длинная строка: котёнок (длина: 7)
}