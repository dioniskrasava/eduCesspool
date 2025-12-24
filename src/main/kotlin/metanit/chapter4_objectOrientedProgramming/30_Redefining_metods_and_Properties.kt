package edu.cesspool.metanit.chapter4_objectOrientedProgramming.ex2
// НЕ ЗАКОНЧЕН!!!
// ОШИБКА В ПОРЯДКЕ ИЗУЧЕНИЯ
import edu.cesspool.metanit.chapter2_basics.wrap

// Переопределение методов и свойств

fun main(){
    wrap("EX 1"){ex1()}
}

// переопределение свойств
fun ex1(){

    /** Определяем то, что сам класс и свойство возраста открыто для переопределения
     * (пишем слово open перед классом и свойством)*/
    open class Person(val name: String, open var age: Int = 0){
        fun prInf(){
            println("name = $name, age = $age")
        }
    }

    /** с помощью ключ.слова override переписываем поле возраста для каждого сотрудника*/
    class Employee(name: String) : Person(name){
        override var age: Int = 18
    }

    /**ТАК-ЖЕ можно переопределить свойство сразу в конструкторе*/
    class Employee2(name: String, override var age: Int = 18) : Person(name, age)

    /*Я думаю понятно, что классы сотрудника и сотрудника2 не идентичны никак,
    * потому что как минимум у второго шире возможности для инициализации объекта
    * путем возможности передачи в конструктор значения возраста, что исключено у первого
    * объекта*/

    val ninka = Person("Ninka")
    val ninkaDurka = Employee("Ninka Durka")
    val ninkaPadlovna = Employee2("Ninka Padlovna", 51)

    ninka.prInf()
    ninkaDurka.prInf()
    ninkaPadlovna.prInf()

}

// переопределение геттеров и сеттеров
fun ex2(){
    open class Person(){

    }
}