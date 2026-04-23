package edu.cesspool.metanit.chapter8_coroutines.less68_03

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// корутины могут содержать в себе другие корутины

suspend fun main() = coroutineScope {
    launch {
        println("Outer coroutine")
        launch {
            println("Inner coroutine")
            delay(400L)
        }
    }

    println("End of Main")
}