package ton.kotlin.syntax.book

fun main(ara: Array<Int>) {
    val list = listOf(12, 15, *ara) //insight listOf parameter is reference Type T, which mean you should use Array<Int>, что на самом деле Integer[]
    varaOper(10, *list.toIntArray()) //а тут наоборот, примитив в варарге и поэтому надо примитив intArray
}


fun varaOper(vararg goshany: Int) {

    var (first, second) = 12 to "twelwe" //equavalent of pair(12, "twelwe")

    mapOf<String, Double>("pep" to 11.0, "kep" to 12.0)

}