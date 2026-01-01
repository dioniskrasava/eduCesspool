package edu.cesspool.metanit.chapter4_objectOrientedProgramming.less33_05

/** Внутренние (inner) классы
 * Совпадение имен*/


/** Простой пример */
class A{
    private val n: Int = 1

    inner class B{
        private val n: Int = 2
        fun action(){
            // ПРИМЕРЫ РЕШЕНИЯ КОНФЛИКТОВ ИМЕН :
            println(n)           //   n из класса B
            println(this.n)      //   n из класса B
            println(this@B.n)    //   n из класса B
            println(this@A.n)    //   n из класса A
        }
    }
}


//----------------------------------------------------------------
//                                                               -
//                              ПРИМЕР 2                         -
//                                                               -
// ---------------------------------------------------------------

class BankAccount(private var sum: Int){

    fun display(){
        println("sum = $sum")
    }

    inner class Transaction(private var sum: Int){
        fun pay(){
            this@BankAccount.sum -= this.sum       // ОБОШЛИ КОНФЛИКТ ИМЕН
            display()
        }
    }
}

fun runExample1(){
    val acc = BankAccount(3400)
    acc.Transaction(2400).pay()
}

fun main(){
    runExample1()
}