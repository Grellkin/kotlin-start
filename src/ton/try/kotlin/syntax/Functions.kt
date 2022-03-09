package ton.`try`.kotlin.syntax

fun main() {
    val res = testNamedArguments(name = "kikosik", y = 14.4, age = 33)
    println(res)

    testDefaultArgs(x = 7)

    testVaragr(1, 2, 3 ,4)
    val list = listOf(5, 6, 7, 9)
    //check here * which cast array to vararg
    println("Lets have pause here for a minute")
    testVaragr(*list.toIntArray(), 12)
}

fun testOne(x: Int, y: Int): Int {
    return x + y
}

fun testNamedArguments(age: Int, y: Double, name: String): String {
    return "This is $name with age $age and weight $y"
}

fun testDefaultArgs(x: Int = 8, y: Float = 11.1f) {
    println(x + y)
}

fun testVaragr(vararg g: Int) {
    g.forEach { u -> if (u%2 == 0) println(u)}
}