package edu.cesspool.metanit.chapter5_generics.less40_05

//    G E N E R I C   C O N S T R A I N T S
//
//    О Г Р А Н И Ч Е Н И Е   О Б О Б Щ Е Н И Й


interface Message {
    val text : String
}

interface Logger {
    fun log()
}

class EmailMessage(override val text: String ): Message, Logger{
    override fun log() {
        println("Email: $text")
    }
}

class SmsMessage(override val text: String) : Message, Logger{
    override fun log() {
        println("SMS: $text")
    }
}

/** Параметр Т должен быть объектом класса наследующего интерфейс Message и Logger*/
fun <T> send(message: T) where T: Message, T: Logger{
    message.log()
}

fun main(){
    val email = EmailMessage("Hello!")
    val sms = SmsMessage("Goodbye")

    send(email)
    send(sms)
}