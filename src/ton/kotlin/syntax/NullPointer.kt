package ton.kotlin.syntax

fun main() {

    var kika = "Hello"
    gelengik(10, kika)
    gelengik(10, null)

    var ton: String? = "12"

    ton = null

    //если тут строка то вернет length, а если null -> null
    val value = ton?.length
    println(value)

    //если тут строка то вернет length, а если null -> Kika (благодаря ?:)
    val value1 = ton?.length ?: "Kika"
    println("This is result of elvis operator: $value1")

    //если хотим, чтобы в случае null была ошибка, то
    println(garna()!!.length)

}

fun garna(): String? {
    return if(Math.random() * 100 > 45) "10" else null
}

fun gelengik(x: Int, y: String?) {
    println("$x + ${y?.length}")
}