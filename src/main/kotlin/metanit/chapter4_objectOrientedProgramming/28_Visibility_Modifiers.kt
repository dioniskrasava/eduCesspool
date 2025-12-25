package edu.cesspool.metanit.chapter4_objectOrientedProgramming

import edu.cesspool.metanit.chapter2_basics.wrap

// МОДИФИКАТОРЫ ВИДИМОСТИ

/**
 * Модификаторы присваиваются : к
 * - классам
 * - объектам
 * - интерфейсам
 * - функциям
 * - свойствам
 * - конструкторам
 *
 *
 *
 * private - видны только в том файле (члены класса видны только в классе)
 * protected - видны в классе и в классах наследниках
 * internal - видны в модуле
 * public - видны в любой части программы (с импортом, если в другом пакете) (DEFAULT)
 * */

// private
private fun ex1(){
    /**
     * В Данном примере мы видим приватное поле имени (которое инициализируется в конструкторе)
     * приватное поле возраста, инициализируемое в теле класса через параметр конструктора с похожим именем
     * приватные методы для отображения имени и возраста, но публичный метод, который находится внутри
     * самого класса и поэтому может вызывать приватные методы класса
     * */

    class Person(private val name: String, _age: Int){
        private var age = _age

        fun printInfo(){ // можно написать public fun
            printName()
            printAge()
        }

        private fun printName(){
            println("Name = $name")
        }

        private fun printAge(){
            println("Age = $age")
        }
    }


    val tom = Person("Tom", 31)

    tom.printInfo()

    //tom.printName()    // ERR
    //tom.age = 15       // ERR
    //println(tom.name) // ERR

}

// protected
private fun ex2(){

    open class Person(protected val name: String, private var age: Int){

        protected fun printPerson(){
            printName()
            printAge()
        }

        private fun printName(){
            println("Name = $name")
        }

        private fun printAge(){
            println("Age = $age")
        }
    }

    class Employee(name: String, age: Int) : Person(name, age){
        fun printEmployee(){
            println("Employee $name :")
            printPerson()
            // printName()           // ERR (private у родителя)
            // println("Age = $age") // ERR (private поле у родителя)
        }
    }

    val tom = Employee("Tom", 32)



    tom.printEmployee()
    // tom.printPerson() // ERR ! не можем использовать protected вне тела класса наследника
    // println(tom.name) // ERR ! к protected можно обращаться только внутри тела класса наследника
}

// Модификаторы конструкторов
private fun ex3(){

    fun example1(){
        open class Person constructor (val name: String)

        val tom = Person("Tom")
        println(tom.name)
    }

    /** Пример, демонстрирующий приватный первичный конструктор, который
     * невозможно вызвать вне класса. И поэтому мы создаем вторичный
     * конструктор который как раз и может вызвать наш первичный.*/
    fun example2(){
        open class Person private constructor(val name: String){
            var age: Int = 0

            constructor(name: String, age: Int) : this(name){ // this - вызов приватного первичного конструктора
                this.age = age
            }

        }

        val tom = Person("Tom", 15)
        println("Person ${tom.name}, age = ${tom.age}")

    }


    /**Пример похож на предыдущий за исключением того что
     * вторичный конструктор теперь имеет модификатор доступа - protected
     * что теперь позволяет его вызвать ТОЛЬКО у класса наследника*/
    fun example3(){
        open class Person private constructor(val name: String){
            var age: Int = 0

            protected constructor(name: String, age: Int) : this(name){
                this.age = age
            }
        }

        class Employ(name: String, age: Int) : Person (name, age)

        //val tom = Person("Tom", 16) // ERR
        val tom = Employ("Tom", 16)

        println(tom.name)
        println(tom.age)

    }


    littleWrap("little example 1"){example1()}
    littleWrap("little example 2"){example2()}
    littleWrap("little example 3"){example3()}




}

// Модификаторы объектов и типов верхнего уровня
/**
 * В принципе тут просто описывается о том что
 * - внутри публичных функций которые находятся в том же модуле
 *      (как я понимаю это тот же пакет и файл одновременно)
 *      что и
 *      (приватные, интернальные, публичные) (классы, переменные, функции)
 *      можно использовать эти объекты (классы, переменные, функции описанные выше)
 *
 *

 * ```
 * package base
 *
 * private val privateVal = 3
 * internal val internalVal = 4
 * val publicVal = 5
 *
 * private fun privateFun() = println("privateFn")
 * fun internalFun() = println("internalFn")
 * fun publicFun() = println("publicFn")
 *
 * private class PrivateClass(val name: String)
 * internal class InternalClass(val name:String)
 * class PublicClass(val name:String)
 *
 * fun printData(){
 *     // внутри модуля доступны приватные идентификаторы
 *     val privateClass= PrivateClass("Tom")
 *     println(privateVal)
 *     privateFun()
 *
 *     // внутри модуля доступны internal-идентификаторы
 *     val internalClass= InternalClass("Tom")
 *     println(internalVal)
 *     internalFun()
 *
 *     // внутри модуля доступны public-идентификаторы
 *     val publicClass= PublicClass("Tom")
 *     println(publicVal)
 *     publicFun()
 * }
 * ```
 * */

fun main(){
    wrap("EXAMPLE 1"){ex1()}
    wrap("EXAMPLE 2"){ex2()}
    wrap("EXMPLE 3 (MOD-CONST)"){ex3()}
}


//-------------НОВАЯ ВСПОМОГАТЕЛЬНАЯ ФУНКЦИЯ ДЛЯ ОТРИСОВКИ
fun littleWrap(name: String, op: () -> Unit){
    println("     ---------$name-----------")
    op()
    println("     -----------------------------------")
}



