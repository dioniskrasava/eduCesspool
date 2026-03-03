package edu.cesspool.conspect_another.flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*


/** Функция, которая возвращает объект потока строк
 *
 * магия происходит в `emit()` - именно там происходит ВЫПЛЕВЫВАНИЕ куска данных в поток
 * */
fun freshDonutsFlow(): Flow<String> {
    return flow {

        val donuts = listOf<String>("Глазированный", "Шоколадный", "С посыпкой", "Джемовый")

        for (donut in donuts) {
            delay(2000)
            emit(donut)
        }
    }
}

/**
 * runBlocking позволяет запускать suspend функции в обычном коде
 * */
fun main() = runBlocking {

    freshDonutsFlow().collect { donut -> println("Ням-ням, съел $donut") }

}


