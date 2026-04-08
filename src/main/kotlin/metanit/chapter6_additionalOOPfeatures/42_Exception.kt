package edu.cesspool.metanit.chapter6_additionalOOPfeatures.less42
// ДОПОЛНИТЕЛЬНЫЕ ВОЗМОЖНОСТИ ООП
//
// Обработка исключений

fun exampleOne(){

    // блоки catch, finally не обязательны, но какой-то один ДОЛЖЕН присутствовать
    // можно прописать много блоков catch (чтобы ловить разные исключения)

    try {
        val n1 = 2
        val n2 = 0
        val result = n1 / n2
        println("Result = $result")
    } catch (e: Exception){
        println("Ошибочка вышла =(")
        println(e)
    } finally {
        println("К сожалению у нас ничего не вышло с делением на ноль...")
    }

}

// сообщение исключения и стек-трейс
fun example2(){
    try {
        val n1 = 2
        val n2 = 0
        val result = n1 / n2
        println(result)
    } catch (e: Exception) {
        println("e.message = ${e.message}")
        for (line in e.stackTrace){       // набор строк где было сгенерировано исключение
            println("at $line")
        }
    }
}

// обработка нескольких исключений
fun example3(){
    try {
        val nums = arrayOf(1,2,3,4)
        println(nums[6])
    } catch (e: ArrayIndexOutOfBoundsException){
        println("Индекса массива за пределами индекса (исключение)")
    } catch (e: Exception){
        println(e.message)
    }
    // если одно исключение поймано, другие не срабатывают
}

// обработка нескольких исключений (2 вариант)
fun example4(){
    try {
        // ОДНА операция выбрасывает ТОЛЬКО ОДНО исключение
        val num = "abc".toInt() // throws NumberFormatException
    } catch (e: NullPointerException){
        // не сработает
        println("Этот текст никогда не выведется на экран!")
    } catch (e: NumberFormatException){
        // сработает
        // остальные игнорируются
        println("Ну нифига себе!!! Вот чего задумал!!!")
    } catch (e: Exception) {
        // этот тоже не сработает, т.к. уже поймали выше
        println("Этот тоже никогда не выведется на экран!")
    }
    /*
    * В одном try → максимум один catch срабатывает (тот, который подходит по типу первым)
    * */
}

// оператор throw
fun exampleThrow(){
    fun checkAge(age: Int): Int{
        if (age < 0 || age > 110) throw Exception("Неправильное значение age = $age. Должно быть в промежутке от 0 до 110")
        println("Age $age is valid")
        return age
    }

    checkAge(5)
    checkAge(25)
    checkAge(-5)  // exc
    checkAge(125) // exc
    println("До сюда exampleThrow2() не достанет =)")
}

// отработка исключений (чтобы программа не падала, а продолжала работать дальше)
fun exampleThrow2(){
    try {
        exampleThrow()
    } catch (e: Exception) {
        println("ОШИБОЧКА. ${e.message}")
    }
}

// try может возвращать значения
fun returnTry(){
    fun checkAge(age: Int): Int{
        if (age < 0) throw Exception("Отрицательный возраст???")
        if (age > 150) throw Exception("Видимо уже песок в трусах?")
        println("Возраст нормальный!")
        return age
    }

    val checkedAge1 = try {checkAge(15)} catch (e: Exception) {null}
    val checkedAge2 = try {checkAge(-5)} catch (e: Exception) {println(e.message); null}

    println("check 1 val = $checkedAge1")
    println("check 2 val = $checkedAge2")
}

fun main(){
    //exampleOne()
    //example2()
    //example3()
    //example4()
    //exampleThrow()
    //exampleThrow2() // не отработается значение 125 (потому что поймается первое исключение и завершится выполнение
    returnTry()
}