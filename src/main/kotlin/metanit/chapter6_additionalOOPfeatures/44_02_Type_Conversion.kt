package edu.cesspool.metanit.chapter6_additionalOOPfeatures.less44_01


// Преобразование типов
//
// ограничение умных преобразований
//
/* Работает для:
        - val
        - val (без геттера)
*/


fun ex1(){

    val tom = Person("Tom")

    if (tom.phone is SmartPhone){
        //println("SmartPhone: ${tom.phone.name}, os: ${tom.phone.os} ") // err!
        //
        /* Ошибка возникает по причине того, что поле phone у объекта персоны
             var (мутабельное), что не гарантирует того факта, что какая-то часть программы
             не поменяет его уже после проверки и в конечном итоге мы обратимся к полю os которого
             например нет у простого телефона
        */
    } else {
        println("Phone: ${tom.phone.name}")
    }

}

open class Phone(val name: String)
class SmartPhone(name: String, val os: String) : Phone(name)

// SMART CAST не работает потому что `var`
open class Person(val name: String){
    var phone: Phone = SmartPhone("Pixel 5", "Android")
}

/* Тоже не работает SMART CAST потому что есть пользовательский геттер
*
*       а компилятор не смотрит на содержание геттера */
open class Person2(val name: String){
    val phone: Phone
        get() = SmartPhone("Pixel 5", "Android")
}


fun main(){
    ex1()
}
