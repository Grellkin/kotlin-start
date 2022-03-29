package ton.kotlin.leetcode

import kotlin.math.max


fun main() {
    println(maxProfit(intArrayOf(7,1,5,3,6,4))) //-> 5
    println(maxProfit(intArrayOf(7,6,4,3,1))) // -> 0
    println(maxProfit(intArrayOf(7,2,10,1,8,5,6))) //-> 8
}

fun maxProfit(prices: IntArray): Int {
    val minArray = prices.copyOf()

    var minV = prices.first()

    for ((i, v) in prices.withIndex()) {
        if (v < minV) {
            minV = v
        }
        minArray[i] = minV
    }

    var maxV = prices.last()
    var maxProfit = 0

    for (i in prices.lastIndex downTo 0) {
        if (prices[i] > maxV) {
            maxV = prices[i]
        }
        val profit = maxV - minArray[i]
        if (profit > maxProfit) {
            maxProfit = profit
        }
    }

    return maxProfit
}