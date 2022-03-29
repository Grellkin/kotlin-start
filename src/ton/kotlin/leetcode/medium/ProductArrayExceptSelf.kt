package ton.kotlin.leetcode.medium

fun main() {
    println(productExceptSelf(intArrayOf(1,2,3,4)).contentToString())
    println(productExceptSelf(intArrayOf(-1,1,0,-3,3)).contentToString())
}


fun productExceptSelf(nums: IntArray): IntArray {
    val fromLeft = IntArray(nums.size)
    fromLeft[0] = 1
    val fromRight = IntArray(nums.size)
    fromRight[fromRight.lastIndex] = 1
    var l = 1
    var e = nums.lastIndex - 1

    while (l < nums.size) {
        fromLeft[l] = fromLeft[l-1] * nums[l-1]
        fromRight[e] = fromRight[e+1] * nums[e+1]
        l++
        e--
    }
    for (i in fromLeft.indices) {
        fromLeft[i] *= fromRight[i]
    }

    return fromLeft
}