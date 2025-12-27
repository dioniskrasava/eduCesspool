package edu.cesspool.metanit.chapter4_objectOrientedProgramming

import edu.cesspool.metanit.chapter2_basics.wrap

// АБСТРАКТНЫЕ КЛАССЫ И МЕТОДЫ

// абстрактный класс по определению открытый, поэтому слово open перед ним не нужно писать

// абстрактные классы. Введение
private fun ex1() {


    abstract class Human(val name: String) {
        fun hello() {
            println("Hello! My name is $name")
        }
    }


    class Person(name: String) : Human(name)


    //************************************************************************************************
    val tom: Human                         // можно определить переменную
    //val bob: Human = Human()             // но нельзя создать объект абстрактного класса

    val bob: Human = Person("Bob") // а вот определить переменную как тип абстрактного класса
    // и потом уже проинициализировать ее как объект класса
    // который наследуется от нашего абстрактного класса
    bob.hello()
    //*************************************************************************************************
}

// абстрактные методы и свойства
private fun ex2() {

    /** Абстрактные свойства не содержат значения.
     *  Абстрактные методы не содержат реализации
     *  */
    abstract class Human(val name: String){
        abstract var age: Int
        abstract fun hello()
    }

    /** Наследуемому классу необходимо переопределить ВСЕ абстрактные свойства и методы класса-родителя */
    class Person(name: String) : Human(name){
        override var age: Int = 1
        override fun hello(){
            println("Hello! My name is $name")
        }
    }

    /**Абстрактные свойства так-же можно реализовать в первичном конструкторе*/
    class Person2(name: String, override var age: Int) : Human(name){
        override fun hello(){
            println("Hello! My name is $name")
        }
    }
}

// пример того ЗАЧЕМ нужны абстрактные классы
private fun ex3(){

    /**Абстрактный класс определяет что такое фигура и чем она должна обладать*/
    abstract class Figure(){
        abstract fun perimetr(): Float
        abstract fun area(): Float
    }

    /**Конкретная фигура*/
    class Rectangle(val width: Float, val height: Float) : Figure(){
        override fun area(): Float {
            return width * height
        }

        override fun perimetr(): Float {
            return width * 2 + height * 2
        }
    }

    val rect1: Figure = Rectangle(5.0F, 6.0F)

    println(rect1.area())
    println(rect1.perimetr())

}

fun main() {
    wrap("ex1") { ex1() }
    wrap("ex2") { ex2() }
    wrap("ex3") { ex3() }
}