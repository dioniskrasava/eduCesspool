package edu.cesspool.metanit.chapter2_basics


fun main(){
    wrap("FOR"){forExample()}
    wrap("TABLE MULTIPLY"){tableMultiply()}
}


fun forExample(){
    for (i in 1..9){
        print("$i \t")
    }
    println()
}


fun tableMultiply(){
    for (i in 1..9){
        for (j in 1..9){
            print("${i*j} \t")
        }
        println("")
    }
}
