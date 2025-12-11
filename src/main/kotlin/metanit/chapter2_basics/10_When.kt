package edu.cesspool.metanit.chapter2_basics

fun main(){
    /*ЗАПУСКАЕМ ПРИМЕРЫ С КРАСИВОЙ ОБЕРТКОЙ*/
    wrap("WHEN IS BOOLEAN"){whenIsBoolean()}
    wrap("WHEN IS INTEGER"){whenIsInt()}
    wrap("WHEN IS BLOCK CODES"){whenIsBlockCodes()}

    wrap("FEW VALUESA AND RANGE") {whenIsFewValuesAndRange()}
    wrap("DINAMIC"){whenExampleDinamic()}
    wrap("DINAMIC 2"){whenExampleDinamic2()}
    wrap("VARIABLE") {whenVariables()}
    wrap("WHEN AGAINST IF..ELSE") {whenAgainIfElse()}
    wrap("RETURN"){whenReturn()}
}

// WHEN не должен покрывать все варианты

fun whenIsBoolean(){
    val isEnabled = true
    when (isEnabled){
        false -> println("isEnabled off")
        true  -> println("isEnabled on ")
    }
}


// МОЖНО писать else, для отработки всех остальных вариантов
fun whenIsInt(){
    val a = 30
    when (a){
        10 -> println("a = 10")
        20 -> println("a = 20")
        else -> println("I fuck what a number that is!")
    }
}

// МОЖНО в WHEN вызывать блоки кода
fun whenIsBlockCodes(){
    val a = 10

    when (a){
        10 -> {
            println("a = 10")
            val b = a * a
            println("Square $a = $b")
        }

        20 -> {
            println("a = 20")
            val b = a * a
            println("Square $a = $b")
        }

        else -> {
            println("Не знаю что за число ты ввел!")
            val b = a * a
            println("Square $a = $b")
        }


    }
}


// МОЖНО в WHEN перечислять несколько значений через запятую
// а МОЖНО описывать диапазон значений

fun whenIsFewValuesAndRange(){
    val a = 55

    when (a){
        10, 20 -> println("а = 10 или 20!")
        30, 40 -> println("a = 30 или 40")
        in 50..60 -> println("а В диапазоне [50;60]")  // !! ВЫПОЛНИТСЯ И ПРОГРАММА ВЫЙДЕТ ИЗ WHEN !!!!
        !in 10..40 -> println("а НЕ в диапазоне [10;40]")
    }
}

// можно писать в выражения динамически вычисляемые значения
fun whenExampleDinamic(){
    val a = 10
    val b = 5
    val c = 3

    when (a){
        b - c -> println("a = b - c")
        b + 5 -> println("a = b + 5")
        else -> println("неопределенное значение")
    }
}


// when МОЖЕТ принимать динамически вычисляемый объект
fun whenExampleDinamic2(){
    val a = 10
    val b = 20
    when (a+b){
        10 -> println("a + b = 10")
        20 -> println("a + b = 20")
        30 -> println("a + b = 30")
    }
}


// В объекте when можно объявлять переменные
fun whenVariables(){
    run {
        val a = 10
        val b = 26

        when (val c = a + b){
            10 -> println("с = a + b = 10")
            20 -> println("с = a + b = 20")
            else -> println("c = $c")
        }
    }

    /*=============ЕКВИВАЛЕНТНО==============*/
    run {
        val a = 10
        val b = 26
        val c = a + b

        when (c){
            10 -> println("с = a + b = 10")
            20 -> println("с = a + b = 20")
            else -> println("c = $c")
        }
    }
    /*========================================*/

// run -  способ вызвать эквивалентный код рядом не вызывая конфликта с названиями переменных
}


// КАК АЛЬТЕРНАТИВА IF ELSE
fun whenAgainIfElse(){
    val a = 15
    val b = 25

    when{
        (b > 10) -> println("b > 10") // ВЫПОЛНИТСЯ (выход из when)
        (a > 10) -> println("a > 10") // НЕ ВЫПОЛНИТСЯ (хотя и true)
        else -> println("a,b <= 10")
    }
}



// ВОЗВРАТ ЗНАЧЕНИЯ
fun whenReturn(){
    val  day = 2
    var dayOfWeek = when (day){
        1 -> "Monday"
        2 -> "Tuesday"
        3,4 -> "Wednesday or Thursday"
        else -> "Unknown. Maybe friday =)"
    }

    println(dayOfWeek)
}














