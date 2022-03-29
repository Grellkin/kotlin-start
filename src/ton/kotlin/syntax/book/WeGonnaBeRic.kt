package ton.kotlin.syntax.book

fun findColor(color: Color): String {
    return when(color) {
        Color.KIKS -> "This is Kika"
        Color.TON -> "This is Ton"
        Color.KOT -> "It`s cat! Arrr"
    }
}