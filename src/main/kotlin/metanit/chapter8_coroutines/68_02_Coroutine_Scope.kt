package edu.cesspool.metanit.chapter8_coroutines.less68_02

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// runBlocking блокирует вызывающий поток (пока все корутины внутри не завершатся)

fun main() {
    runBlocking {
        launch {
            for (i in 0..5){
                delay(400L)
                println(i)
            }
        }
        println("Hello, Coroutines!")
    }
    // Эта строка выполнится ТОЛЬКО после того, как цикл выше полностью отработает (пройдет 2.4 секунды)
    println("THE END. Поток разблокирован!")
}