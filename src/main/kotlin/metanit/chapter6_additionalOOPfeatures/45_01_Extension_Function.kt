package edu.cesspool.metanit.chapter6_additionalOOPfeatures

// Функции расширения

/*Функции которые мы дописываем к уже существующим типам*/

/**
 * Функции расширения не могут обращаться к полям private и protected.
 * Если функция расширения называется так-же как и уже определенный метод, то она будет игнорироваться компилятором.
 * */


// Считает количество букв в слове
fun String.countLetters(letter: Char): Int{
    var count = 0
    for (l in this){
        if (l == letter) count++
    }
    return count
}

// Возводит в квадрат целочисленное число
fun Int.square(): Int{
    return this * this
}



fun main(){
    val word = "Шалаш"
    val res1 = word.countLetters('ш')      // 1 (потому что одна буква большая)
    val res2 = word.countLetters('а')      // 2

    println(res1)
    println(res2)

    val number: Int = 5

    println(number.square())

}