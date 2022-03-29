package ton.kotlin.syntax

fun main() {
    val letterList = listOf("a", "b", "cd", "c", "caa")
    val numberList = listOf(1, 2, 3, 6, 7, 6)

    letterList.forEach {shalom -> println(shalom)}

    val takeLast = numberList.takeLast(1)
    println(takeLast)


    println(letterList.sortedByDescending { e -> e.length })
    val (list, list1) = letterList.partition { a -> a.equals("b") }

    println(list)
    println(list1)

    val kotTon = KotTon(true, "kikus terier")
    val sobaki = kotTon.sobaki

}