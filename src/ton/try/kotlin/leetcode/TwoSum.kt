package ton.`try`.kotlin.leetcode

import kotlin.math.max
import kotlin.math.min

fun main() {
    println(twoSum(intArrayOf(2,7,11,15), 9).contentToString())
    println(twoSum(intArrayOf(3, 2, 4), 6).contentToString())
    println(twoSum(intArrayOf(3, 3), 6).contentToString())
    println(twoSum(intArrayOf(1, 5, 6, 4, 6, 9, 12, 11, 3), 20).contentToString())
}


fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>()

    for (i in 0..nums.lastIndex) {
        val v = target - nums[i]
        if (map.containsKey(v)) {
            return intArrayOf(map.get(v)!!, i)
        }
        map.put(nums[i], i)
    }
    return intArrayOf()
}


fun twoSum2(nums: IntArray, target: Int): IntArray {
    val sorted = nums.sortedArray()
    for (i in 0..nums.lastIndex) {
        val resIndex = binarySearchCustom(sorted, target - sorted[i], i, nums.lastIndex, i)
        if (resIndex >= 0) {
            val first = findFromStart(nums, sorted[min(i, resIndex)])
            val second = findFromEnd(nums, sorted[max(i, resIndex)])
            return intArrayOf(min(first, second), max(first, second) )
        }
    }
    return intArrayOf(0, 1)
}

fun findFromStart(nums: IntArray, target: Int): Int {
    for (i in 0..nums.lastIndex) {
        if (nums[i] == target) {
            return i
        }
    }
    return -1
}

fun findFromEnd(nums: IntArray, target: Int): Int {
    for (i in nums.lastIndex downTo 0 ) {
        if (nums[i] == target) {
            return i
        }
    }
    return -1
}

fun binarySearchCustom(nums: IntArray, target: Int, fromIndex: Int, toIndex: Int, excludeIndex: Int): Int {
    if (fromIndex > toIndex) {
        return -1
    }

    val middleIndex = fromIndex + (toIndex - fromIndex) / 2
    val middleVal = nums[middleIndex]

    if (middleVal == target) {
        if (middleIndex != excludeIndex) {
            return middleIndex
        }
        if ((middleIndex > 0) && (nums[middleIndex - 1] == target)) {
            return middleIndex - 1
        }

        if ((middleIndex < nums.lastIndex) && (nums[middleIndex + 1] == target)) {
            return middleIndex + 1
        }
        return -1
    }

    if (middleVal > target) {
        return binarySearchCustom(nums, target, fromIndex, middleIndex - 1, excludeIndex)
    }
    return binarySearchCustom(nums, target, middleIndex + 1, toIndex, excludeIndex)
}