package edu.cesspool.metanit.chapter4_objectOrientedProgramming.less34

/**
 * DATA - Классы
 * При их компиляции компилятор автоматически добавляет в класс:
 *
 * `equals()`: сравнивание два объекта на равенство
 *
 * `hashCode()`: возвращает хеш-код объекта
 *
 * `toString()`: возвращает строковое представление объекта
 *
 * `copy()`: копирует данные объекта в другой объект
 *
 * Условия:
 *
 * 1) Необходимо иметь как минимум один параметр в первичном конструкторе!
 *
 * 2) Параметры должны объявляться через слов var/val (рекомендуется val, потому что...)
 *
 * 3) Не должны применяться ключевые слова open, abstract, sealed, inner
 *
 * 4) Свойства, которые определяются вне первичного конструктора не должны использоваться в функциях toString, equals, hashCode
 * */

class Person01(val name: String, val age: Int)
data class Person02(val name: String, val age: Int)

/**Можно переопределить стандартные методы*/
data class Person03(val name: String, val age: Int){
    override fun toString(): String {
        return super.toString().plus("___FUCK_YOU!")
    }
}

/**Пример копирования объекта с изменением одного свойства*/
fun exampleCopy(){
    val alice = Person02("Alice", 24)
    val kate = alice.copy("Kate")

    println(alice.toString())
    println(kate.toString())
}

/**Декомпозиция*/
fun exampleDecompose(){
    val alice: Person02 = Person02("Alice", 33)

    /** Объект распадается и присваивается двум разным переменным */
    val (username, userage) = alice
    println("Name = $username, age = $userage")
}

fun main(){
    println()
    println("=========BEGIN PROGRAMM==========")

    /** Пример, демонстрирующий тот факт, что если класс объекта `не является data class`, то стандартный
     * метод toString предоставляет немного непонятную информацию об объекте */
    val user01 = Person01("Alice", 24)
    println(user01.toString()) // edu.cesspool.metanit.chapter4_objectOrientedProgramming.less34.Person01@5c647e05

    /**А вот уже вызов метода toString у объекта data class дает `удобочитаемый` результат */
    val user02 = Person02("Alice", 25)
    println(user02.toString()) // Person02(name=Alice, age=24)

    /**Переопределенные стандартные методы*/
    val user03 = Person03("Alice",26)
    println(user03.toString()) // edu.cesspool.metanit.chapter4_objectOrientedProgramming.less34.Person03@750e25ba___FUCK_YOU!

    println("--------------------------")
    exampleCopy()

    println("--------------------------")
    exampleDecompose()
}