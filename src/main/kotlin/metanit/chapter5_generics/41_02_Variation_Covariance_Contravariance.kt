package edu.cesspool.metanit.chapter5_generics.less41_02

import edu.cesspool.metanit.chapter5_generics.less41_01.Apple
import edu.cesspool.metanit.chapter5_generics.less41_01.Banana
import edu.cesspool.metanit.chapter5_generics.less41_01.Fruit

//  КОВАРИАНТНОСТЬ

// out (только чтение)

interface Producer<out T>{
    fun produce(): T
}

// яблочный фруктовый сад
class AppleOrchard: Producer<Apple>{
    override fun produce(): Apple = Apple()
}

class BananaPlantation: Producer<Banana>{
    override fun produce(): Banana = Banana()
}

// ф-я работ-ая с любым производителем фруктов
fun harvest(producer: Producer<Fruit>){
    val fruit = producer.produce()
    println("Собрали: ${fruit.name}")
}

fun main(){
    val appleProducer: Producer<Apple> = AppleOrchard()
    val bananaProducer: Producer<Banana> = BananaPlantation()

    // ковариантность позволяет присвоить Producer<Apple> переменной типа Producer<Fruit>
    val fruitProducer1: Producer<Fruit> = appleProducer
    val fruitProducer2: Producer<Fruit> = bananaProducer

    // функция ожидает producer<Fruit>, но может принять:
    harvest(appleProducer)  // producer<Apple>
    harvest(bananaProducer) // producer<Banana>


    // ПРИМЕР НЕ ОКОНЧЕН!!!
    // СМОТРИ СЛЕДУЮЩИЙ ПРИМЕР! ОН В СЕБЕ СОДЕРЖИТ ВСЕ ТРИ ВИДА ВАРИАНТНОСТИ
}


