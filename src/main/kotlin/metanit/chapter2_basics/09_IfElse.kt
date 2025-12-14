package edu.cesspool.metanit.chapter2_basics

//----------------------------------------------
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
//----------------------------------------------

/*С ОПУСКАНИЕМ СКОБОК*/
/* если блок кода содержит только одно выражение, то скобки можно опустить*/
fun ifExample2(){
    val a = 10

    if (a == 10)
        println("a равно 10")
    else
        println("a не равно 10")
}


/*ELSE IF*/
fun ifExample3(){
    val a = 10

    if (a == 10) println("a = 10")
    else if (a == 9) println("a = 9")
    else if (a == 8) println("a = 8")
    else if (a == 7) println("a = 7")
    else println("a = XZ!")

}

/*ВОЗВРАЩЕНИЕ ЗНАЧЕНИЯ ИЗ IF*/
fun ifReturnExample(){
    val a = 10
    val b = 25


    // ВАЖНЫЙ МОМЕНТ!!
    // if возвращает значение!
    val max = if (a > b) a else b



    println("the maximum number of $a and $b is $max")
}


//----------------------------------------------
//----------------------------------------------
//----------------------------------------------
//----------------------------------------------
fun wrap(name: String, function: () -> Unit){
    println()
    println("======$name========")
    function()
    println("===================")
    println()
}
//----------------------------------------------
//----------------------------------------------
//----------------------------------------------
//----------------------------------------------
fun main(){
    wrap("SIMPLE EXAMPLE") {ifexample1()}
    wrap("LOWERING STAPLES") {ifExample2()}
    wrap("RETURN") {ifReturnExample()}
}