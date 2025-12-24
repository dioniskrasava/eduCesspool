package edu.cesspool.metanit.chapter4_objectOrientedProgramming.ex1

import edu.cesspool.metanit.chapter2_basics.wrap

//НАСЛЕДОВАНИЕ

fun ex1(){
    open class Person{
        var name: String = "Noname"
        var age: Int = 0
        fun printName() = println(name)
    }

    // Employee - сотрудник
    class Employee : Person ()

    // Или вот так:
    // Тут в классе потомка мы создаем вторичный конструктор
    // и в нем показываем что вызываем конструктор родителя через :
    //          super() - вызов конструктора базового класса
    class Employee2 : Person{
        constructor() : super()
    }

    val Vasya = Employee()
    Vasya.name = "Vasya"
    Vasya.printName()
}

fun ex2(){

    //------------------------------------------------------------------
    open class Person(val name: String, var age: Int){
        fun printInf(){
            println("Name = $name, age = $age")
        }
    }
    //------------------------------------------------------------------
    class Employee(name: String, age: Int) : Person(name, age)
    //------------------------------------------------------------------
    class Employee2 : Person {
        constructor(name: String, age: Int) : super(name, age)
    }
    //------------------------------------------------------------------

    val ninaPadlovna: Employee = Employee("Nina Padlovna", 51)
    ninaPadlovna.printInf()

    val svetaZur: Employee2 = Employee2("Sveta Zuravleva", 60)
    svetaZur.printInf()
}

fun ex3(){
    open class Person{
        val name: String
        val age: Int = 0

        constructor(name: String){
            this.name = name
        }

        fun printInfPerson(){
            println("name = $name, age = $age")
        }
    }
    //------------------------------------------------------------------
    class Employee : Person{
        var company = "No company"
        constructor(name: String, company: String) : super(name){
            this.company = company
        }

        // добавляем к унаследованному функционалу специфичный метод
        fun printInfEmployee(){
            println("name = $name, age = $age, company = $company")
        }
    }
    //------------------------------------------------------------------

    val ninka = Employee("Nina Padlovna", "Shool 2")
    ninka.printInfPerson()
    ninka.printInfEmployee()

}

fun main(){
    wrap("EX 1"){ex1()}
    wrap("EX 2"){ex2()}
    wrap("EX 3"){ex3()}
}