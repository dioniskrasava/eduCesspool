package edu.cesspool.metanit.chapter4_objectOrientedProgramming.interfaces03

/** РЕАЛИЗАЦИЯ МЕТОДОВ ПО УМОЛЧАНИЮ.
 *  РЕАЛИЗАЦИЯ СВОЙСТВ*/

/** Методы интерфейса могут иметь реализацию по умолчанию, а могут не иметь. Если они не имеют
 *  реализацию по умолчанию, то наследуемый этот интерфейс класс должен переопределить метод */
interface Movable{
    var speed: Int
    fun move() = println("Объект двигается")
    fun stop() {
        println("Объект остановился")
    }
}

/** Класс может принять методы родительского интерфейса как есть */
class Car : Movable{
    override var speed: Int = 20
}

/** А может и переопределить методы родительского интерфейса*/
class Air : Movable{
    override var speed: Int = 5
    override fun move() = println("Самолет летит к верху дутками!")
}

/** Можно переопределить свойство в конструкторе */
class Cart(override var speed: Int) : Movable{
    override fun move() {
        println("Повозка движется!")
    }

    override fun stop() {
        println("Повозка движется!")
    }
}

fun main(){
    val car = Car()

    car.move()
    car.stop()

    val air = Air()

    air.move()
    air.stop()
}
