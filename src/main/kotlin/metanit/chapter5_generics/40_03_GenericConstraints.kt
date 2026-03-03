package edu.cesspool.metanit.chapter5_generics.less40_03

//    G E N E R I C   C O N S T R A I N T S
//
//    О Г Р А Н И Ч Е Н И Е   О Б О Б Щ Е Н И Й

/**
 * Этот пример немного больше подходит, нежели вот такой:
 * ```
 * fun send(message: Message){
 *     println(message.text)
 * }
 * ```
 * Потому что в случае с вышеописанным примером МОЖНО было бы не заморачиваться с дженериками, а реализовать бы всё
 * через интерфейсы:
 * ```
 * send(message: Message){}
 * ```
 * Но если бы нам например нужно было бы распечатать сообщение и ВЕРНУТЬ объект данного типа (того же типа, что и
 * приняла функция, то нам нужны именно ДЖЕНЕРИКИ)
 * Потому что если мы будем принимать объект интерфейси соответственно возвращать объект интерфейса, то
 * у объекта теряется его уникальный тип и мы к примеру не сможем вызвать его уникальные методы, так
 * как интерфейс видит только те методы и поля, которые в нем объявлены, хотя у типа могут быть и свои
 * методы и поля, которые не прописаны в интерфейсы.
 *
 * Короче дженерики ПОЗВОЛЯЮТ СОХРАНИТЬ УНИКАЛЬНОСТЬ ТИПА
 *
 *
 *
 * */
fun <T:Message> sendAndReturn(message: T) : T{
    println(message.text)
    return message
}

interface Message{
    val text: String
}
class EmailMessage(override val text: String): Message
class SmsMessage(override val text: String): Message

fun main(){
    val email1 = EmailMessage("Hello (email)")
    val sms1 = SmsMessage("Hello (sms)")

   val returnEmail =  sendAndReturn(email1)
   val returnSms =  sendAndReturn(sms1)

}