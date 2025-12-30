package edu.cesspool.metanit.chapter4_objectOrientedProgramming.less33_03

/** ВЛОЖЕННЫЕ И ВНУТРЕННИЕ КЛАССЫ И ИНТЕРФЕЙСЫ
 *  Классы могут содержать вложенные интерфейсы.
 *  Интерфейсы могут содержать вложенные классы*/


//----------------------------------------------------------------
//                                                               -
//                                                               -
//                         П Р И М Е Р    1                      -
//                                                               -
//                       А В Т О М О Б И Л И                     -
//                                                               -
//                                                               -
//                                                               -
// ---------------------------------------------------------------

/**
 * В принципе все по полочкам. И так.
 *
 * Еще раз. Интерфейс это набор данных (поля, методы, а теперь и классы и интерфейсы)
 * которые должен реализовать у себя другой класс, чтобы иметь возможность называться объектом
 * данного типа (интерфейса). В конкретном нижеописанном случае, есть сущность Car. Чтобы об
 * */
interface Car{

    val model: Model
    val engine: Engine

    interface Engine{
        fun start()
        fun stop()
    }

    data class Model (
        val name: String,
        val year: Int
    )

}

class Toyota(
    override val model: Car.Model,
    override val engine: Car.Engine
) : Car

// пример использования вышеописанных интерфейсов и классов
fun exampleAuto(){

    // забегаем немного вперед (спасибо, DeepSeek)
    val engine = object : Car.Engine {
        override fun start() {
            println("Двигатель запустился!")
        }

        override fun stop() {
            println("Двигатель остановился!")
        }
    }


    // ОБЪЕКТ ИНФОРМАЦИИ О МОДЕЛИ
    val model = Car.Model("Camry", 2022)

    // МАШИНА
    val car = Toyota(model,engine)

    println("Модель ${car.model.name}, год ${car.model.year}")
    car.engine.start()
    car.engine.stop()
}

//----------------------------------------------------------------
//                                                               -
//                                                               -
//                         П Р И М Е Р    2                      -
//                                                               -
//                         Ж И В О Т Н Ы Е                       -
//                                                               -
//                                                               -
//                                                               -
// ---------------------------------------------------------------

interface Animal {
    // вложенный интерфейс для способности издавать звуки
    interface Sound{
        fun makeSound()
    }

    // Вложенный класс для описания
    data class Info(
        val name: String,
        val age: Int,
    )

    val info: Info
    val sound: Sound
}

class Dog(
    override val info: Animal.Info,
    override val sound: Animal.Sound
) : Animal

fun exampleAnimal() {
    val sound = object : Animal.Sound {
        override fun makeSound() = println("Гав-гав!")
    }

    val info = Animal.Info("Бобик", 3)
    val dog = Dog(info, sound)

    println("Собака: ${dog.info.name}, возраст: ${dog.info.age}")
    dog.sound.makeSound()
}



//----------------------------------------------------------------
//                                                               -
//                           З А П У С К                         -
//                                                               -
// ---------------------------------------------------------------

fun main(){
    exampleAuto()
    println("---------")
    exampleAnimal()
}