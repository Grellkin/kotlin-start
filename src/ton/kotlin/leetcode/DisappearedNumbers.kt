package ton.kotlin.leetcode


fun main() {
    //1,2,3,4
    println(findDisappearedNumbers(intArrayOf(4,3,2,7,8,2,3,1))) // -> 5,6
    println(findDisappearedNumbers(intArrayOf(1,1))) // -> 2


    println(findDisappearedNumbers2(intArrayOf(4,3,2,7,8,2,3,1))) // -> 5,6
    println(findDisappearedNumbers2(intArrayOf(1,1))) // -> 2
}

fun findDisappearedNumbers(nums: IntArray): List<Int> {
    val array = BooleanArray(nums.size)
    for (num in nums) {
        array[num-1] = true
    }

    val mutableListOf = mutableListOf<Int>()
    for ((index, value) in array.withIndex()) {
        if (!value) {
            mutableListOf.add(index+1)
        }
    }
    return mutableListOf
}

fun findDisappearedNumbers2(nums: IntArray): List<Int> {
    var index = 0
    while (index < nums.size) {
        val value = nums[index]
        val correctIndex = value - 1
        if (nums[correctIndex] != value) {
            nums[correctIndex] = value.also { nums[index] = nums[correctIndex] } //swap elements
        } else {
            index++
        }
    }
    val resList = mutableListOf<Int>()

    for((indexs, value) in nums.withIndex()) {
        if (value - 1 != indexs) {
            resList.add(indexs+1)
        }
    }
    return resList
}