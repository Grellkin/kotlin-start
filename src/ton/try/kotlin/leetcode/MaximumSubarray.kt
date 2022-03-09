package ton.`try`.kotlin.leetcode

import kotlin.math.max

fun main() {
    println(maxSubArray(intArrayOf(-2,1,-3,4,-1,2,1,-5,4))) //-> 6
    println(maxSubArray(intArrayOf(1)))//-> 1
    println(maxSubArray(intArrayOf(5,4,-1,7,8))) //-> 23

}

fun maxSubArray(nums: IntArray): Int {

    if (nums.size == 1) {
        return nums.first()
    }

    var maxRes = nums.first()
    var currentRes = nums.first()

    for (i in 1..nums.lastIndex) {
        currentRes = max(currentRes + nums[i], nums[i])
        maxRes = max(maxRes, currentRes)
    }

    return maxRes
}