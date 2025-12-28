package edu.cesspool.metanit.chapter3_functionalProgramming

fun main(){
    example1()
    example2()
    example3()
    exampleAgrument()
}


/** Простой пример */
fun example1(){
    val funfun = fun(){
        println("FUN-FUN-FUN-FUN!")
    }

    funfun()
}


/** В одну строку */
fun example2(){
    val funfun = fun() = println("FFFFFFFUN!")
    funfun()
}


fun example3(){
    val sum = fun(a: Int, b: Int) : Int = a + b
    val result = sum(5,9)
    println("Summ 5 + 9 = $result")
}


//--------------------------------------------------
// АНОНИМНАЯ ФУНКЦИЯ КАК АРГУМЕНТ ФУНКЦИИ

fun exampleAgrument(){
    println("EXAMPLE TO ARGUMENT!")
    doOperating(5,7,   fun(x: Int, y: Int)       = x +  y)
    doOperating(9, 46, fun(z: Int, zz: Int): Int = z * zz)

    // С использованием функции которая возвратить анонимную функцию
    doOperating(44,55, getAnFun(1))
    doOperating(5,45, getAnFun(547))

}

fun doOperating(a: Int, b: Int, operation: (Int, Int) -> Int){
    println("Result = ${operation(a,b)}")
}

//-------------------------------------------------
// АНОНИМНУЮ ФУНКЦИЮ МОЖНО ВЕРНУТЬ

fun getAnFun(a: Int) : (Int, Int) -> Int{
    when (a){
        1 -> return fun(a: Int, b: Int) = a + b
        2 -> return fun(a: Int, b: Int) = a - b
        else -> return fun(a: Int, b: Int) = 0
    }
}


















