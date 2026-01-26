package edu.cesspool.metanit.chapter4_objectOrientedProgramming.less36_04

// множественное делегирование
// переопределение функций


interface Messenger {
    fun sendTextMessage(message: String)
    fun sendVideoMessage()
}

class InstantMessenger(val programName: String) : Messenger{
    override fun sendTextMessage(message: String) {
        println("($programName)Send message: $message")
    }

    override fun sendVideoMessage() {
        println("Send video message (MESSAGER)")
    }

}

interface PhotoDevice{
    fun takePhoto()
}

class PhotoCamera : PhotoDevice{
    override fun takePhoto() {
        println("Take a photo")
    }
}

// Множественное делегирование
class SmartPhone(val name: String, m: Messenger, p: PhotoDevice) : Messenger by m, PhotoDevice by p {

    // Переопределили функцию
    // Класс сам реализует эту функцию, поэтому не вызывается функция объекта-делегата
    override fun sendVideoMessage() {
        println("Переопределенная отправка видео-сообщения")
    }
}


fun main(){
    val telegram = InstantMessenger("TG")
    val camera = PhotoCamera()

    val honorx7c = SmartPhone("Honor x7c", telegram, camera)

    honorx7c.sendTextMessage("Lol/Kek/Cheburek!")
    honorx7c.sendVideoMessage()
    honorx7c.takePhoto()

}