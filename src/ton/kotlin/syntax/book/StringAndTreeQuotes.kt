package ton.kotlin.syntax.book

fun main() {
    "from-a-to-be".split("sup")
    "from-a-to-be".split("\\.".toRegex()) //like in java escape . to print exact dot, and escape \ with \ => \\.
    "from-a-to-be".split("""\.""".toRegex()) //we don`t need \ escaper of esaper, just \.


    val reg = """(\d+)-(\d+)-(\d+)""".toRegex()
    val date = "2022-03-20"

    val matchRes = reg.matchEntire(date)
    if (matchRes != null) {
        val (year, month, day) = matchRes.destructured
        println("Year is $year, month is $month, day is $day")
    }
}