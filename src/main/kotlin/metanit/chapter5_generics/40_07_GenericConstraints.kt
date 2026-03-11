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

class EmailMessage(
    override val text
) : Message