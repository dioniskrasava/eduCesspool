package edu.cesspool.metanit.chapter4_objectOrientedProgramming.less37_03

/**
 * А Н О Н И М Н Ы Й   О Б Ъ Е К Т   К А К   Р Е З У Л Ь Т А Т   Ф У Н К Ц И И
 * */

// ФУНКЦИЯ, которая возвращает анонимный объект должна быть приватной
// если
// ф-я имеет модификатор public, private inline, то тогда свойства и функции
// анонимного класса (за исключением унаследованных) недоступны
private fun createPerson(_name: String, _company: String) = object{
    val name = _name
    val company = _company
    fun sayHello() = println("Hi, my name is $name. I work in $company")
}

private fun main(){
    val tom = createPerson("Tom", "JetBrains")
    tom.sayHello()

    inlineTest()
}


//------------------------------------------------------------------------------
//
// Если функция private inline, то она возвращает анонимный объект у которого мы можем обращаться
// к только унаследованным полям (от класса Person мы наследуем поле имени и к нему можем обращаться,
// а поле компании не унаследовано, поэтому мы не можем его юзать)
//
private inline fun createPerson2(_name: String, _company: String) = object : Person(_name){
    val company = _company
}

open class Person(val name: String)


fun inlineTest(){
    val tom = createPerson2("Tom", "JetBrainssss")
    println(tom.name) // норм - свойство унаследовано от класса Person
    //println(tom.company) // err - свойство недоступно
}