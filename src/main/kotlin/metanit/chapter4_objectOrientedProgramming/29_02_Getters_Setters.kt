package edu.cesspool.metanit.chapter4_objectOrientedProgramming
/**ИСПОЛЬЗОВАНИЕ ГЕТТЕРОВ И СЕТТЕРОВ В КЛАССАХ*/


class Person(val firstname: String, val lastname: String){
    var age = 0
        // сеттер с валидацией
        set(value) {
            if ((value >= 0) and (value <= 120))
                field = value
        }

    val fullname : String
        // геттер вычисляемый
        get() {
            return "$firstname $lastname"
        }
}


fun main(){
    val bob = Person("Bob", "Smith")
    println(bob.fullname)


    bob.age = 32
    println(bob.age)

    bob.age = 578
    println(bob.age)

}

