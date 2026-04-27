package edu.cesspool.metanit.chapter7_collectionsAndSequences

/*
* List - последовательный список элементов. Неизменяем (immutable).
* */


fun main(){
    //ex1()
    //ex2()
    //ex3()
    ex4()
}

//-------------------------------НЕИЗМЕНЯЕМЫЕ СПИСКИ
fun ex1(){
    val numbers = listOf(1,2,3,4)
    val names = listOf("Tom", "Bob", "Sam")

    println("===========ВЫВОД ПРОСТО=============")
    println(numbers)
    println(names)

    println("=========ВЫВОД ЧЕРЕЗ ЦИКЛ===========")
    for (person in names) println(person)

    println("=====ВЫВОД ЧЕРЕЗ toString()=========")
    println(names.toString())
}

// получение элемента
fun ex2(){
    //get(index)
    val people = listOf("Слава","Федя","Петя")
    println(people.get(0))
    println(people.get(1))
    println(people.get(2))

    println("---------")

    // или через скобки []
    println(people[0])
    println(people[1])
    println(people[2])

    /**ЕСЛИ ВЫЗВАТЬ ПО НЕСУЩЕСТВУЮЩЕМУ ИНДЕКСУ, то выдаст ошибку
     *
     * можно использовать getOrNull() - выдаст элемент или null (если элемента не существует)
     *
     * есть еще getOrElse()
     * */

    // пример getOrElse()
    val n = people.getOrElse(5){"Invalid index $it"}
    println(n)  // Invalid index 5

    val m = people.getOrElse(2){"Invalid index $it"}
    println(m) // Петя

}

// получение части списка
fun ex3(){
    // метод subList
    //       возвращает часть списка
    //       в качестве параметров принимает начальный и конечный индексы

    val people = listOf("Tom", "Sam", "Kate", "Bob", "Alice", "Mike")
    val subPeople = people.subList(1, 4)
    println(subPeople) // [Sam, Kate, Bob]

}

//-------------------------------ИЗМЕНЯЕМЫЕ СПИСКИ
fun ex4(){
    var numbers1 : ArrayList<Int> = arrayListOf(1,2,3,4,5)
    numbers1.add(99)   // добавляем элемент в конец
    println(numbers1)

    numbers1.clear()  // очистка массива
    println(numbers1)

    println(numbers1.size) // 0  (размер массива)

    println("===========================")


    var numbers2 : MutableList<Int> = mutableListOf(5,6,7,8)
    println(numbers2)
    numbers2.add(0, 23); println(numbers2) // добавляем в позцию 0 элемент 23
    numbers2.addAll(0, listOf(-3, -2, -1))

}