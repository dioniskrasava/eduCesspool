package edu.cesspool.metanit.chapter4_objectOrientedProgramming.less33_01

/** ВЛОЖЕННЫЕ И ВНУТРЕННИЕ КЛАССЫ И ИНТЕРФЕЙСЫ */

class Person{

    /** Вложенный класс (по умолчанию - public) */
    class Account(val username: String, val password: String){
        fun showDetails(){
            println("UserName: $username. Password: $password")
        }
    }

}


fun main(){

    // Можно создать экземпляр внутреннего класса
    // используя точечную нотацию и имя класса родителя:
    val userAcc = Person.Account("User001", password = "12345678qwerty")
    userAcc.showDetails()
}