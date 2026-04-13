package edu.cesspool.metanit.chapter6_additionalOOPfeatures.less46_04

// Extension function with receiver
// Функции расширения с получателем

// ПРИМЕР Kotlin DSL (Domain Specific Language) — это предметно-ориентированный язык.

// Пример: DSL для описания автомобиля с двигателем

class Engine {
    var type = ""
    var horsepower = 0
    var cylinders = 4

    override fun toString() = "Engine(type='$type', hp='$horsepower', cylinders=$cylinders)"
}


class Car {
    var brand = ""
    var model = ""
    var year = 0
    lateinit var engine: Engine

    // Функция для создания DSL внутри Car
    fun engine(block: Engine.() -> Unit){
        engine = Engine().apply(block)     // apply тоже использует receiver
                                           // apply просто что-то делает с объектом и возвращает его же
                                           //   в данном случае это просто возможность отработать какой-то код над объектом
                                           //   двигателя.
    }

    override fun toString() = "Car(brand='$brand', model='$model', year=$year, engine=$engine)"
}

// 2. Функция-строитель для Car
fun car(block: Car.() -> Unit): Car {
    return Car().apply(block)
}

// 3. ИСПОЛЬЗОВАНИЕ - вложенный DSL!
fun main(){
    val myCar = car {
        brand = "Tesla"
        model = "Model 3"
        year = 2024
        engine {
            type = "Electric"
            horsepower = 283
            cylinders = 0
        }
    }

    println(myCar)
}
