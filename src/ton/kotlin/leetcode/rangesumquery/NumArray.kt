package ton.kotlin.leetcode.rangesumquery

class NumArray(nums: IntArray) {

    val firstSum: IntArray

    init {
        firstSum = IntArray(nums.size)
        firstSum[0] = nums[0]
        for (i in 1..nums.lastIndex) {
            firstSum[i] = nums[i] + firstSum[i-1]
        }
    }

    fun sumRange(left: Int, right: Int): Int {
        if (left == 0) return firstSum[right]
        return firstSum[right] - firstSum[left - 1]
    }

}