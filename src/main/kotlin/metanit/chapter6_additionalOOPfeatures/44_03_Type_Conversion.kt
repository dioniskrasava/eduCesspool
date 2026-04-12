package edu.cesspool.metanit.chapter6_additionalOOPfeatures.less44_03


// Преобразование типов
//
// явные преобразования и оператор as


// обычное преобразование
fun ex1(){
    val hello: String? = "Hello"
    val message: String = hello as String
}

// преобразование с ошибкой
fun ex2(){
    val hello: String? = null
    val message: String = hello as String // NullPointerException
}

// безопасное преобразование (оператор as?)
fun ex3(){
    val hello: String? = "Hello"
    val message = hello as? String
    println(message?.let {it::class.simpleName} ?: "null")   // Выводим тип переменной message (String)

    val hello2: String? = null
    val message2 = hello2 as? String
    println(message2?.let {it::class.simpleName} ?: "null")   // Выводим тип переменной message (null)
}

// Преобразование своих типов
fun ex4(){
    val tom = Person("Tom")
    val bob = Employee("Bob", "Sber")

    fun checkCompany(person: Person){
        val employee = person as? Employee
        if (employee != null){
            println("${employee.name} is ${employee.company}")
        } else {
            println("${person.name} is not an employee")
        }
    }

    checkCompany(tom)
    checkCompany(bob)
}
// Сущности для 4 примера
open class Person(val name: String)
class Employee(name: String, val company: String): Person(name)

fun main(){
    //ex1()
    //ex2()
    //ex3()
    ex4()
}
