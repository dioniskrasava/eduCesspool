package edu.cesspool.metanit.chapter5_generics.less39_06

/**
 * О Б О Б Щ Е Н Н Ы Е   Ф У Н К Ц И И
 * */

// в обобщенных ф-ях
//
// параметр пишется ДО названия
// в отличие от обобщенных классов,
// где параметр пишется после названия класса

fun <T> display(obj: T){
    println(obj)
}


fun main(){
    display("Hello")
    display(1234)
    display(true)
}


