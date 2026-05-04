package edu.cesspool.metanit.chapter7_collectionsAndSequences.less53_0001

import kotlin.system.exitProcess


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

// методы Set (union/intersect/subtract)
fun ex3(){

    val people = setOf("Tom","Sam","Bob","Mike")
    val employee = setOf("Tom","Sam","Kate","Alice")

    // Методы (union/intersect/subtract) можно применять и к объектам List,
    //    но всё-равно на выходе будет объект set

    // union - объединение множеств
    val all = people.union(employee)

    // interest - пересечение множеств (есть и в первом и втором)
    val common = people.intersect(employee)

    // subtract - вычитание множеств (есть в первом, но нет во втором)
    val different = people.subtract(employee)


    println(all)
    println(common)
    println(different)


}

fun main(){
    //ex1()
    //ex2()
    ex3()
}