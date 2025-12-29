package edu.cesspool.metanit.chapter4_objectOrientedProgramming.interfaces04

/** ПРАВИЛА ПЕРЕОПРЕДЕЛЕНИЯ */

interface VideoPlayable{
    fun play() = println("Video plays!")
}

interface AudioPlayable{
    fun play() = println("Audio plays!")
}

/** Класс может наследовать несколько интерфейсов (интерфейсов и классов) в которых могут содержаться
 * реализации одних и тех же методов. В этом случае класс обязан переопределить его
 * (ЛОГИЧНО, потому что компилятор не поймет какой метод взять по умолчанию)*/
class MediaPlayer : VideoPlayable, AudioPlayable{
    override fun play() {
        println("Video and audio players!")
    }
}

/** ИЛИ вызов реализации метода кого-то из родителей. Или всех сразу. Или всех сразу и свои куски кода, или...*/
class MediaPlayer2 : VideoPlayable, AudioPlayable{
    override fun play() {
        super<VideoPlayable>.play() // вызываем VideoPlayable.play()
        super<AudioPlayable>.play() // вызываем AudioPlayable.play()
    }
}

fun main(){
    val mediaPlayer = MediaPlayer()
    mediaPlayer.play()
}
