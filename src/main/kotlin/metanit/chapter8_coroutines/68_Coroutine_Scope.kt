package edu.cesspool.metanit.chapter8_coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// Область корутин
// урок https://metanit.com/kotlin/tutorial/8.2.php

/**
 * coroutineScope - создается область корутин
 * */
suspend fun ex1() = coroutineScope {
    launch {
        for (i in 0..5){
            delay(400L)
            println(i)
        }
    }

    launch {
        for (i in 6..10){
            delay(400L)
            println(i)
        }
    }

    println("Hello")
}

suspend fun main(){
    ex1()
}