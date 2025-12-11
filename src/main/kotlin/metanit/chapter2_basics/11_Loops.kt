package edu.cesspool.metanit.chapter2_basics


fun main(){
    wrap("FOR"){forExample()}
}


fun forExample(){
    for (i in 1..9){
        print("$i \t")
    }
    println()
}

