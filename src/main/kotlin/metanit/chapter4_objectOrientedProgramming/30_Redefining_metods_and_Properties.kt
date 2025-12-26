package edu.cesspool.metanit.chapter4_objectOrientedProgramming.ex2

import edu.cesspool.metanit.chapter2_basics.wrap

// Переопределение методов и свойств

fun main(){
    wrap("EX 1 (overr field)  "){ex1()}
    wrap("EX 2 (overr get-set)"){ex2()}
    wrap("EX 3 (inheritors)"){ex3()}
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
    open class Person(val name: String){
        open val fullInfo: String
            get() = "Person $name - age: $age"

        open var age: Int = 0
            set(value) {
                if (value in 0..120) field = value
            }
    }

    /** чтобы переопределить сеттер - мы переопределяем все свойство*/
    class Employee(name: String) : Person(name){
        override val fullInfo: String
            get() = "${super.fullInfo} теперь сотрудник!!!!"

        override var age : Int = 18
            set(value) {
                if (value in 18..65) {
                        field = value
                        // выводит зеленым в консоль
                        println("\u001B[32m   Возраст сотрудника изменен на $value\u001B[0m")
                } else {
                        // выводит красным в консоль
                        println("\u001B[31m   ERR : Ты какой возраст решил поставить??? $value лет ?!?!?!? \u001B[0m") // красное ERR
                }
            }
    }

    val tom = Person("Tom")
    println(tom.fullInfo)

    val bob = Employee("Bob")
    println(bob.fullInfo)

    bob.age = 100
    println(bob.fullInfo)

    bob.age = 32
    println(bob.fullInfo)

}

// переопределение в иерархии наследования классов
fun ex3(){

    /**ДОСТАТОЧНО ОДНОГО КЛЮЧЕВОГО СЛОВА OPEN
     *  и это позволит всем наследникам переопределять метод супер-родителя*/

    open class Person(val name: String){
        open fun display() = println("Name : $name")
    }

    open class Employee(name: String, val company: String) : Person(name){
        override fun display() = println("Name : $name. Company : $company")
    }

    class Manager(name: String, company: String) : Employee(name, company){
        override fun display() =  println("Name: $name. Company: $company  Position: Manager")
    }

    val tom = Person("Tom")
    val bob = Employee("Bob", "VTB")
    val sem = Manager("Sem", "VTB")

    tom.display()
    bob.display()
    sem.display()


}

// Запрет переопределения
fun ex4(){
    open class Person(val name: String){
        open fun display() = println("Name : $name")
    }

    open class Employee(name: String, val company: String) : Person(name){
        // final - ЗАПРЕЩАЕТ дальнейшее переопределние у потомков
        final override fun display() = println("Name : $name, company : $company")

    }

    class Manager(name: String, company: String): Employee(name, company){
        //override fun display(){} // ERR
    }
}