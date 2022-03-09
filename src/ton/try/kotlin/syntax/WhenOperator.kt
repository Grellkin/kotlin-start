package ton.`try`.kotlin.syntax

fun main() {
    testWhenOp(1)
}

fun testWhenOp(x: Any) {
    when(x) {
        1 -> println("This is one")
        'c' -> println("This is с char")
        in 1..10 -> println("This one in bound of range")
        is String -> println("Looks like String")
        else -> println("NICHEGO")
    }
}