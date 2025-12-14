package edu.cesspool.metanit.chapter2_basics


fun main(){
    wrap("NUMBERS"){exampleArr()}
    wrap("CONSTRUCTOR ARRAY"){constructorArray()}
    wrap("CONSTRUCTOR ARRAY 2"){constructorArray2()}
    wrap("ACCRESSING ARRAY ELEMENTS"){accessingArrayElements()}
    wrap("ITERATING FOR ARRAY"){iteratingForArray()}
    wrap("SPECIFIC ARRAY CONSTRUCTOR"){specificArrayConstructor()}
}


fun exampleArr(){
    // массивы хранят данные ТОЛЬКО ОДНОГО и того же типа
    //
    // а не как во всяких питонах и ява-скриптах (кучи всякого дерьма)

    val numbers1: Array<Int> = arrayOf(1,2,3,4,5,6,7)
    val numbers2 = arrayOf(1,2,3,4,5,6,7)       // конечно можно без явного указания типа
    val numbers3 = arrayOfNulls<Int>(3)  // [null, null, null]

}


fun constructorArray(){
    val numbers = Array(3,{5}) // [5,5,5]
    println(numbers.toList())
}


fun constructorArray2(){
    var i = 1
    val numbers = Array(3,{i++ * 2}) // [2, 4, 6]
    println(numbers.toList())
}


fun accessingArrayElements(){
    val numbers = arrayOf(1,2,3,4,5,6)
    println("numbers[1] = ${numbers[1]}")

    //меняем элемент массива
    numbers[1] = 9
    println("numbers[1] = ${numbers[1]}")

    // размер массива
    println("numbers size = ${numbers.size}")

}


fun iteratingForArray(){
    val arr = arrayOf("Lol","Kek", "Cheburek!")

    for (i in arr){
        println(i)
    }

    println("kek is arr - ${"kek" in arr}") //false
    println("kek is arr - ${"Kek" in arr}") //true
}

fun specificArrayConstructor(){
    val numbers: IntArray = intArrayOf(1,2,3,4,5)
    val doubles: DoubleArray = doubleArrayOf(2.3, 4.6, 1.2)
    //BooleanArray
    //ByteArray
    //ShortArray
    //IntArray
    //LongArray
    //CharArray
    //FloatArray
    //DoubleArray

    val numbers2 = IntArray(3, {5})
    val doubles2 = DoubleArray(4, {6.5})
}







