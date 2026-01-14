package edu.cesspool.metanit.chapter4_objectOrientedProgramming.less36_03

/** ДЕЛЕГИРОВАНИЕ (Delegation)
 * ПРИМЕР С ДВУМЯ РАЗНЫМИ РЕАЛИЗАЦИЯМИ*/

interface Messenger {
    fun send(message: String)
}

// Разные классы, но оба реализуют один интерфейс
class TelegramApp : Messenger {
    override fun send(message: String) {
        println("Telegram : $message")
    }
}

class WhatsAppApp : Messenger {
    override fun send(message: String) {
        println("Whatsapp : $message")
    }

    fun makeVideoCall() = println("Video call started") // уникальный метод
}

class SmartPhone(private val app : Messenger) : Messenger by app {
    // SmartPhone знает только про send(), не про makeVideoCall()
}

fun main(){
    val telegram = TelegramApp()
    val whatsapp = WhatsAppApp()

    //
    val phone1 = SmartPhone(telegram)
    val phone2 = SmartPhone(whatsapp)

    phone1.send("Hello")
    phone2.send("Hi")

    // phone2.makeVideoCall() // ERR! SmartPhone не знает про этот метод
    whatsapp.makeVideoCall()  // А так можно.
}