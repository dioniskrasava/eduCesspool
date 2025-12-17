package edu.cesspool.metanit.chapter3_functionalProgramming

/**
 * В котлин все является объектом и функция не исключение! Поэтому и у функции есть свой тип
 * */

                                                     // ТИП:
fun hello(){println("Hello")}                        // () -> Unit
fun amount(a: Int, b: Int) : Int {return a + b}      // (Int, Int) -> Int
fun subtraction(v: Int, u: Int) : Int {return v - u} // (Int, Int) -> Int




fun main(){
    val message: () -> Unit     // объявляем переменную
    message = ::hello           // присваеваем значение переменной

    message()                   // вызываем переменную (которая теперь функция)


    //---------------------------------------------------
    val operation: (Int, Int) -> Int = ::amount
    println(operation(5,33))


    // или сразу присваеваем, а компилятор котлин сам выведет тип
    val coolOperation = ::amount
    println(coolOperation(2,7))


    // -------------------------
    println("COOL COOL FUNC")


    var coolCoolFucn = :: amount           // тип :  KFunction2<Int, Int, Int>
    println(coolCoolFucn(5,8))

    coolCoolFucn = ::subtraction          //
    println(coolCoolFucn(5,8))
}