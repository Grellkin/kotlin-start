package ton.`try`.kotlin.syntax

fun main() {
    val mutableListOf = mutableListOf("kika", "ton")

    //iterate through values
    for (inem in mutableListOf) {
        println(inem)
    }
    //iterate through indexes
    for (i in mutableListOf.indices) {
        println(i)
    }
    //iterate through indexes and values
    for ((i, v) in mutableListOf.withIndex()) {
        println("This is index: $i and his value: $v")
    }
    //while
    var size = 0
    while (mutableListOf.size > size) {
        println("Current index is $size, and his element is ${mutableListOf[size]}")
        size++
    }

    //diapasons
    println(7 in 4..10)

    // []
    for (n in 4..10) {
        println(n)
    }

    //open right brace {]
    for (n in 5 until 7) {
        println(n)
    }

    for (n in 50 downTo 3 step 14) {
        println(n)
    }



}