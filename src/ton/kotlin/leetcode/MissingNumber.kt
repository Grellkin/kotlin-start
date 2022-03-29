package ton.kotlin.leetcode

fun main() {
    println(missingNumber(intArrayOf(3,0,1)))
    println(missingNumber(intArrayOf(0,1)))
    println(missingNumber(intArrayOf(9,6,4,2,3,5,7,0,1)))

    println(missingNumber(intArrayOf(2,1)))
}

//using ariphmetic progression
fun missingNumber(nums: IntArray): Int {
    val a1 = 0;
    val d = 1;
    val n = nums.size + 1
    val sum = (a1 + a1 + d*(n-1))*n/2
    val sumFact = nums.sum()
    return sum - sumFact
}