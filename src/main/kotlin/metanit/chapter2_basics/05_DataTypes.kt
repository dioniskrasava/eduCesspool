package edu.cesspool.metanit.chapter2_basics

import kotlin.system.exitProcess

/*
*

    Byte: хранит целое число от -128 до 127 и занимает 1 байт

    Short: хранит целое число от -32 768 до 32 767 и занимает 2 байта

    Int: хранит целое число от -2 147 483 648 (-2^31) до 2 147 483 647 (2^31 - 1) и занимает 4 байта

    Long: хранит целое число от –9 223 372 036 854 775 808 (-2^63) до 9 223 372 036 854 775 807 (2^63-1) и занимает 8 байт

* */


/*
*

    UByte: хранит целое число от 0 до 255 и занимает 1 байт

    UShort: хранит целое число от 0 до 65 535 и занимает 2 байта

    UInt: хранит целое число от 0 до 2^32 - 1 и занимает 4 байта

    ULong: хранит целое число от 0 до 2^64-1 и занимает 8 байт

*
* */


fun main(){
    val a: Byte = -128
    val b: Short = 32767
    val c: Int = 1_000_000

    val d: Long = 2_147_483_647
    val d2: Long = 2_147_483_647L

    val d3: Long = 2_147_483_648
    val d4: Long = 2_147_483_648L


    /*
    * idea - подсвечивает белым то, что она преобразует в иной тип данных и
    * подсвечивает тип данных серым если имеется явный подобный числовой литерал без
    * преобразования.
    *
    * -128 - без суффикса - это Int
    *
    * 32767 - Int - но в итоге преобразуется в Short
    *
    * */


    println("= ${d*d2}")


    /*- - - - - - - -      У С Е Ч Е Н Н Ы Е       Ч И С Л А      - - - - - - - - */

    val e: UByte = 10U // суффикс U - обязательный!
    val f: UShort = 45U
    val g: UInt = 250U
    val h: ULong = 30000U



    /*- - - - - - - -     1 6 -  И Ч Н Ы Е        Ч И С Л А     - - - - - - - -  */

    val num : Int = 0x0A1
    println(num) // ВЫВЕДЕТ 161 (преобразует автоматически в десятичный формат)


    /*- - - - - - - -       2 - И Ч Н Ы Е     Ч И С Л А      - - - - - - - -  */

    val num2: Int = 0b0101   // 5
    val num3: Int = 0b1011   // 11

    println("--------------------")
    println("0101 = $num2")
    println("1011 = $num3")



    //---------------------------------
    float()
    double()
    boolean()
    char()

}




/*- - - - - - - -    Ч И С Л А   С   П Л А В А Ю Щ Е Й    Т О Ч К О Й    - - - - - - - -  */
fun float(){

    // FLOAT

    // СТАВИМ СУФФИК F ИЛИ f !!!
    //
    // О Б Я З А Т Е Л Ь Н О  !

    val pi: Float = 3.14F

    /*
    * Данный тип данных НЕТОЧЕН! Он тратит часть бит на мантису и чать на порядок.
    *
    * например: 1.2345 * 10^38
    *
    * вроде бы как число большое но теряется точность. Из-за этого например вот этот код:
    *
    * */

    val hugeFloat: Float = 2.0E9f       // 2 000 000 000 (2 миллиарда)
    val nextFloat: Float = 2.0000001E9f // 2 000 000 100

    println("=======FLOAT==========")
    println("2.0E9f = $hugeFloat")
    println("2.0000001E9f = $nextFloat") // 2.00000013E9 !!! ЧИСЛО ИЗМЕНИЛОСЬ
}



/*- - - - - - - -    D O U B L E     - - - - - - - -  */
fun double(){
    // DOUBLE
    val heigh: Double = 1.81
    val heigh2: Double = 1.80


    val d01: Double = 23e3
    val d02: Double = 23e-3

    println("=======DOUBLE==========")
    println("23e3 = ${d01}1") // 23000.01
    println("23e2 = $d02")    // 0.023
}


/*- - - - - - - -    Л О Г И Ч Е С К И Й     Т И П     - - - - - - - -  */
fun boolean(){
    val a: Boolean = true
    val b: Boolean = false

    println("=======BOOLEAN======")
    println("a = $a")
    println("b = $b")
    println()
}


/*- - - - - - - -    С И М В О Л Ы     - - - - - - - -  */
fun char(){
    val a: Char = 'A'
    val b: Char = 'B'

    val tab: Char = '\t'   // табуляция
    val enter: Char = '\n' // new line

    println("=========CHAR==========")
    println("Hello! It is example for $enter using char! $a $b $tab next next next")

}

