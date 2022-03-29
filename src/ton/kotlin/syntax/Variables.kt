package ton.kotlin.syntax

fun main() {
    val kika: String = "hello it`s kika"
    val ton = "hello it`s ton without type"

    println("Print here kika speech: $kika and ton speech: $ton")
    println("Print here something ${notMain(kika, ton)}")

}

fun notMain(kiks: String, tons: String): String {
    return kiks.plus(tons)
}