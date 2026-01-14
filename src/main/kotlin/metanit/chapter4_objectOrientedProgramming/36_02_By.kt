package edu.cesspool.metanit.chapter4_objectOrientedProgramming.less36_02
/** ДЕЛЕГИРОВАНИЕ (Delegation)*/

/**
 * Паттерн, при котором объект выражает некоторое поведение (например, реализует
 * интерфейс), но вместо самостоятельной реализации переадресует (делегирует)
 * выполнение задач другому, связанному с ним объекту (делегату)
 *
 * Ключевое слово `by` в Kotlin автоматически генерирует код для такой переадресации
 *
 * Это альтернатива наследованию (композиция вместо наследования)
 * */

interface Messenger{
    fun send(message: String)
}

class InstantMessenger(val programName: String) : Messenger{
    override fun send(message: String){
        println("[$programName] Message отправлен: `$message`")
    }
}

/**
 * Пример 1: Простое делегирование
 * Класс SmartPhoneSimple реализует интерфейс Messenger, но всю работу
 * по отправке сообщений он делегирует объекту 'm' (делегату).
 * Класс SmartPhoneSimple не наследует от InstantMessenger, а содержит его*/
class SmartPhoneSimple(val name: String, private val m: Messenger) : Messenger by m


/**
 * Пример 2: Делегирование с модификацией поведения.
 * Класс может переопределить некоторые методы интефейса,
 * а другие по прежнему делегировать.
 * Это дает гибкость которую сложно получить при простом наследовании.
 * */
class SmartPhoneAdvanced(val name: String, private val m: Messenger) : Messenger by m {

    // Мы можем добавить собственную логику вокруг вызова делегата
    override fun send(message: String){
        println("Смартфон '$name' начинает отправку...")
        // Делегирует основную работу объекту 'm'
        m.send(message)
        println("Отправка завершена.")
    }

    // А также добавить свои уникальные методы
    fun makeCall(number: String){
        println("Звонок на $number")
    }
}

fun main(){
    val telegram = InstantMessenger("Telegram")

    // Пример 1 : Простое делегирование
    val pixelSimple = SmartPhoneSimple("Pixel 5", telegram)
    pixelSimple.send("Привет!") // вызов автоматически делегируется telegram

    // Пример 2 : Делегирование с доп. логикой
    val pixelAdvanced = SmartPhoneAdvanced("Pixel 6", telegram)
    pixelAdvanced.send("Изучаю Kotlin!")          // Будет лог и вызов делегата
    pixelAdvanced.makeCall("+123456789") // Свой метод, не из Messenger

}