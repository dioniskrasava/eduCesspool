package edu.cesspool.micro_apps.nutritional_app

data class Product(
    var name: String,              // название
    var proteins: Float,           // белки
    var fats: Float,               // жиры
    var carbohydrates: Float,      // углеводы
    var calorific: Float           // калории
)