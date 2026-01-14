package edu.cesspool.metanit.chapter4_objectOrientedProgramming.less36_02
/** ДЕЛЕГИРОВАНИЕ */

/**Есть сущность мессенджер, которая должна уметь отправлять сообщения*/
interface Messenger {
    fun send(message: String)
}

/**Instant - моментальный
 *
 * (ДАЛЕЕ Я ПРОСТО ВСПОМИНАЮ ЧТО ТАКОЕ ИНТЕРФЕЙС)
 *
 * Есть класс, который умеет отправлять сообщения и его объект теперь может называться
 * мессенджером (и мы явно прописываем, что объект класса БыстрыйМессенджер это мессенджер)
 * */

class InstantMessenger(val programName: String) : Messenger{
    override fun send(message: String) {
        println("Message `$message` has been sent")
    }
}

/**Класс смартфона, который наследуется от интерфейса мессенджера, но как бы сам не является мессенджером, но
 * имеет в своем распоряжении объект мессенджера, с помощью которого может делать то, что умеет делать мессенджер*/
class SmartPhone(val name: String, m: Messenger): Messenger by m

fun main(){
    val telegram = InstantMessenger("Telegram")
    val pixel = SmartPhone("Pixel 5", telegram)

    pixel.send("Hello Kotlin")
    pixel.send("Learn Kotlin on Metanit.com!!!")
}