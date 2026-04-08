package edu.cesspool.metanit.chapter6_additionalOOPfeatures.less43

// Null и nullable-типы

// введение
fun ex1(){
    // Есть типы которые поддерживают и не поддерживают null

    //val n : Int = null // ERR
    val n: Int? = null   // OK
}

// переменную nullable типа нельзя присвоить его младшему брату
fun ex2(){
    val a: Int? = 5
    //val b: Int = a   // err

    /*Скорее всего это вызвано тем, что может быть ситуация, когда null будет присваиваться обычной переменной*/
}

// Нельзя вызывать методы определенные для обычных переменных
// у перемменных нулэйбл
fun ex3(){
    var message: String? = "Hello"

    // err
    //print("${message.length}")  // .length есть у обычного типа, но не у нулэйбл
}

// Так-же нельзя передавать нулэйбл переменную в ф-ю, где ожидается обычный тип переменной
//
// например переменная ждет String переменную в кач-е аргумента, а мы передаем перем. типа String?
fun ex4(){}

// оператор ?:
fun ex5(){
    val name: String? = "Tom"
    val userName: String = name ?: "Undefined" // если name = null, то присваивается "Undefined"

    val age: Int? = 32
    val userAge: Int = age ?: 0               // если age = null, то присваивается 0

    /*
    оператор ?: принимает два операнда,
    если первый не равен null, то возвращается его значение,
    если первый равен null, то возвращается второй операнд
    */
}

// оператор ?.
// обращение к методам и полям объекта
fun ex6(){
    val name: String? = "Tom"
    val lenName = name?.length  // вернет длину, если объект = null, то вернет null
    println("Длина = $lenName")


    val newLenName = name?.length ?: 0  // если сделать так
                                        // то при поиске длины у null будет возвращаться не null,
                                        // а 0
}


// оператор !!
//         (not-null assertion operator)
fun ex7(){
    val name: String? = "Tom"
    val userName: String = name!!  // мы уверяем компилятор, что name не равно null
                                    // если бы оператора !! не было, то была бы ошибка
                                    // если всё-таки name = null, то вывалится исключение


    // фактически оператор !! берет значение и преобразует его в нот-нулэйбл тип
    //
    // поэтому можно через него например вызвать метод или поле, которого нет в нулэйбл брате
    val len = name!!.length

}

fun main(){
    ex6()
}