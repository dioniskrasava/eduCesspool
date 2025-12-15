package edu.cesspool.metanit.chapter3_functionalProgramming

import edu.cesspool.metanit.chapter2_basics.wrap

fun main(){
    wrap("MANY STRING"){printString("lol","kek","cheburek!")}
    wrap("SUMM"){summator(3,5,10,-8)}

    val numbers = intArrayOf(1,2,3,4,5,6,7,8,9)
    //val numbers = arrayOf(1,2,3,4,5,6,7,8,9) // Err

    /**
     * Удивительно. Но :
     * val numbers = intArrayOf(1,2,3,4,5,6,7,8,9)
     * val numbers = arrayOf(1,2,3,4,5,6,7,8,9)
     *
     * вернут разные объекты. А именно:
     *
     *  IntArray
     *  Array<Int>
     * */

    //summator(numbers) // Err

    // НЕОБХОДИМО ИСПОЛЬЗОВАТЬ ЗВЕЗДОЧКУ !!!
    //
    //         *оператор распаковки*
    //
    // потому что функция ждет
    // неопределенное количество значений, а не массив
    // поэтому мы можем утверждать, что звездочка преобразует массив в неопределенное
    // количество значений
    summator(*numbers)

}

//many string!
// в данную функцию можно передать неопределенно много строк
fun printString(vararg string: String){
    for (str in string){
        println(str)
    }
}


//summ

fun summator(vararg numbers: Int){
    var summ = 0
    for (i in numbers)
        summ += i

    println("Summ = $summ")
}

// ОБЫЧНО vararg-параметр является последним в сигнатуре функции
// НО!
// если он не последний, то при вызове функции, нужно будет использовать
// именнованные аргументы


