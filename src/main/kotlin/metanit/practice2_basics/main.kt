package edu.cesspool.metanit.practice2_basics

fun main(){
    inputGrades()
    showCommand()
}

fun showCommand(){
    println("""
        =====================================================
        =    Выберите действие:                             =
        =   1. Вывести все оценки                           =
        =   2. Вычислить среднюю оценку                     =
        =   3. Найти максимальную оценку                    =
        =   4. Найти минимальную оценку                     =
        =   5. Посчитать количество отличников (оценка 5)   =
        =   6. Проверить наличие двоек                      = 
        =   7. Выйти                                        =
        =====================================================
    """.trimIndent())
}

fun inputGrades(){
    val quantityStudent = inputQuantityStudent()
}

fun inputQuantityStudent(): Int{
    print("Введите количество студентов : ")
    var numberOfStudent: Int? = 0

    while (true){
        numberOfStudent = readln().toIntOrNull()
        if (numberOfStudent == null) print("Введите корректное число : ")
        else break
    }

    println("Вы ввели $numberOfStudent")

    return numberOfStudent
}