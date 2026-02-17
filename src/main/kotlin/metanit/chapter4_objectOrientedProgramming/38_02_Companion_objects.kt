package edu.cesspool.metanit.chapter4_objectOrientedProgramming.less38_02


class Person(var name: String){

    companion object {
        private var counter = 0 // Делаем поле приватным чтобы не было возможности менять
                                // из любого места программы данный счетчик. А то вдруг кто-нибудь
                                // захочет вызвать Person.counter = 100500 и всё!!
                                // А так счетчик гарантировано будет меняться только при
                                // создании нового объекта
        fun getCounter() = counter // метод досупа к значению счетчика

    }

    init {
        counter++
    }


}


fun main(){
    val tom = Person("Tom")
    val jerry = Person("Jerry")
    println("Quantity objects = ${Person.getCounter()}")
}