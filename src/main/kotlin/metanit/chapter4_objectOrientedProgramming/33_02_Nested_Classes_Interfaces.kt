package edu.cesspool.metanit.chapter4_objectOrientedProgramming.less33_02

/** ВЛОЖЕННЫЕ И ВНУТРЕННИЕ КЛАССЫ И ИНТЕРФЕЙСЫ */

/**
 * Пример того, как все это можно оформить.
 *
 * Есть приватный класс Аккаунта (вспомогательной сущности персоны). Другим элементам программы в
 * принципе не нужно иметь возможность создавать объект аккаунта отдельно от объекта класса Персоны.
 * Да, возможно это вовсе нелогично, в этом теперь и заключена суть ОО подхода, в том, что мы конечно
 * отдельно оформляем вспомогательные сущности, но по отдельности они не живут.
 *
 * Поэтому мы имеем приватный класс, который используется при создании приватного поля родительского класса.
 * */

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