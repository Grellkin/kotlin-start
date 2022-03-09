package ton.`try`.kotlin.leetcode

fun main() {
    println(search(intArrayOf(-2,0,3,5,9,12), 9)) //4
    println(search(intArrayOf(-1,0,3,5,9,12), 2)) //-1
    println(search(intArrayOf(-1,0,3,5,9,12), 12)) //5
    println(search(intArrayOf(-1,0,3,5,9,12), -1)) //0
    println(search(intArrayOf(-1), -1)) //0
}


fun search(nums: IntArray, target: Int): Int {
    var start = 0
    var end = nums.lastIndex

    while (start <= end) {
        val middle: Int = (end - start) / 2
        val middleVal = nums[start + middle]
        if (middleVal == target) {
            return start + middle
        }
        if (middleVal > target) {
            end = start + middle - 1
        } else {
            start = start + middle + 1
        }
    }
    return -1
}

fun search2(nums: IntArray, target: Int): Int {
    val res = nums.binarySearch(target)
    return if (res < 0) -1 else res
}