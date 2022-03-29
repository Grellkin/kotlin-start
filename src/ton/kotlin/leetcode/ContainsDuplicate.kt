package ton.kotlin.leetcode

fun main() {
    println(containsDuplicate(intArrayOf(1,2,3,1)))
    println(containsDuplicate(intArrayOf(1,2,3,4)))
    println(containsDuplicate(intArrayOf(1,1,1,3,3,4,3,2,4,2)))

    println("Check second function")

    println(containsDuplicate2(intArrayOf(1,2,3,1)))
    println(containsDuplicate2(intArrayOf(1,2,3,4)))
    println(containsDuplicate2(intArrayOf(1,1,1,3,3,4,3,2,4,2)))
}


/*
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 */
fun containsDuplicate(nums: IntArray): Boolean {
    val checkSet = mutableSetOf<Int>()
    for (num in nums) {
        if (checkSet.contains(num)) {
            return true
        }
        checkSet.add(num)
    }
    return false
}

fun containsDuplicate2(nums: IntArray): Boolean {
    return nums.toHashSet().size < nums.size
}