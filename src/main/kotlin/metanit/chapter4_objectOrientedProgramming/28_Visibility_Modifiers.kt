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

}

fun main(){
    wrap("EXAMPLE 1"){ex1()}
    wrap("EXAMPLE 2"){ex2()}
}




