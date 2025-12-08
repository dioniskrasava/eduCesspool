package edu.cesspool.metanit.chapter2_basics

fun example1(){
    val age: Int // объявление переменной
    age = 31     // присвоение значения
    println("Мне $age лет!")
}

fun example2(){
    val age: Int = 31 // ИНИЦИАЛИЗАЦИЯ
    println("Мне $age лет!")
}

// ПРИМЕР КОНСТАНТ
const val maxAge = 120
/*
* константа ДОЛЖНА объявляться на самом верхнем уровне (вне функций и классов)
* константа ДОЛЖНА быть примитивным типом
*
* */

fun main(){
    //example1()
    example2()

    println("Maximum age = $maxAge")
}

/*
* ИНИЦИАЛИЗАЦИЯ - присвоение значения переменной сразу при объявлении переменной
* */