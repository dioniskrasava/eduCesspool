package edu.cesspool.metanit.chapter5_generics.less40_01

//    G E N E R I C   C O N S T R A I N T S
//
//    О Г Р А Н И Ч Е Н И Е   О Б О Б Щ Е Н И Й


/*
fun <T> getBiggest(a: T, b: T): T{
    if (a > b) return a                // ERROR! (потому что есть типы которые нельзя сравнить)
    return b
}
*/


/**
 * Comparable - интерфейс стандартной библиотеки котлин (и ява)
 *              он нужен для того чтобы объекты можно было сравнивать
 *              и определять их естественный порядок.
 *                     Данный интерфейс содержит лишь один метод:
 *                                compareTo(other: T): Int    (-1 меньше, 0 равно, 1 больше)
 *
 *
 *
 * */
fun <T: Comparable<T>> getBiggest(a: T, b: T): T{
    if (a > b) return a
    return b
}

fun main(){
    val result1 = getBiggest(5,6)
    println(result1)

    val result2 = getBiggest("Sam", "Tom")
    println(result2)

    aboutComparable()
}




//************************************************************************************
//************************************************************************************
//************************************************************************************
//************************************************************************************

// Более подробно про ИНТЕРФЕЙС Comparable
fun aboutComparable(){
    println(10.compareTo(5))         //1
    println(10.compareTo(10))        //0
    println(10.compareTo(20))        //-1
    println("abc".compareTo("abd"))  //-1  ( 'c' < 'd' )
    println(7 < 3)

    // Юзаем свой класс
    val tom = Person("Tom", 15)
    val bob = Person("Bob",20)

    println("=====================================")
    println(tom < bob)           // true
    println(tom == bob)          // false
    println(tom > bob)           // false

    println(tom.compareTo(bob))  // -5
}


//************************************************************************************
//************************************************************************************

// Собственный класс Person реализующий интерфейс Сравниваемый<Person>
data class Person(val name: String, val age: Int) : Comparable<Person>{
    /**Как я понял, где-то под капотом это работает так...
     * если вернулось отрицательное число - меньше
     *                ноль                - равно
     *                положительное       - больше
     */
    override fun compareTo(other: Person) = this.age - other.age
}

