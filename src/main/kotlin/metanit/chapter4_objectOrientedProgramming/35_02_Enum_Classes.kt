package edu.cesspool.metanit.chapter4_objectOrientedProgramming.less35_02

/** Перечисления enum
 *
 * DAY, NIGHT - анонимные классы, которые
 * реализуют абстрактные методы и свойства класса перечисления*/


enum class DayTime{
    DAY{
        override fun printName() = println("День")
        override val startHour: Int = 6
        override val endHour: Int = 21

    },

    NIGHT{
        override fun printName() = println("Ночь")
        override val startHour: Int = 22
        override val endHour: Int = 5
    };

    abstract fun printName()
    abstract val startHour: Int
    abstract val endHour: Int
}

fun examEnum(){
    DayTime.DAY.printName()    // День
    DayTime.NIGHT.printName()  // Ночь
}

fun main(){
    examEnum()
}




