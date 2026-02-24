package edu.cesspool.metanit.chapter5_generics.less39_05

/**
 * П Р И М Е Н Е Н И Е   Н Е С К О Л Ь К И Х   П А Р А М Е Т Р О В
 * */

fun main(){
    val word1: Word<String, String> = Word("one", "один")
    val word2 = Word(5, "five")


    println("${word1.source} - ${word1.targed}")
    println("${word2.source} - ${word2.targed}")
}


// КЛАСС С ДВУМЯ ПАРАМЕТРАМИ
//
//               (параметры типа)
//                       или
//            (обобщенные параметры)

class Word<K,V>(val source: K, val targed: V)