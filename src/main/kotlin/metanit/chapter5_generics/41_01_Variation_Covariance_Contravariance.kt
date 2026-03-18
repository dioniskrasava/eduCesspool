package edu.cesspool.metanit.chapter5_generics

//-------------------------------------------------
//                                                -
//          В а р и а н т н о с т ь,              -
//                                                -
//        к о в а р и а н т н о с т ь             -
//                                                -
//       к о н т р а в а р и а н т н о с т ь      -
//                                                -
//-------------------------------------------------



open class Fruit(val name: String)
class Apple(name: String = "Яблоко") : Fruit(name)
class Banana(name: String = "Банан") : Fruit(name)


/** ИНВАРИАНТНОСТЬ
 *
 * (строгая коробка)*/
class Box<T>(private var item: T){
    fun put(item: T){ this.item = item}
    fun get(): T = item
}


fun main(){
    /**
     * Инвариативность означает, что типы Box<Apple> and Box<Fruit> никак не связаны.
     *          (даже если Apple подтип Fruit)
     *
     *          (это поведение по умолчанию)
     *
     *
     * ИНВАРИАТИВНЫЕ ТИПЫ СТРОГИ - ПЕРЕМЕННАЯ ДОЛЖНА ИМЕТЬ ТОЧНО ТАКОЙ ЖЕ ОБОБЩЕННЫЙ ВИД
     * */

    val appleBox: Box<Apple> = Box(Apple())
    val fruitBox: Box<Fruit> = Box(Fruit("Манго"))

    // можем создать фруктовую коробку с яблоком
    val fruitBox2: Box<Fruit> = Box(Apple("Зеленое яблоко"))

    //val fruitBox2: Box<Fruit> = appleBox // ERR: не можем коробке фруктов присвоить объект коробки яблок
    //val appleBox2: Box<Apple> = fruitBox // ERR: коробка яблок это не кор.фруктов


    fun takeFruitBox(box: Box<Fruit>){
        println("Получили фрукт: ${box.get().name}")
    }


    //takeFruitBox(appleBox) // ERR: ожидают коробку для фруктов, а не для яблок



    // ВЫВОД СОДЕРЖИМОГО
    // коробки яблок
    println(appleBox.get().name)
    // коробки фруктов 1
    println("Было в коробке фруктов(1): ")
    takeFruitBox(fruitBox)
    // изменение содержимого коробки фруктов
    println("Положили в коробку фруктов(1) яблоко.")
    fruitBox.put(Apple())
    // коробка фруктов 2
    takeFruitBox(fruitBox2)




    // Д Р У Г О Й   П Р И М Е Р

    // mutableList в котлине инвариантен

    val mutableListApple : MutableList<Apple> = mutableListOf<Apple>(
        Apple("Красное яблоко"),
        Apple("Зеленое яблоко"),
        Apple("Фиолетовое яблоко")
        )

    var mutableListFruit : MutableList<Fruit> = mutableListOf<Fruit>()
    //mutableListFruit = mutableListApple   // ERR: пытаемся присвоить список яблок переменной списка фруктов







}