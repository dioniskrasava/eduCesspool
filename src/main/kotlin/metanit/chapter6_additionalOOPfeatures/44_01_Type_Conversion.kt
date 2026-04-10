package edu.cesspool.metanit.chapter6_additionalOOPfeatures.less44


// Преобразование типов


// строку в число
fun ex1(){
    val str: String = "12"
    val strToInt: Int = str.toInt()
    println("Result = $strToInt")
}

// исключение при некорректных операциях
fun ex2(){
    val str = "Tom"

    try {
        val strToInt = str.toInt()
    } catch (e: Exception){
        println("Что-то ты там замутил не так!")
        println("Текст ошибки: ")
        println("${e.message}")
    } finally {
        println("Дурачог ты!")
    }
}

//      SMART CAST       (is)
fun ex3(){

    val tom = Person("Tom")
    val bob = Employee("Bob", "JetBrains")


    fun checkEmployment(person: Person){
        //                      S M A R T   C A S T
        //
        //                      (умное преобразование)
        //
        // 1) оператор is дает true, если левый операнд принадлежит типу правого операнда
        // 2) и уже в блоке после проверки с помощью оператора is
        //       компилятор как бы считает, что person объект типа Employee
        if (person is Employee){
            println("${person.name} works in ${person.company}")
        } else {
            println("${person.name} does not have a job")
        }
    }

    checkEmployment(tom)
    checkEmployment(bob)

}

// Оператор    is     в    when
fun ex4(){
    fun identifyPerson(person: Person){
        when (person){
            is Manager -> println("${person.name} is manager")
            is Employee -> println("${person.name} is employee")
            is Person -> println("${person.name} is person")
        }
    }

    val bob = Person("Bob")
    val tom = Employee("Tom", "JetBrains")
    val sam = Manager("Sam", "Sber")

    identifyPerson(bob)
    identifyPerson(tom)
    identifyPerson(sam)
}



// Вспомогательные сущности для примера 3,4
open class Person(val name: String)
open class Employee(name: String, val company: String) : Person(name)
class Manager(name: String, company: String) : Employee(name, company)




fun main(){
    //ex1()
    //ex2()
    //ex3()
    ex4()
}
