package edu.cesspool.metanit.chapter2_basics

/**
 * ОПЕРАЦИИ
 *
 *      + СЛОЖЕНИЕ
 *
 *      - ВЫЧИТАНИЕ
 *
 *      * УМНОЖЕНИЕ
 *
 *      / ДЕЛЕНИЕ
 *
 * */



fun main(){

    exampleDivision()
    exampleDivisionIntDouble()
    exampleRemains()
    incremenAndDecrement()
}


// ОТБРАСЫВАЕТСЯ ОТСТАТОК
fun exampleDivision(){
    /*так как при делении целочисл на целочисл
    * в результате получается целочисл*/
    val x = 11
    val y = 5
    val z = x / y       // 2

    println("=======DIVISION INT INT========")
    println("int $x / int $y = $z")
}


// ЕСЛИ ОДИН ИЗ ОПЕРАНДОВ С ТОЧКОЙ, ТО И РЕЗУЛЬТАТ БУДЕТ С ТОЧКОЙ
fun exampleDivisionIntDouble(){
    val x = 11
    val y = 5.0
    val z = x / y

    println("=======DIVISION INT DOUBLE========")
    println("int $x / int $y = $z")
}


//ОСТАТОК ЦЕЛОЧИСЛЕННОГО ДЕЛЕНИЯ   -   %
fun exampleRemains(){
    val x = 11
    val y = 4
    val z = x % y

    println("======= % ========")
    println("int $x % int $y = $z")
}


fun incremenAndDecrement(){

    // ++x    Сначал УВЕЛИЧИТ значение переменной, затем уже вернет увеличенное значение
    // x++    Сначала ВЕРНЕТ значение, а затем уже увеличит

    /*

     var x = 5
     val y = --x
     println(x)      // x = 4
     println(y)      // y = 4

    */

    /*

    var x = 5
    val y = x--
    println(x)      // x = 4
    println(y)      // y = 5

*/

    // a += b    эквивалентно   a = a + b
    // a -= b    эквивалентно   a = a - b
    // a *= b    эквивалентно   a = a * b
    // a /= b    эквивалентно   a = a / b
    // a %= b    эквивалентно   a = a % b
}

// ДАЛЕЕ МНОЮ БЫЛО ПРИНЯТО РЕШЕНИЕ НЕ КОНСПЕКТИРОВАТЬ
// Поразрядные операции
// В СИЛУ РЕДКОГО РАСПРОСТРАНЕНИЯ ИХ ИСПОЛЬЗОВАНИЯ
// И СПЕЦИФИЧНОГО РАСПРОСТРАНЕНИЯ ИСПОЛЬЗОВАНИЯ