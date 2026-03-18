package edu.cesspool.metanit.practice2_basics


fun main(){
    val grades = inputGrades()
    showCommand()
    loopApp(grades)
}

/**Показывает список комманд*/
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

/**Ввод оценок студентов*/
fun inputGrades() : Array<Int>{
    val quantityStudent = inputQuantityStudent()

    // создаем массив нужного размера
    val arrGrades = Array(quantityStudent, {0})

    println("Начинаем ввод оценок")
    for (i in 0..quantityStudent - 1) {
        print("Введите оценку для студента ${i+1} : ")
        arrGrades[i] = inputOneGrade()
    }

    return arrGrades
}

/**Ввод числа с консоли*/
fun inputOneGrade() : Int{
    var inp: Int? = 0

    while(true){
        inp = readln().toIntOrNull()
        if (inp == null || inp !in 2..5) {
            println("Введите нормальное число в диапазоне от 2 до 5:")
            continue
        } else break
    }

    return inp
}

/**Ввод количества студентов в консоли*/
fun inputQuantityStudent(): Int{
    print("Введите количество студентов : ")
    var numberOfStudent: Int? = 0

    while (true){
        numberOfStudent = readln().toIntOrNull()
        if (numberOfStudent == null) print("Введите корректное число : ")
        else break
    }

    return numberOfStudent
}

/**Показать все оценки*/
fun showAllGrades(arrGrades: Array<Int>){
    print("Оценки: ")
    for (i in arrGrades) print("$i ")
    println()
}

/**Цикл приложения
 *
 * Проверяет ввод команд от пользователя и вызывает соответствующую функцию*/
fun loopApp(grades:  Array<Int>){
    while (true){
        val inp = readln().toIntOrNull()
        if (inp == 7) break
        if (inp !in 1..7 || inp == null){
            println("Введите число от 1 до 7. Команда неизвестна!")
            continue
        }

        selectAction(inp, grades)
    }
}

/**Выбор действия*/
fun selectAction(number: Int, grades: Array<Int>){
    when (number){
        1 -> showAllGrades(grades) // вывести все оценки
        2 -> averageGrade(grades) // средняя оценка
        3 -> maxGrade(grades) // максимальная оценка
        4 -> minGrade(grades) // минимальная оценка
        5 -> quantityExcellentStudent(grades) // посчитать количество отличников
        6 -> isTwos(grades) // проверить наличие двоек
        else -> println("Неизвестный ввод!!!")
    }
}

fun averageGrade(grades:  Array<Int>){
    println("Средняя оценка : %.2f".format(grades.average()))
}

fun maxGrade(grades:  Array<Int>){
    println("Максимум : ${grades.max()}")
}

fun minGrade(grades:  Array<Int>){
    println("Минимальная ${grades.min()}")
}

fun quantityExcellentStudent(grades:  Array<Int>){
    var quantity = 0
    for (i in grades){
        if (i == 5) quantity++
    }
    println("Количество пятерок : ${quantity}")
}

fun isTwos(grades:  Array<Int>){
    var quantity = 0
    for (i in grades){
        if (i == 2) quantity++
    }
    if (quantity > 0) println("Двойки имеются")
    else println("Двоек нет")
}