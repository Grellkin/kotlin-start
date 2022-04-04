package ton.kotlin.leetcode

fun main() {
    val s = charArrayOf('h', 'e', 'l', 'l')
    reverseString(s)
    println(s.concatToString())
}


fun reverseString(s: CharArray): Unit {
    var left = 0
    var right = s.lastIndex

    for (i in 1..(s.size/2)) {
        s[left] = s[right].also { s[right] = s[left] }
        left++
        right--
    }
}