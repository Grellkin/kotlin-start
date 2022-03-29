package ton.kotlin.leetcode

fun main() {
    println(singleNumber(intArrayOf(2,2,1)))
    println(singleNumber(intArrayOf(4,1,2,1,2)))
    println(singleNumber(intArrayOf(1)))
}

fun singleNumber(nums: IntArray): Int {
    var mask = 0
    for(num in nums) {
        mask = mask.xor(num)
    }
    return mask
}