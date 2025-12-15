package edu.cesspool.metanit.chapter3_functionalProgramming

import edu.cesspool.metanit.chapter2_basics.wrap

fun main(){
    wrap("MANY STRING"){printString("lol","kek","cheburek!")}
    wrap("SUMM"){summator(3,5,10,-8)}
}

//many string!
// в данную функцию можно передать неопределенно много строк
fun printString(vararg string: String){
    for (str in string){
        println(str)
    }
}


//summ

fun summator(vararg numbers: Int){
    var summ = 0
    for (i in numbers)
        summ += i

    println("Summ = $summ")
}