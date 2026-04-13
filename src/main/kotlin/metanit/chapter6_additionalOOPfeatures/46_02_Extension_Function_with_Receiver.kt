package edu.cesspool.metanit.chapter6_additionalOOPfeatures.less46_02

// Extension function with receiver
// Функции расширения с получателем

// пример с построением HTML


// базовый класс для всех компонентов
abstract class HtmlElement(val tagName: String){
    val children = mutableListOf<HtmlElement>()
    val text: String = ""

    // Метод для добавления дочерних элементов
    fun <T : HtmlElement> doInit(element: T, init: T.() -> Unit){
        element.init() // выполняет лямбду-получатель для настройки дочернего элемента
        children.add(element)
    }

    // Метод для рендеринга HTML
    open fun render(indent: String = "", level: Int = 0): String{

    }
}

