package ton.`try`.kotlin.leetcode

import kotlin.math.abs

fun main() {
    println(sortedSquares(intArrayOf(-4,-1,0,3,10)).contentToString())
    println(sortedSquares(intArrayOf(-7,-3,2,3,11)).contentToString())
}

fun sortedSquares(nums: IntArray): IntArray {
    val res = IntArray(nums.size)
    var left = 0
    var right = nums.lastIndex
    var pointer = right

    while (left <= right) {
        val leftVal = nums[left] * nums[left]
        val rightVal =  nums[right] * nums[right]
        if (rightVal > leftVal) {
            res[pointer] = rightVal
            right--
        } else {
            res[pointer] = leftVal
            left++
        }
        pointer--
    }

    return res
}


fun sortedSquares2(nums: IntArray): IntArray {
    val res = IntArray(nums.size)
    var left = 0
    var right = nums.lastIndex
    var pointer = right
    
    while (left <= right) {
        val leftVal = abs(nums[left])
        val rightVal =  abs(nums[right])
        if (rightVal > leftVal) {
            res[pointer] = rightVal * rightVal
            right--
        } else {
            res[pointer] = leftVal * leftVal
            left++
        }
        pointer--
    }

    return res
}