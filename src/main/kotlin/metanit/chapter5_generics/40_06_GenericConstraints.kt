package edu.cesspool.metanit.chapter5_generics.less40_06

//    G E N E R I C   C O N S T R A I N T S
//
//    О Г Р А Н И Ч Е Н И Е    В    К Л А С С А Х


interface Message {
    var text: String
}

class EmailMessage(override var text: String) : Message{
}

class Messenger<T:Message>(){
    fun send(mes: T){
        println(mes.text)
    }
}


fun main(){
    val someMessage = EmailMessage("Hello (email)")

    val someMessenger = Messenger<EmailMessage>()

    someMessenger.send(someMessage)


}