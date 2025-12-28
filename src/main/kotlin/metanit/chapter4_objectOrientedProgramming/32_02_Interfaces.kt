package edu.cesspool.metanit.chapter4_objectOrientedProgramming.interfaces02

/** Множественная реализация интерфейсов */

/** Стоит отметить один маленький факт, который заключается в том, что
 * класс НЕ МОЖЕТ наследоваться от ДВУХ И БОЛЕЕ классов, а вот
 * он двух и более интерфейсов - может! */

interface Worker{
    fun work()
}

interface Student{
    fun study()
}

/** Класс наследует ДВА интерфейса */
class WorkingStudent(val name: String) : Worker, Student{
    override fun work() {
        println("$name работает!")
    }

    override fun study() {
        println("$name учится!")
    }
}

fun main(){
    val tom = WorkingStudent("Tom")
    tom.study()
    tom.work()
}
