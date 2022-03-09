package ton.`try`.kotlin.leetcode

fun main() {
    println(countBits(2).contentToString())
    println(countBits(5).contentToString())
    println(countBits(9).contentToString())

    println(countBits2(2).contentToString())
    println(countBits2(5).contentToString())
    println(countBits2(9).contentToString())
}

fun countBits(n: Int): IntArray {
    if (n == 0) {
        return intArrayOf(0)
    }
    if (n == 1) {
        return intArrayOf(0, 1)
    }

    val res = IntArray(n + 1) { 0 }
    res[0] = 0
    res[1] = 1

    for (num in 2..n) {
        var leftOver = num
        while(leftOver != 1) {
            if (leftOver % 2 == 1) {
                res[num]++
            }
            leftOver = leftOver shr 1
        }
        res[num]++
    }

    return res
}

fun countBits2(n: Int): IntArray {
    val res = IntArray(n + 1) { 0 }

    for (i in 1..n) {
        res[i] = res[i shr 1] + (i % 2)
    }
    return res
}