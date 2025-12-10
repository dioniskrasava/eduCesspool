package edu.cesspool.metanit.chapter2_basics


/*ПРОСТОЙ ПРИМЕР*/
fun ifexample1(){
    val a = 10

    if (a == 10){
        println("a равно 10")
    }
    else{
        println("a не равно 10")
    }
}


/*С ОПУСКАНИЕМ СКОБОК*/
/* если блок кода содержит только одно выражение, то скобки можно опустить*/
fun ifExample2(){
    val a = 10

    if (a == 10) println("a равно 10")
    else println("a не равно 10")
}

fun wrap(name: String, function: () -> Unit){
    println("======$name========")
    function()
    println("===================")
}

fun main(){
    wrap("SIMPLE EXAMPLE") {ifexample1()}
    wrap("LOWERING STAPLES") {ifExample2()}
}