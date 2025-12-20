package edu.cesspool.metanit.chapter4_objectOrientedProgramming

import edu.cesspool.metanit.chapter2_basics.wrap

fun main(){
    wrap("EXAMPLE 1"){exampleConstructor1()}
    wrap("EXAMPLE WITH CONSTRUCTOR DELEGATION"){exampleConstructorDelegation()}
    wrap("FIRST CONSTRUCTOR"){firstCostructor()}
    wrap("FIRST CONSTRUCTOR 2"){firstCostructor2()}
    wrap("FCProp"){firstConstrProp()}
    wrap("Init"){initConstr()}
}


fun exampleConstructor1(){
    class Person{
        var name = "Noname"
        var age = 0

        constructor(name: String, age: Int){
            this.name = name
            this.age = age
        }
    // можно и такой конструктор:
//        constructor(_name: String, _age: Int){
//            name = _name
//            age = _age
//        }
        constructor(_age: Int, _name: String){
            name = _name
            age = _age
        }

        // можно много разных конструкторов
        constructor(_name: String){
            name = _name
        }

        fun print(){
            println("Name = $name, age = $age")
        }

    }

    val tom = Person("Tom", 3)
    tom.print()

    val jerry = Person(1, "Jerry")
    jerry.print()

    val soer = Person("Soer")
    soer.print()


}

fun exampleConstructorDelegation(){
    class Person{
        var name: String
        var age: Int = 0

        // Вторичный конструктор 1 - базовый
        constructor(_name: String){
            name = _name
            println("Создан объект с именем $name")
        }

        // Вторичный конструктор 2 - расширенный
        // Делегирует выполнение первому конструктору через : this(_name)
        // Порядок выполнения:
        // 1. Сначала выполняется constructor(_name: String)
        // 2. Затем age = _age
        constructor(_name: String, _age: Int): this(_name){
            age = _age
            println("Создан объект с именем $name и возрастом $age")
        }
    }

    val tom = Person("Tom", 44)
}

fun firstCostructor(){
    class Person(_name: String, _age: Int){
        var name = _name
        var age = _age
    }
}

fun firstCostructor2(){

    // первичный конструктор
    class Person(_name: String){
        var name = _name
        var age = 0

        // вторичный конструктор. вызывает первичный
        constructor(_name: String, _age: Int) : this(_name){
            age = _age
        }
    }

    val tom = Person("Tom")

}


// -----------------------------------------------------------------
//                                                                 -
//                ПЕРВИЧНЫЙ КОНСТРУКТОР И СВОЙСТВА                 -
//                                                                 -
// -----------------------------------------------------------------

fun firstConstrProp(){


    // мы сразу объявляем поля класса в первичном конструкторе
    // и там же прописываем их мутабельность (val/var)

    class Person(val name: String, var age: Int)
    // тело класса можно в этом случае опустить

    val tom = Person("Tom",47)
    println("Name = ${tom.name}, age = ${tom.age}")
}


// -----------------------------------------------------------------
//                                                                 -
//                    И Н И Ц И А Л И З А Т О Р                    -
//                                                                 -
// -----------------------------------------------------------------

fun initConstr(){

    class Person(_name: String, _age: Int){
        val name: String
        var age: Int = 1

        init {
            name = _name
            if (_age > 0 && _age < 130) age = _age
            else println("Придурок!")
        }
    }

    val tom = Person("Tom", 147)
    println("Tom age = ${tom.age}")

    val bob = Person("Bob", 31)
    println("Bob age = ${bob.age}")

}