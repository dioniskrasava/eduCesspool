package edu.cesspool.metanit.chapter5_generics.less39_07

/**
 * О Б О Б Щ Е Н Н Ы Е   Ф У Н К Ц И И
 * */

fun <T> getBiggest(args1 : Array<T>, args2: Array<T>) : Array<T>{
    if (args1.size > args2.size) return args1
    return args2
}


fun main(){
    val arr1 = getBiggest(arrayOf(1,2,3,4), arrayOf(1,2,3,4,5))
    arr1.forEach { item -> print("$item ") }

    val arr2 = getBiggest(arrayOf("Tom", "Bob", "Sam"), arrayOf("Tom", "Bob"))
    arr2.forEach { item -> print("$item ") }
}


/**
 * Вообще, как я понимаю, дженерики нужны чтобы долго не прописывать все возможные варианты использования
 * данного класса или функции.
 *
 * НУЖНО ДЛЯ ИЗБЕГАНИЯ ДУБЛИРОВАНИЯ КОДА
 *
 * Потому что если бы мы примерно прописали вышеописанную функцию для целых, дробных чисел, строк и например булей, то
 * мы бы имели дополнительных 15 строк ПОХОЖЕГО как две капли воды КОДА.
 *
 * А так - всё интуитивно понятно. (Как я детям на уроках объясняю - "Играем в ПОДСТАВЛЯШКИ")
 *
 * */