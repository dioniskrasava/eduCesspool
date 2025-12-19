package edu.cesspool.metanit.chapter3_functionalProgramming

import edu.cesspool.metanit.chapter2_basics.wrap

// Л Я М Б Д А   В Ы Р А Ж Е Н И Я

fun main(){
    exampleSimpleLambda()
    lambdaWithParametrs()
    lambdaWithParametrs2()

    lambdaManyParamet()
    lambdaWithReturn()

    lambdaHowArgumentFunction()
    wrap("EXAMPLE TYPES LAMBDA PARAMETERS"){exampleTypesLambdaParametrs()}
    wrap("trailing lambda"){trailingLambda()}
    wrap("RETURN LAMBDA"){returnLambda()}

}

// -----------------------------------------------------------------
//                                                                 -
//                            Л Я М Б Д А                          -
//                                                                 -
// -----------------------------------------------------------------

fun exampleSimpleLambda(){
    // лямбду можно присвоить переменной и вызвать
    val coolLambda = {println("Hello, WWWWWWORLD!!!")}   // тип перем. () -> Unit

    coolLambda();


    // можно сразу запустить лямбду
    // только нужно в нашем случае НУЖНО поставить ; в предварительном
    // вызове функции

    {println("Hello Kotlin")}()
}

// -----------------------------------------------------------------
//                                                                 -
//            Л Я М Б Д А   С    П А Р А М Е Т Р А М И             -
//                                                                 -
// -----------------------------------------------------------------

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

// -----------------------------------------------------------------
//                                                                 -
//      В О З В Р А Щ Е Н И Е     Р Е З У Л Ь Т А Т А              -
//                                                                 -
// -----------------------------------------------------------------

fun lambdaWithReturn(){

    //   лямбда БЕЗ ВОЗВРАТА
    val sum        = {a: Int, b: Int ->
        val result = a + b
        println("$a + $b = $result")
    }

    //  с ВОЗВРАТОМ
    // опущено слово return
    // последнее выражение и есть то, которое возвращается
    val sumReturn  = {a: Int, b: Int ->
        val result = a + b
        println("$a + $b = $result")
        result
    }

    // вызовы
    sum(5,25)
    var res = sumReturn(5,25)
    println("result previous call =$res ")

    // ЕЩЕ ПРИМЕР
    val sumLambda = {a:Int, b:Int -> a + b}
    // В вышеописанном примере нет слова return
    // то выражение которое последнее - то и папа... ой
    // то выражение и возвращается =)
    res = sumLambda(5,45)
    println("RESULT -> $res")
}

// -----------------------------------------------------------------
//                                                                 -
//          К А К   А Р Г У М Е Н Т   Ф У Н К Ц И И                -
//                                                                 -
// -----------------------------------------------------------------

fun lambdaHowArgumentFunction(){
    doOper(87,77, {a: Int, b: Int -> a + b})
    doOper(34,57, {z: Int, y: Int -> z * y})



    // ИЛИ ПЕРЕДАТЬ ЧЕРЕЗ ПЕРЕМЕННУЮ:
    // переменная
    val opMinus = {num1: Int, num2: Int -> num1 - num2}
    // передача
    doOper(87, 45, opMinus)


}

fun doOper(a : Int, b : Int, op: (Int, Int) -> Int){
    println("result = ${op(a,b)}")
}


// -----------------------------------------------------------------
//                                                                 -
//    Т И П И З А Ц И Я    П А Р А М Е Т Р О В   Л Я М Б Д Ы       -
//                                                                 -
// -----------------------------------------------------------------


fun exampleTypesLambdaParametrs(){

    // Можно опустить типы параметров в лямбде, если они прописываются при инициализации переменной
    val sum: (Int, Int) -> Int = {x, y -> x + y}

    doOper(7,87, sum)

    // И тут тоже можно опустить, потому что компилятор знает какую функцию он ждет в качестве параметра
    doOper(447, 5, {a, b -> a * b})
}


// -----------------------------------------------------------------
//                                                                 -
//                   T R A I L I N G   L A M B D A                 -
//                                                                 -
// -----------------------------------------------------------------

fun trailingLambda(){
    // как было раньше
    doOper(3,9, {a, b -> a + b})

    // вынесли последний параметр (так-как он лямбда) за скобки вызова
    doOper(3,9){a, b -> a + b}
}



// -----------------------------------------------------------------
//                                                                 -
//          ВОЗВРАЩЕНИЕ ЛЯМБДА-ВЫРАЖЕНИЯ ИЗ ФУНКЦИИ                -
//                                                                 -
// -----------------------------------------------------------------

fun returnLambda(){
    doOper(22,44, getAction(1))

    val minus = getAction(2)
    println("13 - 5 = ${minus(13,5)}")
}

fun getAction(a: Int) : (Int, Int) -> Int{
    when(a){
        1 -> return {a, b -> a + b}
        2 -> return {a, b -> a - b}
        3 -> return {a, b -> a * b}
        else -> return {a, b -> 0}
        // или :  else -> return {_, _ -> 0}
        //
        // НАЗЫВАЕТСЯ :
        // Н Е И С П О Л Ь З У Е М Ы Е   П А Р А М Е Т Р Ы
    }
}











