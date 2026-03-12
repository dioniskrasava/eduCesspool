package edu.cesspool.metanit.chapter5_generics.less40_07

//    G E N E R I C   C O N S T R A I N T S
//
//    О Г Р А Н И Ч Е Н И Е    В    К Л А С С А Х

interface Message{
    val text: String
}

interface Logger{
    fun log()
}

class EmailMessage(override val text: String) : Message, Logger {
    override fun log() {
        println("Email: $text")
    }
}

class SmsMessage(override val text: String) : Message, Logger {
    override fun log() {
        println("SMS: $text")
    }
}

//-------------------------------------------------------------------------------
//                                                                              -
//   !  !  !  !     С  А  М  Ы  Й     В  А  Ж  Н  Ы  Й     М  О  М  Е  Н  Т     -
//                                                                              -
//          ОГРАНИЧЕНИЕ В КЛАССЕ СОЗДАЕТСЯ С ПОМОЩЬЮ КЛЮЧЕВОГО СЛОВА WHERE      -
//                                                                              -
//-------------------------------------------------------------------------------
class Messenger<T>() where T: Message, T: Logger {
    fun send(mes: T){
        mes.log()
    }
}

fun main(){
    val email_message_1 = EmailMessage("Сообщение из электронной почты")
    val sms_message_1 = SmsMessage("Привет, ты спишь?")

    val outlook = Messenger<EmailMessage>()
    val skype = Messenger<SmsMessage>()

    outlook.send(email_message_1)
    skype.send(sms_message_1)
}