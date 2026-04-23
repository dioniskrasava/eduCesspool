package edu.cesspool.metanit.chapter8_coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// Область корутин
// урок https://metanit.com/kotlin/tutorial/8.2.php

/**
 * coroutineScope - создается область корутин
 *
 *    область корутин - контейнер для жизни корутин.
 *       например может быть нужен когда необходимо отменить все корутины разом.
 *       (это может быть нужно для того чтобы не плодить зомби-процессы, которые выполняются
 *       в то время, когда они уже не нужны. Например пользователь зашел в список контактов и
 *       сразу же назал кнопку назад, передумав. Значит нам уже не нужно обращаться на сервер
 *       для получения списка контактов)
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