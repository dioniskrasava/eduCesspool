package edu.cesspool.metanit.chapter6_additionalOOPfeatures

/**
 * В общем и целом можно переопределить почти все операторы которые уже существуют.
 * Нельзя переопределить для обычных типов, для которых это уже определено (например для Int нельзя переписать сложение на свой лад)
 * Можно определять оператор там где он не определен.
 *
 * Нельзя переопределить операторы :  ||  &&   ?:
 * Можно переопределить операторы :
 *
 * Нельзя придумать свои операторы.
 * У каждого оператора есть своё название на английском.
 * */

// Перегрузка операторов

class Money(val amount: Int){
    operator fun plus(other: Money): Money{
        return Money(this.amount + other.amount)
    }
}

// Можно переопределить оператора в виде функции расширения (уже после создания класса и для уже созданных классов)
operator fun Money.minus(other: Money): Money{
    return Money(this.amount - other.amount)
}

// Можно переопределить для стандартных типов и кастомных:
// (теперь мы можем складывать обычные числа с деньгами)
operator fun Int.plus(mon: Money): Money{
    return Money(this + mon.amount)
}

fun main(){
    val m1 = Money(100)
    val m2 = Money(200)
    val m3: Money = m1 + m2
    println(m3.amount)


    val m4: Money = m1 - m2
    println(m4.amount)

    val m5 = 5 + m1
    println(m5.amount)

}