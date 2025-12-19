package edu.cesspool.metanit.chapter3_functionalProgramming

import edu.cesspool.metanit.chapter2_basics.wrap

// -----------------------------------------------------------------
//                                                                 -
//                        З А М Ы К А Н И Я                        -
//                                                                 -
// -----------------------------------------------------------------


fun main(){
    wrap("EX 1"){closureExample()}

}


fun closureExample(){
    val fn = outer()
    fn()
    fn()
    fn()
}

fun outer(): () -> Unit {
    var n = 5

    fun inner(){
        n++
        println("n = $n")
    }

    return ::inner
}