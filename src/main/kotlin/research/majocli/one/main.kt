package edu.cesspool.research.majocli.one

import java.time.LocalDateTime

/* Пишем простой пример CRUD приложения*/

data class Note(
    val id: Int,
    val name: String,
    val description: String = "",
    val timeCreate : LocalDateTime = LocalDateTime.now()
)


fun main(){
    val notes = mutableListOf<Note>()

    notes.add(Note(0, "Первая заметка"))
    notes.add(Note(1, name = "Вторая заметка", "Описание второй заметки"))

    println("Hello : $notes")
}