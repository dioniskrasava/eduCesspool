package edu.cesspool.metanit.chapter3_functionalProgramming

// Л Я М Б Д А   В Ы Р А Ж Е Н И Я

fun main(){
    exampleSimpleLambda()
    lambdaWithParametrs()
    lambdaWithParametrs2()

    lambdaManyParamet()
    lambdaWithReturn()
}

//----------------- Л Я М Б Д А---------------------

fun exampleSimpleLambda(){
    // лямбду можно присвоить переменной и вызвать
    val coolLambda = {println("Hello, WWWWWWORLD!!!")}   // тип перем. () -> Unit

    coolLambda();


    // можно сразу запустить лямбду
    // только нужно в нашем слушае НУЖНО поставить ; в предварительном
    // вызове функции

    {println("Hello Kotlin")}()
}

//-----Л Я М Б Д А   С    П А Р А М Е Т Р А М И--------

fun lambdaWithParametrs(){
    val printer = {message: String -> println(message)}
    printer("LAMD with PARAM (Print)")
}


fun lambdaWithParametrs2(){
    {message: String -> println(message)}("initFunc and coll NOW!!!")
}

fun lambdaManyParamet(){
    val sum = {a:Int, b:Int ->
        val result = a + b
        println(" result/// sum $a and $b = $result")
    }

    sum(4,84)
    sum(3,333)
}

fun lambdaWithReturn(){

    // лямбда без возврата
    val sum        = {a: Int, b: Int ->
        val result = a + b
        println("$a + $b = $result")
    }

    // такая же, но с ВОЗВРАЩАЕМЫМ значением
    val sumReturn  = {a: Int, b: Int ->
        val result = a + b
        println("$a + $b = $result")
        result
    }

    // вызовы
    sum(5,25)
    val res = sumReturn(5,25)
    println("result previous call =$res ")

    // можно вызвать без передачи возвращаемого значения, тогда выполнится


}