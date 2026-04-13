package edu.cesspool.metanit.chapter6_additionalOOPfeatures

// Перегрузка операторов

class Money(val amount: Int){
    operator fun plus(other: Money): Money{
        return Money(this.amount + other.amount)
    }
}

fun main(){
    val m1 = Money(100)
    val m2 = Money(200)
    val m3: Money = m1 + m2
    println(m3.amount)
}