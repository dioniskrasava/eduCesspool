package edu.cesspool.metanit.chapter3_functionalProgramming
// ОДНОСТРОЧНЫЕ И ЛОКАЛЬНЫЕ ФУНКЦИИ

fun main(){
    println("Square 15 = ${square(15)}")

    compareAge(15,18)
    compareAge(85,16)

}

// fun имя_функции (параметры_функции) = тело_функции
//
// слова return                 - нет
// типа возвращаемого значения  - нет

fun square(x: Int) = x * x

// можно указать тип возвращаемого значения
fun square2(x: Int): Int = x * x


//---------------------------------------------------------------------
// Укажем явно, что функция возвращает пустой тип Unit
fun compareAge(age1: Int, age2: Int) : Unit {

    //----------------------------------------------------
    //-                                                  -
    //-      !!!! Л О К А Л Ь Н А Я   Ф У Н К Ц И Я      -
    //-                                                  -
    //----------------------------------------------------
    fun ageIsValid(age: Int): Boolean {
        return age > 0 && age < 125
    } // кстати
    // её можно сделать однострочной:
    //
    // fun ageIsValif(age: Int): Boolean =  age > 0 && age < 125

    if (!ageIsValid(age1) || !ageIsValid(age2)){
        println("Неизвестный возраст!!!")
        return
    }

    when{
        age1 == age2 -> println("age1 ($age1) == age2 ($age2)")
        age1 > age2  -> println("age1 ($age1) > age2 ($age2)")
        age1 < age2  -> println("age1 ($age1) < age2 ($age2)")
    }


}

//----------------------------------------------------------------------
