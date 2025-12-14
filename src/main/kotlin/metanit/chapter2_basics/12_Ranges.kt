package edu.cesspool.metanit.chapter2_basics

fun main(){
    wrap("RANGES"){rangesExample01()}
    wrap("IN RANGE"){rangeInEx()}
    wrap("ENUMERATION RANGE WITH LOOP FOR"){enumerationRange()}

}


fun rangesExample01(){
    val range01 = 1..5                  // 1,2,3,4,5
    println("range 1 = ${range01.toList()}")

    val range02 = 'a'..'d'              // a, b, c, d
    println("range 2 = ${range02.toList()}")

    // DOWNTO
    // диапазон в обратном порядке
    val range03 = 5 downTo 1            // 5,4,3,2,1
    println("range 3 = ${range03.toList()}")

    // STEP
    val range04 = 1..10 step 2          // 1 3 5 7 9
    println("range 4 = ${range04.toList()}")

    // DOWNTO + STEP
    val range05 = 10 downTo 1 step 3    // 10 7 4 1
    println("range 5 = ${range05.toList()}")

    // UNTIL
    // не включает верхнюю границу
    val range06 = 1 until 9
    println("range 6 = ${range06.toList()}") // 1 2 3 4 5 6 7 8

    // UNTIL + STEP
    val range07 = 1 until 9 step 2
    println("range 7 = ${range07.toList()}") // 1 3 5 7

}

fun rangeInEx(){
    val range = 1..9

    val number_5_is_range = 5 in range
    val number_23_is_not_range = 23 !in range

    println("Number 5 is range? $number_5_is_range")
    println("Number 23 is not range? $number_23_is_not_range")
}


fun enumerationRange(){
    val range = 10 downTo 2 step 3

    for (i in range) print("$i ")

    println()
}