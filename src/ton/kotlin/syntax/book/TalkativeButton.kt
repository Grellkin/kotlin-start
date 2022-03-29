package ton.kotlin.syntax.book

import java.util.*
import kotlin.Comparator

internal open class TalkativeButton() {

    var name: String? = null

    constructor(name: String) : this() {
        this.name = name
    }

    private fun yell() = print("Hey")
    protected fun gou() = print("No hey")
}

internal fun TalkativeButton.gatman() {
//    this.gou()
}

internal class ReallyTalkativeButton: TalkativeButton {

    constructor(diabolo: Int) {
        this.diabolo = diabolo
        this.nameTwo = "hoba"
    }

    constructor(realName: String, fakeName: String) : super(realName) {
        this.nameTwo = fakeName
    }

    var nameTwo: String

    var diabolo: Int? = null
        private set

    init {
        println("Ni santo ni diabolo!")
//        this.diabolo = 22
    }

    fun benGan(ini: Int) {
        println("Salm")
    }

}

fun main() {
    val rtb = ReallyTalkativeButton(12)
    rtb.benGan(12)
    println(rtb.diabolo)


    val cow = ton.kotlin.syntax.book.Cow(22)
    val kikus = NemitiyKik("sup", cow)
    val copyKik = kikus.copy() //shalow copy, nested object have same references, it means if you change something in
    // one place it will be changed everywhere

    copyKik.nemity.amountOfMilk = 24

    println(copyKik.nemity.giveMilk())
    println(cow.giveMilk())

    println(kikus)

    val niceOne = NiceOne(99, 7.8)

    val treeMap = TreeMap<Int?, String>(NiceOne)

    TreeMap<Int, String>(object : Comparator<Int> {
        override fun compare(o1: Int?, o2: Int?): Int {
            return -1
        }
    })

    NiceOne.kusMarus("Perp")

    NiceOne.kekes(22)
}

class NiceOne(var size: Int, var length: Double = 10.0) {

    companion object Sravnitel : Comparator<Int?> {

        override fun compare(o1: Int?, o2: Int?): Int {
            return when {
                (o1 == null && o2 == null) -> 0
                (o1 == null) -> -1
                (o2 == null) -> 1
                else -> o1.compareTo(o2)
            }
        }

        fun kusMarus(name: String) {
            println(name)
        }
    }
}


fun NiceOne.Sravnitel.kekes(count: Int) {
    println("hello it`s kekes!")
}

