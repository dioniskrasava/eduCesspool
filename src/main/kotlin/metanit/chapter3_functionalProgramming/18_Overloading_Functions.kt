package edu.cesspool.metanit.chapter3_functionalProgramming

fun main(){
    println("sum = ${sum(5,6)}")
    println("sum = ${sum(5.5, 6.3)}")
    println("sum = ${sum(5, 6.3)}")
    println("sum = ${sum(5.5, 6)}")
    println("sum = ${sum(5, 6, 7)}")
}

fun sum(a: Int, b: Int) : Int          { return a + b }
fun sum(a: Double, b: Double) : Double { return a + b }
fun sum(a: Int, b: Int, c: Int) : Int  { return a + b + c}
fun sum(a: Int, b: Double) : Double    { return a + b }
fun sum(a: Double, b: Int) : Double    { return a + b }


/**
 *
 * ПРИ ПЕРЕГРУЗКЕ ВЕРСИИ ДОЛЖНЫ РАЗЛИЧАТЬСЯ ПО ТИПУ, ПОРЯДКУ, КОЛИЧЕСТВУ ПАРАМЕТРОВ
 *
 * А НЕ ПО ТИПУ ВОЗВРАЩАЕМОГО ЗНАЧЕНИЯ
 *
 * ----------------------------------------
 * ЕСЛИ БУДЕТ СЛЕДУЮЩАЯ ПЕРЕГРУЗКА, ТО БУДЕТ ОШИБКА
 * fun sum(a: Int, b: Int) : Int {...}
 * fun sum(a: Int, b: Int) : Double {...}
 *
 *    Т.К. ПАРАМЕТРЫ ОДИНАКОВЫЕ И РАЗНИЦА ТОЛЬКО В ВОЗВРАЩАЕМОМ ТИПЕ!
 *
 * */