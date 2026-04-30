package edu.cesspool.metanit.chapter7_collectionsAndSequences.less53_0001



// пример множества
fun ex1(){
    val people = setOf("Tom","Bob","Sam","Sam")  // Sam - не будет дублироваться
    for (i in people) println(i)
}

// список в множество
fun ex2(){
    val people = listOf("Tom","Bob","Sam","Tom","Bob","Alex")
    val uniquePeople = people.toSet()
    println(uniquePeople)
}

fun ex3(){

    val people = setOf("Tom","Sam","Bob","Mike")
    //https://metanit.com/kotlin/tutorial/7.3.php

    // union - объединение множеств
    // interest - пересечение множеств (есть и в первом и втором)
    // subtract - вычитание множеств (есть в первом, но нет во втором)


}

fun main(){
    //ex1()
    ex2()
}