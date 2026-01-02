package edu.cesspool.metanit.chapter4_objectOrientedProgramming

/** Перечисления enum */

enum class Day(val value: Int, val trans: String){
    MONDAY(1, "Понедельник"),
    TUESDAY(2, "Вторник"),
    WEDNESDAY(3, "Среда"),
    THURSDAY(4, "Четверг"),
    FRIDAY(5, "Пятница"),
    SATURDAY(6, "Суббота"),
    SUNDAY(7, "Воскресенье")
}

fun exEnum01(){
    val day1: Day = Day.FRIDAY

    println(day1.name)       // FRIDAY
    println(day1.ordinal)    // 4
    println(day1.value)      // 5
    println(day1.trans)      // Пятница
    println(day1.hashCode()) // 1265094477

    /** Манипуляции с самим классом */
    println(Day.valueOf("SATURDAY")) //SATURDAY (возвращает именно сам объект тип Day по названию)

    println("------------ПЕРЕЧИСЛЯЕМ ВСЕ ОБЪЕКТЫ КЛАССА ПЕРЕЧИСЛЕНИЯ--------------")
    for (day in Day.values()){
        println("Day - $day - ${day.trans}")
    }
    println("----------------------------------------------------------------------")
}

fun main(){
    exEnum01()
}