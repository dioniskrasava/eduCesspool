package edu.cesspool.metanit.chapter3_functionalProgramming

/**
 *      fun имя_функции (параметры) : возвращаемый_тип {
 *           выполняемые_инструкции
 *      }
 *
 *
 *      - параметров может не быть
 *      - возвращаемый_тип можно не указывать (компилятор сам выведет)
 *
 *      уже при вызове:
 *          - значения которые передаются параметрам называются - аргументами
 * */

/**
 *
 * */


fun main(){
    showMessage("Hello, World!")
    displayUser("Vasya", 19)

    // варианты вызова функции displayEmployee
    displayEmployee("Petya")
    displayEmployee("Sergey", 25)
    displayEmployee("Egor", position = "pidor")
    displayEmployee("Dima", 35, "siska")
    displayEmployee(name = "Sana", age = 88, position = "consultant")
}


fun showMessage(mess: String){
    println(mess)
}


fun displayUser(name: String, age: Int){
    println("User $name, $age year!")
}

/** показать информацию о сотруднике*/
fun displayEmployee(name: String, age: Int = 18, position: String = "unemployed"){
    println("Name $name, age $age. Position = $position")
}