package edu.cesspool.metanit.chapter4_objectOrientedProgramming.interfaces01

/** ЗАЧЕМ НУЖНЫ ИНТЕРФЕЙСЫ - вечный вопрос который меня интересовал
 *
 * а вот зачем:
 *      мы имеем функцию `travel` которая принимает в себя объект, который реализует интерфейс `Movable` и
 *      по итогу мы имеем явный пример полиморфизма. Читай код:
 *
 *      */

interface Movable{
    fun move()
}

class Car : Movable{
    override fun move() {
        println("Едем на машине")
    }
}

class Aircraft : Movable{
    override fun move() {
        println("Летим на самолете")
    }
}

/**ПОЛИМОРФИЗМ*/
fun travel(obj: Movable){
    obj.move()
}

fun main(){
    val car = Car()
    val aircraft = Aircraft()

    travel(car)
    travel(aircraft);

    /** МОЖНО КОНЕЧНО И НАПРЯМУ СОЗДАВАТЬ ОБЪЕКТЫ ИНТЕРФЕЙСА,
     *  но для их создания необходимо будет применять конструкторы классов,
     *  которые реализуют данный интерфейс */
    run {
        val car: Movable = Car()
        val aircraft : Movable = Aircraft()

        travel(car)
        travel(aircraft)
    }


}