package edu.cesspool.research.majocli.one


fun main(){
    wrapBasicCode { choosingAction()}
}

/**Обертка для текста программы. Выводит приветственное слово, создает рамки вверху и внизу*/
fun wrapBasicCode(program : () -> Unit){
    val infoBegin = """
        |--------------------------------------------------------------------
        |Привет! Вы используете тестовую версию majo-cli.
        |Этот проект пишется в образовательных целях и не к чему не обязывает.
        |   Возможно тут будет всё ужасно!
        |   
        |   
    """.trimMargin()

    val infoEnd = """
        
        
        ---------------------------------------------------------------------
    """.trimIndent()

    println(infoBegin)
    program()
    println(infoEnd)

}


/**Выбор действия*/
fun choosingAction(){
    println(""" Выберите действие и нажмите ENTER:
        | 1. Добавить активность
        | 2. Вывести список активностей
        | 3. Редактировать активность
        | 4. Удалить активность
        | 
        | Ввод: 
    """.trimMargin())

    val a = readLine()

    println("Вы выбрали $a")
/*
    when (a) {
        1 -> addRecord(),
        2 ->

    }

*/

}

fun addRecord(){

}

data class Record(
    val id: Int,
    val name: String
)