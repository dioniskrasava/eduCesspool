package edu.cesspool.metanit.chapter4_objectOrientedProgramming.less33_02

/** ВЛОЖЕННЫЕ И ВНУТРЕННИЕ КЛАССЫ И ИНТЕРФЕЙСЫ */

/***/

class Person(username: String, password: String){

    private val account: Account = Account(username, password)

    private class Account(val username: String, val password: String)

    fun showAccountDetails(){
        println("Username: ${account.username}. Password ${account.password}")
    }
}


fun main(){
    val tom = Person("tomUser", "12345678")
    tom.showAccountDetails()
}