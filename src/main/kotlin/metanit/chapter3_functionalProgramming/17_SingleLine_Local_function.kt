package edu.cesspool.metanit.chapter3_functionalProgramming
// ОДНОСТРОЧНЫЕ И ЛОКАЛЬНЫЕ ФУНКЦИИ

fun main(){
    println("Square 15 = ${square(15)}")

}

// fun имя_функции (параметры_функции) = тело_функции
//
// слова return                 - нет
// типа возвращаемого значения  - нет

fun square(x: Int) = x * x
