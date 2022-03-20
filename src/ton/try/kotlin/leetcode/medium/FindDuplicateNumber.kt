package ton.`try`.kotlin.leetcode.medium

import kotlin.math.abs


fun main() {
    println(findDuplicate(intArrayOf(1,1,1,1,1)))
    println(findDuplicate(intArrayOf(1,1,1,2,3,4)))
    println(findDuplicate(intArrayOf(1,7,7,2,3,4,5,6,7,8)))

    val intArray = IntArray(1000)
    for (i in 0..999) {
        intArray[i] = i+1
    }
    println(intArray.contentToString())
}


//fun findDuplicate(nums: IntArray): Int {
//}

fun findDuplicate(nums: IntArray): Int {
    var halfSize = nums.size / 2
    var halfSizePrevious = 0
    var leftBound = 0
    var rightBound = nums.size

    while(true) {
        var counterEq = 0
        var counterLess = 0
        var counterMore = 0

        for (v in nums) {
            if (v < leftBound || v > rightBound) {
                continue
            }

            if (v == halfSize) {
                counterEq++
                counterLess++
            } else if (v < halfSize) {
                counterLess++
            } else {
                counterMore++
            }
        }

        if (counterEq > 1) {
            return halfSize
        }

        var abs = abs((halfSizePrevious - halfSize) / 2)
        if (abs < 1) {
            abs = 1
        }

        if (counterLess > counterMore) {
            rightBound = halfSize
            halfSize -= abs.also { halfSizePrevious = halfSize }
        } else {
            leftBound = halfSize
            halfSize += abs.also { halfSizePrevious = halfSize }
        }
    }
}