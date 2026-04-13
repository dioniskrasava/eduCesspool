package edu.cesspool.metanit.chapter6_additionalOOPfeatures.less46_02

// Extension function with receiver
// Функции расширения с получателем

// пример с построением HTML

/**
 *  П Р И М Е Р   Н Е   Р А З О Б Р А Н   ( С К О П И Р О В А Н   И   В С Т А В Л Е Н )
 * */

// Базовый класс для всех HTML-элементов
abstract class HtmlElement(val tagName: String) {
    val children = mutableListOf<HtmlElement>()
    var text: String = ""

    // Метод для добавления дочерних элементов
    fun <T : HtmlElement> doInit(element: T, init: T.() -> Unit) {
        element.init() // Выполняем лямбду-получатель для настройки дочернего элемента
        children.add(element)
    }

    // Метод для рендеринга HTML
    open fun render(indent: String = "", level: Int = 0): String {
        val currentIndent = indent.repeat(level)
        val childIndent = indent.repeat(level + 1)
        val childrenHtml = children.joinToString("") { it.render(indent, level + 1) }

        return buildString {
            append("$currentIndent<$tagName>")
            if (text.isNotEmpty()) {
                append(text)
            }
            if (childrenHtml.isNotEmpty()) {
                append("\n")
                append(childrenHtml)
                append("\n$currentIndent")
            }
            append("</$tagName>\n")
        }
    }
}

// Классы для конкретных HTML-тегов
class Html : HtmlElement("html") {
    fun head(init: Head.() -> Unit) = doInit(Head(), init)
    fun body(init: Body.() -> Unit) = doInit(Body(), init)
}

class Head : HtmlElement("head") {
    fun title(init: Title.() -> Unit) = doInit(Title(), init)
}

class Title : HtmlElement("title")

class Body : HtmlElement("body") {
    fun h1(init: H1.() -> Unit) = doInit(H1(), init)
    fun p(init: P.() -> Unit) = doInit(P(), init)
}

class H1 : HtmlElement("h1")
class P : HtmlElement("p")

// **********************************************
// Функция расширения с получателем для создания HTML
fun html(init: Html.() -> Unit): Html {
    val html = Html()
    html.init() // Вызываем лямбду-получатель для настройки корневого элемента Html
    return html
}


fun main() {
    val myHtmlDocument = html { // html {} - это вызов функции расширения с получателем.
        // Внутри этого блока this - это объект Html.
        head { // head {} - это вызов метода head на объекте Html.
            // head сам принимает лямбду-получатель, где this - это объект Head.
            title { // Здесь this - это объект Title.
                text = "Моя первая страница на Kotlin DSL"
            }
        }
        body { // body {} - вызов метода body на Html. this - это Body.
            h1 { // h1 {} - вызов метода h1 на Body. this - это H1.
                text = "Добро пожаловать в Ktor HTML DSL!"
            }
            p { // p {} - вызов метода p на Body. this - это P.
                text = "Это демонстрация функций расширения с получателем."
            }
            p {
                text = "Они позволяют создавать очень выразительные и читабельные DSL."
            }
        }
    }

    println(myHtmlDocument.render(indent = "  "))
}