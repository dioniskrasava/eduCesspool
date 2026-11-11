package edu.cesspool.micro_apps.nutritional_app

import edu.cesspool.micro_apps.nutritional_app.Product

fun main(){

    val products = mutableListOf<Product>()

    welcome()
    selectAction(products)
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




/**
 *  Ручной ввод продукта
 */
fun readProductManually(): Product {
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
fun showAllProducts(products: MutableList<Product>){
    // добавить шапку через  println() с заголовками
    for (i in products) {
        print("Name - ${i.name} | ${i.proteins}| ${i.fats}| ${i.carbohydrates} | ${i.calorific}")
    }
}

/**
 * Безопасный ввод дробного числа
 */
fun readFloatSafely(): Float{
    // В будущем рассмотреть вопрос о проверке на отрицательность. Наверное не бывает отрицательной калорийности.
    while (true){
        val number = readln().toFloatOrNull()
        if (number != null) return number
        println("Вы ввели не число. Попробуйте снова!")
    }
}


fun selectAction(products: MutableList<Product>){


    var command: Int?

    while (true){
        print("Выберите команду : ")
        command = readln().toIntOrNull()
        if (command != null) break
        println("Неизвестная команда. Повторите ввод.")
    }


while (true){
    when (command){
        1 -> products.add(readProductManually())
        2 -> showAllProducts(products)
        0 -> return
        else -> println("Неизвестная команда")
    }
}


}