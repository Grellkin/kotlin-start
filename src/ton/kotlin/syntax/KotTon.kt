package ton.kotlin.syntax

class KotTon(val like: Boolean, var kind: String) {

    val sobaki: String
    get() {
        return if (like) kind else "no way"
    }
}