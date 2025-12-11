package edu.cesspool.metanit.chapter2_basics

fun main(){
    /*ЗАПУСКАЕМ ПРИМЕРЫ С КРАСИВОЙ ОБЕРТКОЙ*/
    wrap("WHEN IS BOOLEAN"){whenIsBoolean()}
    wrap("WHEN IS INTEGER"){whenIsInt()}
    wrap("WHEN IS BLOCK CODES"){whenIsBlockCodes()}

    wrap("FEW VALUESA AND RANGE") {whenIsFewValuesAndRange()}
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
        in 50..60 -> println("а В диапазоне [50;60]")
        !in 10..40 -> println("а НЕ в диапазоне [10;40]")
    }
}
















