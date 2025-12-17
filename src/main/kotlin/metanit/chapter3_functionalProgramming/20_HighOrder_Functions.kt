package edu.cesspool.metanit.chapter3_functionalProgramming

// ФУНКЦИИ ВЫСШЕГО ПОРЯДКА ЭТО ФУНКЦИИ КОТОРЫЕ ПРИНИМАЮТ В СЕБЯ ДРУГИЕ ФУНКЦИИ
// ИЛИ ВОЗВРАЩАЮТ ДРУГУЮ ФУНКЦИЮ
// ИЛИ И ТО И ДРУГОЕ


fun main(){

    displayMessage(::morning)
    displayMessage(::evening)

    // МОЖНО КОНЕЧНО И ТАК
    //
    // (потому что если последний параметр - лямбда, то можно его передать
    //  через фигурные скобки)
    //
    //displayMessage { morning() }
    //displayMessage { evening() }


    action(5,45,  ::plus)
    action(5,354, ::minus)
    action(14,87, ::multiply)


    // ТО ЖЕ САМОЕ НО ЧЕРЕЗ ПРОКЛАДКУ - ФУНКЦИЮ КОТОРАЯ ВОЗВРАЩАЕТ ФУНКЦИЮ ОРИЕНТИРУЯСЬ НА ПОРЯДКОВЫЙ НОМЕР
    action(5,45,  selectAct(1))
    action(5,354, selectAct(2))
    action(14,87, selectAct(3))


}


// ФУНКЦИЯ ВЫСШЕГО ПОРЯДКА   (принимает через параметр другую функцию)
fun displayMessage(mes: () -> Unit) {
    mes()
}

fun morning(){
    println("GOOD MORNING")
}

fun evening(){
    println("GOOD EVENING")
}


//---------------------------------------------------------------
// ЕЩЕ ОДИН ПРИМЕР


fun action (a: Int, b: Int, act: (Int, Int) -> Int){
    println("----CALL ACTION----")
    val result = act(a,b)
    println(result)
}

fun plus     (num1 : Int, num2 : Int) : Int = num1 + num2
fun minus    (num1 : Int, num2 : Int) : Int = num1 - num2
fun multiply (num1 : Int, num2 : Int) : Int = num1 * num2



//---------------------------------------------------------------
// ВОЗВРАЩЕНИЕ ФУНКЦИИ ИЗ ФУНКЦИИ



fun selectAct(n: Int) : (Int, Int) -> Int {
    when (n){
        1 -> return ::plus
        2 -> return ::minus
        3 -> return ::multiply
        else -> return ::plus
    }
}











