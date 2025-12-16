package edu.cesspool.metanit.chapter3_functionalProgramming

/**
 * В котлин все является объектом и функция не исключение! Поэтому и у функции есть свой тип
 * */

                                                    // ТИП:
fun hello(){println("Hello")}                       // () -> Unit
fun amount(a: Int, b: Int) : Int {return a + b}     // (Int, Int) -> Int




fun main(){
    val message: () -> Unit     // объявляем переменную
    message = ::hello           // присваеваем значение переменной

    message()                   // вызываем переменную (которая теперь функция)
}