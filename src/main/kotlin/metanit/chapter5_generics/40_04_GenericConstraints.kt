package edu.cesspool.metanit.chapter5_generics.less40_04

//    G E N E R I C   C O N S T R A I N T S
//
//    О Г Р А Н И Ч Е Н И Е   О Б О Б Щ Е Н И Й


/*ПРОСТО СРАВНИВАЕТ СРАВНИВАЕМОЕ*/
fun <T: Comparable<T>> getBiggest(a: T, b: T): T{
    if (a > b) return a
    return b
}

/*СРАВНИВАЕТ СРАВНИВАЕМОЕ И ЧИСЛА*/
fun <T> getBiggestNumber(a: T, b: T) : T where T: Comparable<T>, T: Number {
    return if (a > b) a
    else b
}


fun main(){
    println(getBiggest(5,6))
    println(getBiggest("Avram","Jerry"))

    println(getBiggestNumber(1,8))
    println(getBiggestNumber(0.2, 1.8))
    //println(getBiggestNumber("Tom", "Jerry")) // err
}