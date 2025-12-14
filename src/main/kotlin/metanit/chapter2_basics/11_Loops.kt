package edu.cesspool.metanit.chapter2_basics


fun main(){
    wrap("FOR"){forExample()}
    wrap("TABLE MULTIPLY"){tableMultiply()}
    wrap("WHILE"){loopWhile()}
    wrap("DO WHILE"){loopDoWhile()}
    wrap("CONTINUE"){loopContinue()}
    wrap("BREAK"){loopBreak()}
    wrap("LOOP BREAK WITH LABEL"){loopBreakWithLabel()}
}

// for
fun forExample(){
    for (i in 1..9){
        print("$i \t")
    }
    println()
}

// for в for-e (пример с таблицей умножения)
fun tableMultiply(){
    for (i in 1..9){
        for (j in 1..9){
            print("${i*j} \t")
        }
        println("")
    }
}


// цикл while
fun loopWhile(){
    var i = 1
    while (i < 10){
        print("$i ")
        i++
    }
    println()
}

//   do-while
fun loopDoWhile(){
    var i = -1

    do {
        print(i)
        i--
    } while (i > 0)

    println()
}


// continue
fun loopContinue(){

    // вываливаемся из ИТЕРАЦИИ если i равно 5 или 7
    // в остальных случаях цикл работает в штатном режиме (намана-намана)
    for (i in 1..9){
        if ((i == 5) or (i == 7)) continue
        print("$i ")
    }


    println()
}


// break
fun loopBreak(){

    // вываливаемся из ЦИКЛА если i = 15
    for (i in 1..100){
        if (i == 15) {
            println("\"Я устал считать!!!! =(\"")
            break
        }
        print("$i ")
    }

}


// break-label
// необходим в случае когда нужно выйти к примеру из нескольких циклов по оператору break
fun loopBreakWithLabel(){

    for (i in 1..6){
        for (j in 1..4){
            print("$i$j")
        }
        println()
    }
}





















