package edu.cesspool.micro_apps.nutritional_app

fun main(){

    // хранит список продуктов в качестве переменной
    //val listProduct =

    welcome()
    selectAction()
}

/**
 * Экран приветствия
 * */
fun welcome(){
    println("|-----------------------------------------|")
    println("| Console NuJo                            |")
    println("|-----------------------------------------|")
    println("| Выберите действие и нажмите enter:      |")
    println("|   1. Внести продукт                     |")
    println("|   2. Вывести список продуктов           |")
    println("|                                         |")
    println("|-----------------------------------------|")
}


data class Product(
    var name: String,              // название
    var proteins: Float,           // белки
    var fats: Float,               // жиры
    var carbohydrates: Float,      // углеводы
    var calorific: Float           // калории
)

/**
 *  Ручной ввод продукта
 */
fun readProductManually(): Product{
    println("ЗАБИВАЕМ НОВЫЙ ПРОДУКТ В БАЗУ")

    print("Название продукта : ")
    val name = readln()
    print("Количество белков : ")
    val proteins = readFloatSafely()
    print("Количество жиров : ")
    val fats = readFloatSafely()
    print("Количество углеводов : ")
    val carbohydrates = readFloatSafely()
    print("Калорийность продукта : ")
    val calorific = readFloatSafely()

    return Product(name, proteins, fats, carbohydrates, calorific)
}

/**
 * Выводит список продуктов
 * */
fun showAllProducts(){

}

/**
 * Безопасный ввод дробного числа
 */
fun readFloatSafely(): Float{
    while (true){
        val number = readln().toFloatOrNull()
        if (number != null) return number
        println("Вы ввели не число. Попробуйте снова!")
    }
}

fun selectAction(){

    var command: Int?

    while (true){
        print("Выберите команду : ")
        command = readln().toIntOrNull()
        if (command != null) break
        println("Неизвестная команда. Повторите ввод.")
    }



    when (command){
        1 -> readProductManually()
        2 -> showAllProducts()
        else -> println("Неизвестная команда")
    }

}