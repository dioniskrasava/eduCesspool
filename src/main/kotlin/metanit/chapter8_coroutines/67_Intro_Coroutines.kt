package edu.cesspool.metanit.chapter8_coroutines

//


import kotlinx.coroutines.delay
import kotlinx.coroutines.*

// suspend - функция, которая может приостановить свое выполнение
// suspend ф-ии вызываются из других suspend функций

/**
 * В данной функции не используются корутины и асинхронность
 *    основной поток программы блокируется и ожидает испольнения
 *    for, а затем идет дальше
 *
 * Асинхронность - отсутствие блокировки основного потока исполнения программы в то время пока выполняются
 *                 функции, требующие времени. (Пример : программа не виснет, пока ждет данные с интернета)
 * */
suspend fun simpleExample(){
    for (i in 0..5){
        delay(1000L)
        println(i)
    }

    println("Hello Coroutines")
}


suspend fun exampleCoroutines1() = coroutineScope {
    launch {
        for (i in 0..5){
            delay(1000L)
            println(i)
        }
    }

    println("Hello Coroutines")
}


suspend fun main(){
    //simpleExample()
    exampleCoroutines1()
}