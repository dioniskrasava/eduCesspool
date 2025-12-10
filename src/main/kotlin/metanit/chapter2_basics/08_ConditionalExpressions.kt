package edu.cesspool.metanit.chapter2_basics

// >
// <
// >=
// <=
// ==
// !=



// and
// or
// xor
//     true - если ТОЛЬКО один из операндов равен true
// !        - инверсия
// not()    - эквивалентно оператору - !
// in


fun main(){
    exampleIn()
}

fun exampleIn(){
    val a = 5
    val aIsNumber = a in 0 .. 9 // true

    val aIs2znach = a in 10..99 // false

    val aIsNotNumber = a !in 0..9 // false

    println("============IN============")
    println("A is number - $aIsNumber")
    println("A is 2 znachnoe - $aIs2znach")
    println("A is Not Number - $aIsNotNumber")
}