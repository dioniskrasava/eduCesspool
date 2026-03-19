package edu.cesspool.metanit.chapter5_generics.less41_03

// --- Общая иерархия классов ---
open class Fruit(val name: String)
class Apple(name: String = "Яблоко"): Fruit(name)
class Banana(name: String = "Банан"): Fruit(name)

// ===== 1. ИНВАРИАНТНОСТЬ (нет модификатора) =====
// Класс-коробка, который может и принимать и отдавать значения
// Типы Box<Apple> и Box<Fruit> никак не связаны

class Box<T>(private var item: T){
    fun put(item: T) {this.item = item}
    fun get(): T = item
}

//               *****  К О Д   П Р И М Е Р А  *****
fun exampleInvariance(){
    println("=== ИНВАРИАНТНОСТЬ (Box) ===")
    val appleBox: Box<Apple> = Box(Apple("Зеленое яблоко"))
    val fruitBox: Box<Fruit> = Box(Fruit("Ананас"))

    // 1. Нельзя присвоить переменную типа Box<Apple> переменной типа Box<Friut>
    // хоть и класс Apple наследник класса Fruit
    // val test1: Box<Fruit> = appleBox // ОШИБКА: Type mismatch

    // 2. Нельзя присвоить Box<Fruit> переменной типа Box<Apple>
    // val test2: Box<Apple> = fruitBox  // ОШИБКА: Type mismatch

    // 3. Но положить Apple в Box<Fruit> можно (Apple - подтип Friut)
    fruitBox.put(Apple("Маленькое яблочко"))
    println("Коробка фруктов fruitBox содержит : ${fruitBox.get().name}")
}

//---------------------------------------------------------------------------------

// ===== 2. КОВАРИАНТНОСТЬ (out)  =====
// Интерфейс-производитель: только возвращает Т (out).
// Producer<Apple> можно использовать как Producer<Fruit>

interface Producer<out T> {
    fun produce(): T
}


class AppleOrchard : Producer<Apple>{
    override fun produce(): Apple = Apple()
}

class BananaPlantation: Producer<Banana>{
    override fun produce(): Banana = Banana()
}


// ===== 3. КОНТРАВАРИАНТНОСТЬ (in) =====
// Интерфейс-потребитель: только принимает Т (in).
// Consumer<Fruit> можно использовать как Consumer<Apple>

interface Consumer<in T> {
    fun consume(item: T)
}

class FruitEater : Consumer<Fruit>{
    override fun consume(item: Fruit){
        println("Съел фрукт: ${item.name}")
    }
}

class AppleEater : Consumer<Apple>{
    override fun consume(item: Apple){
        println("Съел яблоко: ${item.name}")
    }
}



// ===== Демонстрация всех трёх видов в одном месте =====
fun main(){
    exampleInvariance()


    println("\n=== КОВАРИАНТНОСТЬ (Producer) ===")
    val appleProducer: Producer<Apple> = AppleOrchard()
    val bananaProducer: Producer<Banana> = BananaPlantation()

    // 4. Ковариантность: Producer<Apple> можно присвоить Producer<Fruit>
    val fruitProducer1: Producer<Fruit> = appleProducer
    val fruitProducer2: Producer<Fruit> = bananaProducer


    // ДАЛЕЕ УДАЛИ И РУЧКАМИ ПОЧЕКАЙ:
    //
    // ВСТАВЛЯЮ ЧТОБЫ НЕ ПОТЕРЯТЬ !!!!!!!!!!!!!!!!!!!!!!!!!!!!!! уууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууудоли


    // 5. Функция, ожидающая Producer<Fruit>, принимает Producer<Apple>
    fun harvest(producer: Producer<Fruit>) {
        val fruit = producer.produce()
        println("Собрали: ${fruit.name}")
    }
    harvest(appleProducer)   // OK
    harvest(bananaProducer)  // OK

    // 6. Но нельзя использовать Producer<Fruit> там, где нужен Producer<Apple>
    // val appleProducerAgain: Producer<Apple> = fruitProducer1 // ОШИБКА (хотя fruitProducer1 ссылается на AppleOrchard, тип переменной - Producer<Fruit>)

    println("\n=== КОНТРАВАРИАНТНОСТЬ (Consumer) ===")
    val fruitEater: Consumer<Fruit> = FruitEater()
    val appleEater: Consumer<Apple> = AppleEater()

    // 7. Контравариантность: Consumer<Fruit> можно присвоить Consumer<Apple>
    val consumerForApple: Consumer<Apple> = fruitEater  // OK

    // 8. Функция, ожидающая Consumer<Apple>, принимает Consumer<Fruit>
    fun feedApple(eater: Consumer<Apple>, apple: Apple) {
        eater.consume(apple)
    }
    feedApple(fruitEater, Apple())   // OK (fruitEater - Consumer<Fruit>)
    feedApple(appleEater, Apple())   // OK

    // 9. Но нельзя использовать Consumer<Apple> там, где нужен Consumer<Fruit>
    // val fruitEaterAgain: Consumer<Fruit> = appleEater // ОШИБКА

    println("\n=== Примеры из стандартной библиотеки Kotlin ===")
    // Инвариантность: MutableList
    val mutableAppleList: MutableList<Apple> = mutableListOf(Apple(), Apple())
    // val mutableFruitList: MutableList<Fruit> = mutableAppleList // ОШИБКА (инвариантность)

    // Ковариантность: List (read-only)
    val appleList: List<Apple> = listOf(Apple(), Apple())
    val fruitList: List<Fruit> = appleList // OK (ковариантность)

    // Контравариантность: Comparator
    val fruitComparator: Comparator<Fruit> = compareBy { it.name }
    val appleComparator: Comparator<Apple> = fruitComparator // OK (контравариантность)
    val apples = listOf(Apple("Гренни Смит"), Apple("Фуджи"))
    println("Отсортированные яблоки: ${apples.sortedWith(fruitComparator).map { it.name }}")

}




